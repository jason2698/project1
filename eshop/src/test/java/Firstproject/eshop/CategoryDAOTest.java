package Firstproject.eshop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Firstproject.eshop.Dao.CategoryDAO;
import Firstproject.eshop.Model.Category;

public class CategoryDAOTest 
{
	 static CategoryDAO categoryDAO;
	    
	    @BeforeClass
	    public static void executeFirst()
	    {
	    	@SuppressWarnings("resource")
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    	context.scan("Firstproject.eshop");
	        context.refresh();
	    	
	    	categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	    }
	    
	   
	    @Test
	    public void addCategoryTest()
	    {
	    	Category category=new Category();
	    	category.setCategoryName("Samsung Mobile");
	    	category.setCategoryDesc("All Samsung Mobiles");
	    	
	    	assertTrue("problem in Adding Category",categoryDAO.addCategory(category));
	    }
	    
	    @Ignore
	    @Test
	    public void deleteCategoryTest()
	    {
	    	Category category=categoryDAO.getCategory(2);
	    	
	    	assertTrue("problem in deleting Category",categoryDAO.deleteCategory(category));
	    }
	    	
	    @Ignore
	    @Test
	    public void updateCategoryTest()
	    {
	        Category category=categoryDAO.getCategory(3);
	    	category.setCategoryName("OnePlus Mobile Phone");
	    	
	    	assertTrue("problem in deleting Category",categoryDAO.updateCategory(category));
	    }
	    
	    
	    @Test
	    public void listCategoryTest()
	    {
	    	List<Category> categoryList=categoryDAO.listCategories();
	    	
	    	assertTrue("problem in listing categories",categoryList.size()>0);
	    	
	    	for(Category category:categoryList)
	    	{
	    		System.out.print(category.getCategoryId()+":::");
	    		System.out.print(category.getCategoryName()+":::");
	    		System.out.print(category.getCategoryDesc());
	    	}
	    }
}