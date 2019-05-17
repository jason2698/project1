package Firstproject.eshop.Dao;

import java.util.List;

import Firstproject.eshop.Model.Product;

public interface ProductDAO 
{
public boolean addProduct(Product product);
public boolean deleteProduct(Product product);
public boolean updateProduct(Product product);
public List<Product> getProductList();
public List<Product> getProductListCategoryWise(int categoryId);
Product getProduct(int productId);
}
