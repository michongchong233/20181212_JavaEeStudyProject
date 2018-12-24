package com.mickey.dao.impl;

import com.mickey.dto.UserDTO;

public interface UserDao {
	public UserDTO checkUserSignIn(String uname, String password);
	
	public UserDTO checkUserId(int uid);
	
	public void signUpAccount(UserDTO user);
}
