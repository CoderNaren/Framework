package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Review;
import com.love2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo 
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
			
			// create a course
			Course tempCourse = new Course("Pacman - How to score 1 million points");
			
			// save the course
			System.out.println("\nSaving course ...");
			session.save(tempCourse);
			System.out.println("Saved course "+tempCourse);
			
			//create the student 
			Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
			Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
			
			//add student to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save the student
			System.out.println("\nSaving Student ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("saved student "+tempCourse.getStudents());
			
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
