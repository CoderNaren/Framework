package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Student;

public class CreateDemo 
{
	public static void main(String[] args)
	{
		// create Session Factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
			 
		// create Session
		Session session = factory.getCurrentSession();
		
		try 
		{	
			/*
			// create the Object 
			Instructor tempInstructor = new Instructor("chad","darby","darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","luv 2 code");
			// associate the Object 
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			*/
			
			
			Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Guitar");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			//start a transaction
			session.beginTransaction();
			
			// save Instructor
			// Note: this will also save detail object
			// because of cascadeType.All. u just need to save tempinstructor , 
			//then automatically its save the associated object (tempInstructorDetail).
			session.save(tempInstructor);
			
			// commit transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} 
		finally 
		{
			session.close();
		}
	}
	
}
