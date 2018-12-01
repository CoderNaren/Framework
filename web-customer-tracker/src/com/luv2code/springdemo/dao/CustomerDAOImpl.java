package com.luv2code.springdemo.dao;

import java.util.List;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomer() 
	{	
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve from DB based on primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

}
