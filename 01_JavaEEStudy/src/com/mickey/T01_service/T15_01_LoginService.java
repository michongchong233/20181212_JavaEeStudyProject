package com.mickey.T01_service;

import com.mickey.T01pojo.T15_02_LoginUser;

public interface T15_01_LoginService {
	//�����Τ�W�M�K�X�A��^�O�_���o�@�եΤ�W�M�K�X
	T15_02_LoginUser checkLoginService(String uname, String password);
	
	//�����Τ�s���A��^�o�ӽs���O�_�|������@�եΤ�
	T15_02_LoginUser checkUidService(String uid);

}
