package com.mickey.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mickey.dto.UserDTO;

public class UserDaoImpl implements UserDao {
	
	/**
	 * �إ�MySQL�s��
	 */
	private Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
		String userName = "root";
		String userPassword = "1234";
		//�n��JDBC��H
		Connection conn = null;
		try {
			//�[��JDBC�X��
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, userPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * �ΥΤ��J���Τ�W�M�K�X�q�ƾڮw����������Τ���
	 */
	@Override
	public UserDTO checkUserSignIn(String uname, String password) {
		String query = "select * from T41_UserImformation where uname=? and password=?;";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDTO user = null;
		try {
			conn = makeConnection();
			ps = conn.prepareStatement(query);			
			//���e��Ž��
			ps.setString(1, uname);
			ps.setString(2, password);
			//�M�����浲�G
			rs = ps.executeQuery();
			user = getUserInformation(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//�����귽
				if(rs != null)rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	/**
	 * �ΥΤ�s���q�ƾڮw����������Τ���
	 */
	@Override
	public UserDTO checkUserId(int uid) {
		String query = "select * from T41_UserImformation where uid=?;";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDTO user = null;
		try {
			conn = makeConnection();
			ps = conn.prepareStatement(query);
			//���e��Ž��
			ps.setInt(1, uid);
			//�M���B�浲�G
			rs = ps.executeQuery();
			user = getUserInformation(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	private UserDTO getUserInformation(ResultSet rs) {
		UserDTO user = null;
		try {
			if(rs != null) while(rs.next()) {
				user = new UserDTO();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getByte("gender"));
				user.setAge(rs.getInt("age"));
				user.setBirth(rs.getDate("birth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * �إ߷s�Τ�
	 */
	@Override
	public void signUpAccount(UserDTO user) {
		String query = "insert into dbtest.T41_UserImformation (uname, password, gender, age, birth) values (?, ?, ?, ?, ?),";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//TODO
		
	}
}
