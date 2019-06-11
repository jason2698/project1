package eshopfront;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
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
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(listCart));
		m.addAttribute("addr",user.getAddress());
		
		return "OrderConfirm";
	}
	
	
	
	
	@RequestMapping("/totalproductdisplay/addToCart/{productId}")
	public String addCart(@RequestParam("quantity")int quantity,@PathVariable("productId")int productId,Model m, HttpSession session)
	{
		Product product=productDAO.getProduct(productId);
		String username=(String)session.getAttribute("username");
		
		CartItem cart=new CartItem();
		cart.setProductId(product.getProductId());
		cart.setProductName(product.getProductName());
		cart.setPrice(product.getPrice());
		cart.setStatus(username);
		cart.setQuantity(quantity);
		cart.setUserName(username);
		cartItemDAO.addCart(cart);
		List<CartItem>listCartItem=cartItemDAO.listCartItem(username);
		m.addAttribute("listCart",listCartItem);
		m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItem));
		return "cart";
	}
	
	@RequestMapping("/deleteCartItem/{cartItemId)")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session)
	{
		CartItem cart=cartItemDAO.getCart(cartItemId);
		cartItemDAO.deleteCart(cart);
		
		String username=(String)session.getAttribute("username");
		
		List<CartItem> listCartItem=cartItemDAO.listCartItem(username);
		m.addAttribute("listCartItem", listCartItem);
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(listCartItem));
		
		return "cart";
	}
	
	@RequestMapping("/OrderConfirm")
	public String orderConfirm(Model m, HttpSession session)
	{
		
		String username=(String)session.getAttribute("username");
		System.out.println("from order confirm"+username);
		List<CartItem>listCartItem=cartItemDAO.listCartItem(username);
		UserDetail user=userDAO.getUserDetail(username);
		
		System.out.println("from cart contoller "+user);
		m.addAttribute("cartItems", listCartItem);
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(listCartItem));
		m.addAttribute("address",user.getAddress());
				
		
		return "OrderConfirm";
	}
	
	@RequestMapping("/updateCartItem/{cartItemId}")
    public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
    {
		CartItem cart=cartItemDAO.getCart(cartItemId);
		cart.setQuantity(quantity);
		
		cartItemDAO.updateCart(cart);
		
		String username=(String)session.getAttribute("username");
		
		List<CartItem> listCartItem=cartItemDAO.listCartItem(username);
		m.addAttribute("cartItems", listCartItem);
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(listCartItem));
		
		return "cart";
    }
	
	
	public int calcGrandTotalPrice(List<CartItem> listCartItem)
	{
		
		int count=0,grandTotal=0;
		while(count<listCartItem.size())
		{
			grandTotal=grandTotal+(listCartItem.get(count).getQuantity()*listCartItem.get(count).getPrice());
			count++;
		}
		return grandTotal;
	}
}
	

