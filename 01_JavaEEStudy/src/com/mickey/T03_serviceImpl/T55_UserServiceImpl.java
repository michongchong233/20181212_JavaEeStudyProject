package com.mickey.T03_serviceImpl;

import com.mickey.T03_dao.T55_UserDao;
import com.mickey.T03_daoImpl.T55_UserDaoImpl;
import com.mickey.T03_pojo.T55_User;
import com.mickey.T03_service.T55_UserService;

public class T55_UserServiceImpl implements T55_UserService{
	T55_UserDao ud = new T55_UserDaoImpl();//獲取Dao層對象

	@Override
	public T55_User getUserInfoService(String name) {
		return ud.getUserInfo(name);
	}

}
