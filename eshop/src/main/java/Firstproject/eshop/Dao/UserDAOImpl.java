package Firstproject.eshop.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Firstproject.eshop.Model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public boolean registerUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch (Exception e)
		{
		return false;
		}
	}
	
	public boolean deleteUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch (Exception e)
		{
		return false;
		}
	}

	
	public boolean updateUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch (Exception e)
		{
		return false;
		}
		
	}


	
	public UserDetail getUserDetail(String username) 
	{
		Session session=sessionFactory.openSession();
		UserDetail user=(UserDetail) session.get(UserDetail.class,username);
		session.close();
		return user;
	}


}
