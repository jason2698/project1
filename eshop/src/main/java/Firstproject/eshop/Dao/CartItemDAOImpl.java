package Firstproject.eshop.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Firstproject.eshop.Model.CartItem;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public boolean addCart(CartItem cart) {
		try
		{
			sessionFactory.getCurrentSession().save(cart);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
			
		}
	}

	
	public boolean deleteCart(CartItem cart) {
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	public boolean updateCart(CartItem cart) {
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}


	public CartItem getCart(int cartItemId) {
		Session session=sessionFactory.openSession();
		CartItem cart=(CartItem) session.get(CartItem.class, cartItemId);
		session.close();
		return cart;
	}

	
	public List <CartItem> listCartItem(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from CartItem where username=:username");
		query.setParameter("username", username);
		List<CartItem> listCartItem=query.list();
		
		session.close();
		return  listCartItem;
	}
}
