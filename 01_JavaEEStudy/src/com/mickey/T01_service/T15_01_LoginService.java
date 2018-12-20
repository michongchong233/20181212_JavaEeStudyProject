package com.mickey.T01_service;

import com.mickey.T01pojo.T15_02_LoginUser;

public interface T15_01_LoginService {
	//接收用戶名和密碼，返回是否有這一組用戶名和密碼
	T15_02_LoginUser checkLoginService(String uname, String password);
	
	//接收用戶編號，返回這個編號是否會對應到一組用戶
	T15_02_LoginUser checkUidService(String uid);

}
