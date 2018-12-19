package com.Login.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Login.User.Entity.UserLogin;
import com.Login.User.Entity.UserRegistration;

@Repository
public class UserLoginDAOimpl implements UserLoginDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<UserLogin> checkUser(UserLogin theUser) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<UserLogin> theQuery = 
				session.createQuery("from UserLogin ul where ul.userName='user_name' AND ul.password='password'",UserLogin.class);

		List<UserLogin> list = theQuery.getResultList();
		
		return list;
	}

	@Override
	public void saveUser(UserRegistration theUR) {
		
		Session session = sessionFactory.getCurrentSession();
		
		UserLogin theUser = new UserLogin(theUR.getUsername(),theUR.getPassword());
		
		session.save(theUser);
		session.save(theUR);
	}

}