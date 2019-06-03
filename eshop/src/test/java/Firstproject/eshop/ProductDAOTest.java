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
	product.setProductName("Raymond-Formal");
	product.setProductDesc("Formal shirt with Neck with Excellent color");
	product.setPrice(800);
	product.setStock(50);
	product.setCategoryId(3);
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
		product.setProductName("Raymond-Formal shirt");
		product.setPrice(1050);
		
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
