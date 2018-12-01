package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerControllar 
{
	
	// add an initbinder .. to convert trim input string
	//remove leading and trailing white space
	//resolve issue for our validation
	
	@InitBinder
	public  void initBinder(WebDataBinder dataBinder)
	{
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); // true = trim it to null 
		dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel)
	{
		theModel.addAttribute("customer",new Customer()); // this Customer object for set data in Customer POJO
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
		@Valid @ModelAttribute("customer")	Customer theCustomer, // and here same object refer by theCustomer for get data from POJO
		BindingResult theBindingResult)
	{
		System.out.println("Last name |"+ theCustomer.getLastName()+"|");
		
		System.out.println("Binding result: "+theBindingResult);
		System.out.println("\n\n\n\n");
		if(theBindingResult.hasErrors())	
			return "customer-form";
		else 
			return "customer-confirmation";
	}
}