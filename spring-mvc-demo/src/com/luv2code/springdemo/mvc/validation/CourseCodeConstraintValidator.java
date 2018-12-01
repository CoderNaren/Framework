package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
implements ConstraintValidator<CourseCode, String> // CourseCode = our annotation class
{

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) // for additional error messages
	{
		boolean result;
		
		if(theCode != null)
				result = theCode.startsWith(coursePrefix);  // true
		else
			result = true;  // course field is not mandatory so we pass true here.If its mandatory then we return false.
		
		return result;
	}
	
}
