package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Student;

public class DeleteDemo 
{
	public static void main(String[] args)
	{
	
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
			 
		Session session = factory.getCurrentSession();
		
		try 
		{	
			
			session.beginTransaction();
			
			// get Instructor by primary key / Id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			if(tempInstructor != null)
			{
				System.out.println("Deleting: "+tempInstructor);
				session.delete(tempInstructor);
				// Note : its also delete associated "InstructorDeatil" object bcz of cascade
			}
			
			
			//delete it
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} 
		finally 
		{
			session.close();
		}
	}
	
}
