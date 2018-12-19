package com.Login.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Login.DAO.UserLoginDAO;
import com.Login.User.Entity.UserLogin;
import com.Login.User.Entity.UserRegistration;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginDAO userlogindao; 
	
	@Override
	@Transactional
	public  List<UserLogin> checkUser(UserLogin theUser) {
		
		return userlogindao.checkUser(theUser);
	}

	@Override
	@Transactional
	public void saveUser(UserRegistration theUR) {
		userlogindao.saveUser(theUR);
	}
}
