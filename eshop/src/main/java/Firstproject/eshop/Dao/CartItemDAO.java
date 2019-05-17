package Firstproject.eshop.Dao;

import java.util.List;

import Firstproject.eshop.Model.CartItem;
import Firstproject.eshop.Model.CustomerOrder;
import Firstproject.eshop.Model.UserDetail;

public interface CartItemDAO {
	void addToCart(CartItem cartItem);
	UserDetail getUser(String email);
	List<CartItem>  getCart(String email);
	void removeCartItem(int cartItemId);
	CustomerOrder createCustomerOrder(CustomerOrder customerOrder);
}
