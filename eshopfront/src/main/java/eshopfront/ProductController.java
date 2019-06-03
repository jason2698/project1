package eshopfront;


import java.util.List;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Firstproject.eshop.Dao.CategoryDAO;
import Firstproject.eshop.Dao.ProductDAO;
import Firstproject.eshop.Model.Category;
import Firstproject.eshop.Model.Product;

@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/product")
	public String showProduct(Model m)
	{
		Product product=new Product();
		m.addAttribute("product", product);
		
		List<Product>productList=productDAO.getProductList();
		m.addAttribute("productList", productList);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "product";
	}

	public LinkedHashMap<Integer,String> getCategoryList(List<Category> categoryList)
	{
		LinkedHashMap<Integer,String> listCategory=new LinkedHashMap<Integer,String>();
		
		int i=0;
		while(i<categoryList.size())
		{
			Category category=(Category)categoryList.get(i);
			listCategory.put(category.getCategoryId(), category.getCategoryName());
			i++;
		}
		
	    return listCategory;
	}


	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,Model m)
	{
		productDAO.addProduct(product);
		List<Product> productList=productDAO.getProductList();
		m.addAttribute("productList", productList);
		
		Product product1=new Product();
		m.addAttribute("product", product1);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "Product";
	}

	@RequestMapping(value="/deleteProduct/(productId)")
	public String deleteCategory(@PathVariable("productId")int productId,Model m)
	{
	    Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);

		List<Product>productList=productDAO.getProductList();
		m.addAttribute("productList", productList);

		Product product1=new Product();
		m.addAttribute("product", product1);

		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "Product";	
	}

	

	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		m.addAttribute("product", product);
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		return "updateproduct";
	}
	
	
	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	 public String updateProduct(Model m,@ModelAttribute("product")Product product)
	 {
		productDAO.updateProduct(product);
		 
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
			
		Product product1=new Product();
		m.addAttribute("product", product1);
		 
		List<Product> listProducts=productDAO.getProductList();
		m.addAttribute("productList",listProducts);
		
		return "product";
	 }

}
