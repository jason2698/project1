package eshopfront;


import java.util.List;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Firstproject.eshop.Dao.CategoryDAO;
import Firstproject.eshop.Dao.ProductDAO;
import Firstproject.eshop.Dao.SupplierDAO;
import Firstproject.eshop.Model.Category;
import Firstproject.eshop.Model.Product;
import Firstproject.eshop.Model.Supplier;

@Controller
public class ProductController 
{
	@Autowired
	 CategoryDAO categoryDAO;
	 
	 @Autowired
	 ProductDAO productDAO;
	 
	 @Autowired
	 SupplierDAO supplierDAO;
	 
	 @RequestMapping("/product")
	 public String showProduct(Model m)
	 {
		Product product = new Product();
		m.addAttribute(product);
		
		List<Product> listProducts=productDAO.getProductList();
		m.addAttribute("productList",listProducts);
		
		m.addAttribute("categoryList", this.GetCategories());
		
		m.addAttribute("supplierList", this.GetSuppliers());

		m.addAttribute("pageinfo","Manage Product");
		
		  return "product";
	 }
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,Model m,@RequestParam("pimage")MultipartFile filedet )
	{
		productDAO.addProduct(product);
		Product product1=new Product();
		m.addAttribute(product1);
		
		m.addAttribute("categoryList", this.GetCategories());
		m.addAttribute("supplierList", this.GetSuppliers());
		
		String imgpath= "";
		imgpath=imgpath+String.valueOf(product.getProductId())+".jpg";
		File image=new File(imgpath);
		if(!filedet.isEmpty())
		{
			try 
			{
				byte buff[]=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs= new BufferedOutputStream(fos);
				bs.write(buff);
				bs.close();

			}
			
			catch(Exception e)
			{
				
			m.addAttribute("errorInfo","Error occured during Image uploading");
				
			}
		}
		else
		{
			
			m.addAttribute("errorInfo","Error occured trying to upload image");

		}
	    List<Product> listProducts=productDAO.getProductList();
		m.addAttribute("productList",listProducts);
		m.addAttribute("pageinfo","Manage Product");
		  
		return "product";

	}


	@RequestMapping(value="/productdisplay")
	public String displayallproducts(Model m)
	{
		List<Product> listProducts=productDAO.getProductList();
		m.addAttribute("productList",listProducts);
		m.addAttribute("pageinfo","Product Catalog");
		
		return "productdisplay";
	}
	

	@RequestMapping(value="/totalproductdisplay/{productID}")
	public String totalproductdisplay(@PathVariable("productID")int productID,Model m)
	{
		m.addAttribute("pageinfo","Product Information");
		Product product=productDAO.getProduct(productID);
		m.addAttribute("product",product);
		
		return "totalproductdisplay";
	}





	public LinkedHashMap<Integer,String> GetCategories()
	{
		 List<Category> listCategories=categoryDAO.listCategories();
	     LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
	     for(Category category:listCategories)
	     {
	    	 categoryList.put(category.getCategoryId(),category.getCategoryName());
	     }
	     return categoryList;
	}

	public LinkedHashMap<Integer,String> GetSuppliers()
	{
		 List<Supplier> listSuppliers=supplierDAO.listSuppliers();
	     LinkedHashMap<Integer,String> supplierList=new LinkedHashMap<Integer,String>();
	     for(Supplier supplier:listSuppliers)
	     {
	    	 supplierList.put(supplier.getSupplierId(),supplier.getSupplierName());
	     }
	     return supplierList;
	         
	}

	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product,Model m)
	{ 
		m.addAttribute("categoryList", this.GetCategories());
		m.addAttribute("supplierList", this.GetSuppliers());
		productDAO.updateProduct(product);
	    Product product1=new Product();
	    m.addAttribute(product1);
	     
	    
	    List<Product> listProducts=productDAO.getProductList();
	 	m.addAttribute("productList",listProducts);
	 	m.addAttribute("pageinfo","Manage Product");
	 	
	 	return "product";
	}
	@RequestMapping(value="/deleteProduct/{productID}")
	public String deleteProduct(@PathVariable("productID")int productID,Model m)
	{
		Product product=productDAO.getProduct(productID);
		productDAO.deleteProduct(product);
		 
		m.addAttribute("categoryList", this.GetCategories());
		m.addAttribute("supplierList", this.GetSuppliers());
		 
		List<Product> listProducts=productDAO.getProductList();
		Product product1=new Product();
		m.addAttribute(product1);

		m.addAttribute("productList",listProducts);
		m.addAttribute("pageinfo","Manage Product");
		
		return "product";
	}

	@RequestMapping(value="/editProduct/{productID}")
	public String editProduct(Model m,@PathVariable("productID")int productID)
	{
		Product product=productDAO.getProduct(productID);
		m.addAttribute(product);
		
		m.addAttribute("pageinfo","Manage Product");
		
		return "UpdateProduct";

	}

	 
	}