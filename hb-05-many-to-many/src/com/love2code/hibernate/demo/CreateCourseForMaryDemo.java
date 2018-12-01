package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Review;
import com.love2code.hibernate.demo.entity.Student;

public class CreateCourseForMaryDemo 
{
	public static void main(String[] args)
	{
		// create Session Factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
			 
		// create Session
		Session session = factory.getCurrentSession();
		
		try 
		{	
			// start transaction 
			session.beginTransaction();
			
			// get student mary from DB
			
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);
			System.out.println("\nLoaded Student: "+tempStudent);
			System.out.println("Courses: "+tempStudent.getCourses());
			
			// create more course
			
			Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
			Course tempCourse2 = new Course("Atari 2600 - Game Development");
			
			//add mary to courses
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			//save the courses
			System.out.println("\nSaving courses ...");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// commit transaction 
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
