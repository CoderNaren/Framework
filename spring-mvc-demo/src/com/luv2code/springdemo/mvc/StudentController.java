package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController 
{
	@RequestMapping("/showForm")
	public String showForm(Model theModel)
	{
		// create a student object
		Student theStudent = new Student();
		
		//add that student object to the model attribute
		theModel.addAttribute("student", theStudent); //or u can write  ("student", new Student());
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent)
	{
		// log d input data
		System.out.println("the Student data "+ theStudent.getFirstName()
											 + "  " + theStudent.getLastName());
		
		return "student-confirmation";
	}
}
