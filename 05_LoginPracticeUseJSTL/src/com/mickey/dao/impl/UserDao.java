package com.mickey.dao.impl;

import java.util.List;

import com.mickey.dto.UserDTO;

public interface UserDao {
	public UserDTO checkUserSignIn(String uname, String password);
	
	public UserDTO checkUserId(int uid);
	
	public int updatePassword(int uid, String password);
	
	public List<UserDTO> getAllUser();
	
	public int signUpAccount(UserDTO user);
}
