package com.mickey.service.impl;

import java.util.List;

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
	public List<UserDTO> getAllUser() {
		List<UserDTO> users = null;
		UserDao getAllUser = new UserDaoImpl();
		users = getAllUser.getAllUser();
		return users;
	}

	@Override
	public int changePassword(int uid, String newPassword) {
		UserDao changePassword = new UserDaoImpl();
		return changePassword.updatePassword(uid, newPassword);
	}

	@Override
	public int signUpAccount(UserDTO user) {
		UserDao signUpAccount = new UserDaoImpl();
		return signUpAccount.signUpAccount(user);
	}
}
