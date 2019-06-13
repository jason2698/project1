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
import Firstproject.eshop.Model.CartItem;
import Firstproject.eshop.Model.OrderDetail;

@Controller
public class OrderController {
	
	@Autowired
	CartItemDAO cartItemDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping(value="/cart")
	public String ShowCart(Model m, HttpSession session)
	{
		
		
		String username=(String)session.getAttribute("username");
		System.out.println(username);
		List<CartItem> listCartItem=cartItemDAO.listCartItem(username);
		m.addAttribute("listCartItem",listCartItem);
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(listCartItem));
		
		return "cart";
	}
	
	
	
	@RequestMapping("/Payment")
	public String showPaymentPage(Model m, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItem=cartItemDAO.listCartItem(username);
		
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(listCartItem));
		
		return "Payment";
	}
	

	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String showReceipt(@RequestParam("pmode")String pmode,Model m, HttpSession session )
	{
		String username=(String)session.getAttribute("username");
		List<CartItem>listCartItem=cartItemDAO.listCartItem(username);
		
		OrderDetail order=new OrderDetail();
		order.setUsername(username);
		order.setOrderDate(new java.util.Date());
		order.getOrderId();
		order.setPmode(pmode);
		order.setTotalAmount(this.calcGrandTotalPrice(listCartItem));
		orderDAO.saveOrder(order);
		int orderId =order.getOrderId();
		System.out.println(orderId);
		orderDAO.updateCart(username, order.getOrderId());
		m.addAttribute("orderData",orderId);
	   // m.session.setAttribute("order", orderId);
		m.addAttribute("listCartItem", listCartItem);
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(listCartItem));
		
		return "receipt";
	}
	
	public int calcGrandTotalPrice(List<CartItem> listCartItem)
	{
		int grandTotal=0;
		int count=0;
		while(count<listCartItem.size())
		{
			CartItem cart=listCartItem.get(count);
			grandTotal=grandTotal+(cart.getQuantity()*cart.getPrice());
			count=count+1;
			
		}
		return grandTotal;
	}

}
