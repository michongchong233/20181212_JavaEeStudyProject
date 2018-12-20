package com.mickey.serverImp;

import com.mickey.T01_dao.T15_04_LoginDAO;
import com.mickey.T01_dao.impl.T15_05_LoginDAOImpl;
import com.mickey.T01_service.T15_01_LoginService;
import com.mickey.T01pojo.T15_02_LoginUser;

public class T15_03_LoginServiceImpl implements T15_01_LoginService {
	//創建DAO層過度向
	T15_04_LoginDAO ld = new T15_05_LoginDAOImpl();
	
	//覆寫service接口，接收用戶名和密碼，返回是否有這一組用戶名和密碼
	@Override
	public T15_02_LoginUser checkLoginService(String uname, String password) {
		//在裡面可以寫一些相關的業務邏輯，如：輸入格式校驗(可在jquery做)、登入失則幾次後會凍結帳戶…
		return ld.checkLoginDao(uname, password);
	}

	@Override
	public T15_02_LoginUser checkUidService(String uid) {
		//可寫相應的業務邏輯
		return ld.checkUidDao(uid);
	}
}
