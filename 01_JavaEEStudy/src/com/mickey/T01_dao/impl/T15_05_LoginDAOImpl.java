package com.mickey.T01_dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mickey.T01_dao.T15_04_LoginDAO;
import com.mickey.T01pojo.T15_02_LoginUser;

/**
 * �ϥ�JDBC
 *
 */
public class T15_05_LoginDAOImpl implements T15_04_LoginDAO {
	@Override
	public T15_02_LoginUser checkLoginDao(String uname, String password) {
		//�n��JDBC��H
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//�n���ƾڦs�x��H
		T15_02_LoginUser user = null;
		//�[���X��
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//����s����H
			String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
			String userName = "root";
			String userPassword = "s70103ss";//�n�O�o��ۤvroot���K�X
			conn = DriverManager.getConnection(url, userName, userPassword);
			//�Ы�SQL�R�O
			String sql = "select * from T14_login where uname=? and password=?;";
			//�Ы�SQL�R�O��H
			ps = conn.prepareStatement(sql);
			//���e��Ž��
			ps.setString(1, uname);
			ps.setString(2, password);
			//����
			rs = ps.executeQuery();
			//�M�����浲�G
			while(rs.next()) {
				user = new T15_02_LoginUser();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
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
}