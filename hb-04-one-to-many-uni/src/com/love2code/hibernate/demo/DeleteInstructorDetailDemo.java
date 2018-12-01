package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo 
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
			int theId = 3;
			
			// get the InstructorDetail object
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//print the Instructor detail
			System.out.println("detail Object "+tempInstructorDetail);
			
			// print associated Instructor
			System.out.println("Associated Instructor "+tempInstructorDetail.getInstructor());
			
			// delete instructor Detail 
			System.out.println("delete detail of "+tempInstructorDetail);
			
			// remove the associated object reference 
			//and break the bi-directional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			// fix leak issue when id isn't found
			session.close();
			factory.close();
		}
	}
	
}
