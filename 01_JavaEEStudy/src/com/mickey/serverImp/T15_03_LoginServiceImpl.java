package com.mickey.serverImp;

import com.mickey.T01_dao.T15_04_LoginDAO;
import com.mickey.T01_dao.impl.T15_05_LoginDAOImpl;
import com.mickey.T01_service.T15_01_LoginService;
import com.mickey.T01pojo.T15_02_LoginUser;

public class T15_03_LoginServiceImpl implements T15_01_LoginService {
	//�Ы�DAO�h�L�צV
	T15_04_LoginDAO ld = new T15_05_LoginDAOImpl();
	
	//�мgservice���f�A�����Τ�W�M�K�X�A��^�O�_���o�@�եΤ�W�M�K�X
	//�b�̭��i�H�g�@�Ǭ������~���޿�A�p�G��J�榡����(�i�bjquery��)�B�n�J���h�X����|�ᵲ�b��K
	@Override
	public T15_02_LoginUser checkLoginService(String uname, String password) {
		return ld.checkLoginDao(uname, password);
	}
}
