package com.mickey.T01_dao;

import com.mickey.T01pojo.T15_02_LoginUser;

public interface T15_04_LoginDAO {
	T15_02_LoginUser checkLoginDao(String uname, String password);
}
