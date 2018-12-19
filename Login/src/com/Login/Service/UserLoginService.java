package com.Login.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Login.User.Entity.UserLogin;
import com.Login.User.Entity.UserRegistration;

@Service
public interface UserLoginService 
{
	public  List<UserLogin> checkUser(UserLogin theUser);
	
	public void saveUser(UserRegistration theUR);
}
