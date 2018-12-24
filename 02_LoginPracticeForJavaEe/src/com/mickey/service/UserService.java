package com.mickey.service;

import com.mickey.dto.UserDTO;

public interface UserService {
	public UserDTO checkUserSignIn(String uname, String password);
	
	public UserDTO checkUserId(int uid);
	
	public void signUpAccount(UserDTO user);
}
