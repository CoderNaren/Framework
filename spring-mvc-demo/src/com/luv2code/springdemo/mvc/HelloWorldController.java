package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController 
{
	// need a controller method to show the initial HTML page
	
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}
	
	// new a controllar method to read HTML form data and
	// add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request , Model model)
	{
		// read the request perameter from the HTML form
		String theName = request.getParameter("studentName");
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the msg
		String result = "Yo "+theName;
		
		// add msg to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
				@RequestParam("studentName") String theName, Model model)
	{
		theName = theName.toUpperCase();
		
		String result = "Hey friend i m from V3! "+theName;
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}

}
