package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student 
{
	private String firstName;
	private String lastName;
	
	private String country;
	private String favouriteLanguage;
	private String[] operatingSystem;
	
	private LinkedHashMap<String,String> countryOptions;
	
	public Student()
	{
		countryOptions = new LinkedHashMap<>();			// u no need to do hard code now in jsp page like we do for
														//Favourite & operating system
		countryOptions.put("BR", "Brazil");
		countryOptions.put("JP", "Japan");
		countryOptions.put("SL", "ShreeLanka");
		countryOptions.put("IN", "India");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}	
	
}
