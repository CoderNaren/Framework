package com.love2code.hibernate.demo.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course 
{
	//define our fields
	
	//define constructors
	
	// define getter/setter
	
	// define toString method
	
	// annotated fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name ="instructor_id")  // its tell to hibernate , Join the 'instructor_id' Column of course table
	private Instructor instructor;		// with the 'id' Column of Instructor table , and hibernate able to do it bcz of Foreign key setting
										// in course table. Foreign key of course table gives reference to 'id' column of  Instructor table.  
	
	
	public Course()
	{
		
	}

	public Course(String title) 
	{
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
}
