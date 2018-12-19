package com.Login.User.Controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Login.Service.UserLoginService;
import com.Login.User.Entity.UserLogin;
import com.Login.User.Entity.UserRegistration;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserLoginService userloginservice;
	
	//@RequestMapping(value = "/loginform" , method = RequestMethod.GET)
	@GetMapping("/loginform")
	public String loginForm(Model theModel)
	{
		UserLogin theUser = new UserLogin();
		
		theModel.addAttribute("userlogin",theUser);
		
		return "login-form";
	}
	
	@GetMapping("/registrationform")
	public String registrationForm(Model theModel)
	{	
		UserRegistration theUserRegistration = new UserRegistration();
		
		theModel.addAttribute("newuser",theUserRegistration);
		
		return "Registration-form";
	}
	
	
	@PostMapping("/processform")
	public String processForm(@ModelAttribute("userlogin") UserLogin theUser)
	{
	//	System.out.println("entered username "+theUser.getUserName()+" and password "+theUser.getPassword());
		
		List<UserLogin> list = userloginservice.checkUser(theUser);
		if(list!=null)
		{
			return "login-success";
		}
		return "redirect:/user/loginform";

	}
	
	@PostMapping("/registrationprocess")
	public String registrationProcess(@ModelAttribute("newuser") UserRegistration theUR)
	{
		userloginservice.saveUser(theUR);
		return "registration-success";
	}
}

/* Iterator<UserLogin> it = list.iterator();
		while(it.hasNext())
		{
			UserLogin UL = it.next();			
			if(UL.getUserName().equals(theUser.getUserName()) && UL.getPassword().equals(theUser.getPassword()))
			{
				return "login-success"; 
			}
		}
 */
