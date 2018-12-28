package com.mickey.service;

import java.util.List;

import com.mickey.dto.UserDTO;

public interface UserService {
	public UserDTO checkUserSignIn(String uname, String password);
	
	public UserDTO checkUserId(int uid);
	
	public List<UserDTO> getAllUser();
	
	public int changePassword(int uid, String newPassword);
	
	public int signUpAccount(UserDTO user);
}
