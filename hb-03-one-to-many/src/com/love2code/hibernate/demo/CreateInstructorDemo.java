package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo 
{
	public static void main(String[] args)
	{
		// create Session Factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
			 
		// create Session
		Session session = factory.getCurrentSession();
		
		try 
		{		
			
			Instructor tempInstructor = new Instructor("Susan","Public","susan.public@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Video Games");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			session.beginTransaction();
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} 
		finally 
		{
			session.close();
			factory.close();
		}
	}
	
}
