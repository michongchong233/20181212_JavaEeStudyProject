package com.mickey.T01_dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mickey.T01_dao.T15_04_LoginDAO;
import com.mickey.T01_serverlet.AllUseUtil;
import com.mickey.T01pojo.T15_02_LoginUser;

/**
 * �ϥ�JDBC
 *
 */
public class T15_05_LoginDAOImpl implements T15_04_LoginDAO {
	@SuppressWarnings("rawtypes")
	Class myClass = this.getClass();
	//�s���ƾڮw�ݭn���H��
	private String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
	private String userName = "root";
	private String userPassword = "s70103SS*";//�n�O�o��ۤvroot���K�X
		
	//���ΡA�إ�JDBC�s��
	private Connection makeConnection() {
		//�n��JDBC��H
		Connection conn = null;
		//�[���X��
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, userName, userPassword);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return conn;		
	}
	
	@Override
	public T15_02_LoginUser checkLoginDao(String uname, String password) {
		//�Ы�SQL�R�O
		String loginSql = "select * from T14_login where uname=? and password=?;";
		//�n��JDBC��H
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//�n���ƾڦs�x��H
		T15_02_LoginUser user = null;
		try {
			conn = makeConnection();
			//�Ы�SQL�R�O��H
			ps = conn.prepareStatement(loginSql);
			//���e��Ž��
			ps.setString(1, uname);
			ps.setString(2, password);
			//����
			rs = ps.executeQuery();
			if(rs != null) {
				//�M�����浲�G
				while(rs.next()) {
					user = new T15_02_LoginUser();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setPassword(rs.getString("password"));
				}
			}
		} catch (Exception e) {//����ĳ�o��g�A�|������
			e.printStackTrace();
		} finally {
			try {
				//�����귽
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//��^
		return user;
	}

	@Override
	public T15_02_LoginUser checkUidDao(String uid) {
		String checkUidSql = "select * from t14_login where uid=?;";
		//�n��JDBC��H
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		T15_02_LoginUser user = null;
		try {
			conn = makeConnection();
			ps = conn.prepareStatement(checkUidSql);
			//���e��Ž��
			ps.setString(1, uid);
			rs = ps.executeQuery();
			//�M�����浲�G
			if(rs != null) {
				while(rs.next()) {
					user = new T15_02_LoginUser();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setPassword(rs.getString("password"));
					AllUseUtil.getLogger(myClass, user.toString());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�����귽
			try {
				if(rs != null)rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		return user;
	}
}