package com.mickey.serverImp;

import com.mickey.T01_service.T15_01_LoginService;
import com.mickey.T01pojo.T15_02_LoginUser;

public class T15_03_LoginServiceImpl implements T15_01_LoginService {

	//覆寫service接口，接收用戶名和密碼，返回是否有這一組用戶名和密碼
	//在裡面可以寫一些相關的業務邏輯，如：輸入格式校驗(可在jquery做)、登入失則幾次後會凍結帳戶…
	@Override
	public T15_02_LoginUser checkLoginService(String uname, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
