package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCourseDemo 
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
			session.beginTransaction();
			
			//get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Istructor "+tempInstructor);
			
			//get course from istructor
			System.err.println("Courses: "+tempInstructor.getCourses());
			
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
