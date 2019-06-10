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
	public boolean saveOrder(OrderDetail orderDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail );
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}




	@Override
	public boolean updateCart(String username, int orderId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart set Status='P',OrderId=:orderId where username=:username and status ='NP'");
		query.setParameter("username", username);
		int row_eff=query.executeUpdate();
		if(row_eff>0)
			return true;
		else
			return false;
	}
	}
