package com.mickey.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mickey.dto.UserDTO;

public class UserDaoImpl implements UserDao {
	private UserDTO user = null;
	
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
		try {
			conn = makeConnection();
			ps = conn.prepareStatement(query);			
			//���e��Ž��
			ps.setString(1, uname);
			ps.setString(2, password);
			//�M�����浲�G
			rs = ps.executeQuery();
			user = setUserInformation(rs);
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
		try {
			conn = makeConnection();
			ps = conn.prepareStatement(query);
			//���e��Ž��
			ps.setInt(1, uid);
			//�M���B�浲�G
			rs = ps.executeQuery();
			user = setUserInformation(rs);
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

	private UserDTO setUserInformation(ResultSet rs) {
		try {
			if(rs != null) while(rs.next()) {
				user = new UserDTO();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getByte("gender"));
				user.setAge(rs.getInt("age"));
				user.setBirth(rs.getDate("birth").toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public UserDTO updatePassword(int uid,String password) {
		String query = "update T41_UserImformation set password=? where uid=?;";
		Connection conn = null;
		PreparedStatement ps = null;
		conn = makeConnection();
		try {
			ps = conn.prepareStatement(query);
			//���e��Ž��
			ps.setString(1, password);
			ps.setInt(2, uid);
			ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	/**
	 * ���o�Ҧ��Τ᪺�H��
	 */
	@Override
	public List<UserDTO> getAllUser() {
		String query = "select * from T41_UserImformation";
		List<UserDTO> users = new ArrayList<UserDTO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = makeConnection();
			ps = conn.prepareStatement(query);
			//�M�����G
			rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					user = new UserDTO();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setPassword(rs.getString("password"));
					user.setGender(rs.getByte("gender"));
					user.setAge(rs.getInt("age"));
					user.setBirth(rs.getDate("birth").toString());
					users.add(user);
				}
			}
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
		return users;
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
