package Firstproject.eshop.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Firstproject.eshop.Model.OrderDetail;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean paymentProcess(OrderDetail orderDetail)
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateCartItemsStatus(String username, int orderId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("update Cart set status='p',orderId=:ordid where username=:uname");
			query.setParameter("ordid", orderId);
			query.setParameter("uname", username);
			int row_eff=query.executeUpdate();
			if(row_eff>0)
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
