package eshopfront;

import java.util.Collection;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Firstproject.eshop.Dao.UserDAO;
import Firstproject.eshop.Model.UserDetail;

@Controller
public class UserController 
{
	@Autowired
    UserDAO userDao;

@RequestMapping("/login_success")
public String checkLogin(HttpSession session, Model m) 
{
	String page="";
	boolean loggedIn;
	
	SecurityContext sContext=SecurityContextHolder.getContext();

	Authentication authentication =sContext.getAuthentication();

	
	String username=authentication.getName();
	Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
	
	for(GrantedAuthority Role:roles)
	{
		session.setAttribute("ROLE", Role.getAuthority());
		if(Role.getAuthority().equals("ROLE_USER"))
		
		{
			loggedIn=true;
			page="UserHome";
			session.setAttribute("loggedIn",loggedIn);
			session.setAttribute("username", username);

		}
		else
	
		{
			loggedIn=true;
			page="AdminHome";
			session.setAttribute("loggedIn",loggedIn);
			session.setAttribute("username", username);
			
		}
	}
	
	return page;
	
}

@RequestMapping("/loginerror")
public String loginError(Model model)
{
	model.addAttribute("error", "Invalid username and password");
	return "login";
	
}


@RequestMapping(value="/addUser",method=RequestMethod.POST)
public String addUser(Model m, @RequestParam("mobilenumber")String mobilenumber,@RequestParam("username")String username,@RequestParam("emailId")String emailId,@RequestParam("password")String password,@RequestParam("customername")String customername,@RequestParam("address")String address)
{
	    	
	UserDetail user=new UserDetail();
	user.setAddress(address);
	user.setCustomername(customername);
	user.setEnabled(true);
	user.setMobilenumber(mobilenumber);
	user.setPassword(password);
   	user.setRole("ROLE_USER");
	user.setEmailId(emailId);
	user.setUsername(username);
	

	userDao.registerUser(user);
	return "login";
	
}

}
