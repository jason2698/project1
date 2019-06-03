package Firstproject.eshop;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Firstproject.eshop.Dao.UserDAO;
import Firstproject.eshop.Model.UserDetail;

public class UserDAOTest 
{
static UserDAO userDAO;

@BeforeClass
public static void executeFirst()
{
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("Firstproject.eshop");
	context.refresh();
	userDAO=(UserDAO)context.getBean("userDAO");
}

@Ignore
@Test
public void addUserTest()
{
	UserDetail user=new UserDetail();
	user.setUsername("jason");
	user.setPassword("12345");
	user.setEmailId("jjason2698@yahoo.com");
	user.setCustomername("jason j");
	user.setEnabled(true);
	user.setRole("ROLE_ADMIN");
	user.setAddress("24F,IMS,NAGAR,THOOTHUKUDI");
	
	
	assertTrue("problem in adding user",userDAO.registerUser(user));
}

@Test
public void updateUserTest()
{
	UserDetail user=userDAO.getUserDetail("moses");
	user.setAddress("57th,ebenezar street,tirunelveli");
	
	assertTrue("problem in update user",userDAO.updateUser(user));
}
}
