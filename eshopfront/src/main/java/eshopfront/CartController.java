package eshopfront;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Firstproject.eshop.Dao.CartItemDAO;
import Firstproject.eshop.Dao.ProductDAO;
import Firstproject.eshop.Dao.UserDAO;
import Firstproject.eshop.Model.CartItem;
import Firstproject.eshop.Model.Product;
import Firstproject.eshop.Model.UserDetail;

public class CartController 
{
	@Autowired
	CartItemDAO cartItemDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/updateAddress")
	public String updateAddress(@RequestParam("address") String address,String usernane ,Model m, HttpSession session)
	{
		
		String username=(String)session.getAttribute("username");
		
		List<CartItem>listCart=cartItemDAO.listCartItem(username);
		UserDetail user=userDAO.getUserDetail(username);
		user.setAddress(address);
		userDAO.updateUser(user);
		m.addAttribute("listCart",listCart);
		m.addAttribute("grandTotal", this.calcGrandTotal(listCart));
		m.addAttribute("addr",user.getAddress());
		
		return "OrderConfirm";
	}
	
	@RequestMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		String username="jason";
		
		CartItem cart=new CartItem();
		cart.setProductId(product.getProductId());
		cart.setProductName(product.getProductName());
		cart.setQuantity(quantity);
		cart.setPrice(product.getPrice());
		cart.setUserName(username);
		cart.setStatus("NP");
		
		cartItemDAO.addCart(cart);
		
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandTotal", this.calcGrandTotal(listCartItems));
		
		return "Cart";
		
	}
	
	@RequestMapping("/deleteCartItem/{cartItemId)")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m)
	{
		CartItem cart=cartItemDAO.getCart(cartItemId);
		cartItemDAO.deleteCart(cart);
		
		String username="jason";
		
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandTotal", this.calcGrandTotal(listCartItems));
		
		return "Cart";
	}
	
	@RequestMapping("/updateCartItem/{cartItemId}")
    public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,Model m)
    {
		CartItem cart=cartItemDAO.getCart(cartItemId);
		cart.setQuantity(quantity);
		
		cartItemDAO.updateCart(cart);
		
		String username="jason";
		
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandTotal", this.calcGrandTotal(listCartItems));
		
		return "Cart";
    }
	
	
	public int calcGrandTotal(List<CartItem> listCartItems)
	{
		int count=0,grandTotal=0;
		
		while(count<listCartItems.size());
		{
			grandTotal=grandTotal+(listCartItems.get(count).getQuantity()*listCartItems.get(count).getPrice());
			count++;
		}
		
		return grandTotal;
	}
}
	

