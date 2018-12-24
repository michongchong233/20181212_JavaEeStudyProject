package com.mickey.service.impl;

import com.mickey.dao.impl.UserDao;
import com.mickey.dao.impl.UserDaoImpl;
import com.mickey.dto.UserDTO;
import com.mickey.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public UserDTO checkUserSignIn(String uname, String password) {
		UserDao checkUserSignIn = new UserDaoImpl();
		UserDTO user = new UserDTO();
		user = checkUserSignIn.checkUserSignIn(uname, password);
		return user;
	}

	@Override
	public UserDTO checkUserId(int uid) {
		UserDTO user = new UserDTO();
		return user;
	}

}
