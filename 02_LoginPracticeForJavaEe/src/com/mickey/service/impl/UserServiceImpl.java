package com.mickey.service.impl;

import com.mickey.dao.impl.UserDao;
import com.mickey.dao.impl.UserDaoImpl;
import com.mickey.dto.UserDTO;
import com.mickey.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public UserDTO checkUserSignIn(String uname, String password) {
		UserDao checkUserSignIn = new UserDaoImpl();
		UserDTO user = null;
		user = checkUserSignIn.checkUserSignIn(uname, password);
		return user;
	}

	@Override
	public UserDTO checkUserId(int uid) {
		UserDao checkUserId = new UserDaoImpl();
		UserDTO user = null;
		user = checkUserId.checkUserId(uid);
		return user;
	}

	@Override
	public void signUpAccount(UserDTO user) {
		
		
	}
	
	

}
