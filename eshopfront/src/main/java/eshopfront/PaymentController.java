package eshopfront;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Firstproject.eshop.Dao.CartItemDAO;
import Firstproject.eshop.Dao.OrderDAO;
import Firstproject.eshop.Dao.UserDAO;
import Firstproject.eshop.Model.CartItem;
import Firstproject.eshop.Model.OrderDetail;
import Firstproject.eshop.Model.UserDetail;

@Controller
public class PaymentController {

	@Autowired
	CartItemDAO cartItemDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping("/checkout")
	public String showOrderConfirmPage(Model m,HttpSession session)
	{
		
		String username=(String)session.getAttribute("username");
		
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandTotal", this.calcGrandTotal(listCartItems));
		
		UserDetail user=userDAO.getUserDetail(username);
		
		m.addAttribute("addr", user.getAddress());
		
		return "OrderConfirm";
	}
	
	@RequestMapping("/payment")
	public String showPaymentPage(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandTotal", this.calcGrandTotal(listCartItems));
		
		return "payment";	
	}
	
	@RequestMapping(value="/updateAddr",method=RequestMethod.POST)
	public String updateAddress(@RequestParam("addr")String addr,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandTotal", this.calcGrandTotal(listCartItems));
		
		UserDetail user=userDAO.getUserDetail(username);
		user.setAddress(addr);
		userDAO.updateUser(user);
		
		m.addAttribute("addr", user.getAddress());
		
		return "OrderConfirm";
	}
	
	@RequestMapping(value="/pay",method=RequestMethod.POST)
	public String generateReceipt(@RequestParam("pmode")String pmode,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<CartItem> listCartItems=cartItemDAO.listCartItem(username);
		m.addAttribute("cartItems", listCartItems);
		int grandTotal=this.calcGrandTotal(listCartItems);
		m.addAttribute("grandTotal",grandTotal);
		
		OrderDetail order=new OrderDetail();
		order.setUsername(username);
		order.setOrderDate(new java.util.Date());
		order.setPmode(pmode);
		order.setShoppingAmount(grandTotal);
		
		orderDAO.saveOrder(order);
		
		if(orderDAO.updateCart(username, order.getOrderId()))
		{
			m.addAttribute("orderInfo", order);
			m.addAttribute("address", userDAO.getUserDetail(username).getAddress());
			return "Receipt";
		}
		else
		{
			System.out.println("Not Completed");
			return "cart";
		}
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
