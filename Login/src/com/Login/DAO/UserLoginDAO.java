package com.Login.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Login.User.Entity.UserLogin;
import com.Login.User.Entity.UserRegistration;

public interface UserLoginDAO 
{		
	public  List<UserLogin>checkUser(UserLogin theUser);
	
	public void saveUser(UserRegistration theUR);
}