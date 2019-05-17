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
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    	context.scan("Firstproject.eshop");
        context.refresh();
    	
    	categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
    }
    
    @Ignore
    @Test
    public void addCategoryTest()
    {
    	Category category=new Category();
    	category.setCategoryName("Tshirt");
    	category.setCategoryDesc("T-Shirt with round neck collar of all Brands");
    	
    	assertTrue("problem in Adding Category",categoryDAO.addCategory(category));
    }
    
    @Test
    public void deleteCategoryTest()
    {
    	Category category=categoryDAO.getCategory(3);
    	
    	assertTrue("problem in deleting Category",categoryDAO.deleteCategory(category));
    }
    	
    @Ignore
    @Test
    public void updateCategoryTest()
    {
        Category category=categoryDAO.getCategory(3);
    	category.setCategoryName("Raymond-Shirt");
    	
    	assertTrue("problem in deleting Category",categoryDAO.updateCategory(category));
    }
    
    @Ignore
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
