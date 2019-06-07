package eshopfront;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Firstproject.eshop.Dao.CategoryDAO;
import Firstproject.eshop.Model.Category;

@Controller
public class CategoryController 
{

	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/category")
	public String showCategoryPage(Model m)
	{
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",categoryList);
		return "category";
	}
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
		Category category=new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.addCategory(category);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",categoryList);
		
		return "category";
	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		m.addAttribute("category", category);

		
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		
		categoryDAO.deleteCategory(category);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",categoryList);
		
		return "category";
	}
	
	@RequestMapping(value="/UpdateCategory{categoryId}",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catId") int categoryId,@RequestParam("catName") String categoryName,@RequestParam("catDesc") String categoryDesc,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",categoryList);
		
		return "category";
		
	}
}
