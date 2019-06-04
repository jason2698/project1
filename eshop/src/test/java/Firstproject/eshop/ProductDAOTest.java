package Firstproject.eshop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Firstproject.eshop.Dao.ProductDAO;
import Firstproject.eshop.Model.Product;

public class ProductDAOTest
{
static ProductDAO productDAO;

@BeforeClass
public static void executeFirst()
{
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	
	context.scan("Firstproject.eshop");
	
	context.refresh();
	
	productDAO=(ProductDAO)context.getBean("productDAO");
	
}
    

   
@Test
public void addProductTest()
{
	Product product=new Product();
	product.setProductName("Apple Iphone x");
	product.setProductDesc("Mobile with 4G connectivity and 12MP Back camera, 8MP Front Camera");
	product.setPrice(80000);
	product.setStock(50);
	product.setCategoryId(1);
	product.setSupplierId(2);
	
	assertTrue("Problem in Adding category",productDAO.addProduct(product));
}
    
    
   
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(2);
		assertTrue("Problem in deleting Product",productDAO.deleteProduct(product));
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(3);
		product.setProductName("OnePlus Mobile");
		product.setPrice(50000);
		
		assertTrue("Problem in deleting Product",productDAO.updateProduct(product));
	}
	@Ignore
	@Test
	public void showProductList()
	{
		List<Product>productList=productDAO.getProductList();
		
		assertTrue("Problem in Listing the Products",productList.size()>0);
		
		for(Product product:productList)
		{
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.print(product.getPrice());
		}
	}
}
