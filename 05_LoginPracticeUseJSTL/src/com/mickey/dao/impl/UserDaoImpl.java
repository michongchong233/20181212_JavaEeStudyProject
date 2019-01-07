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
		String userPassword = "s70103ss";
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
			//�B�浲�G
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
	public int updatePassword(int uid,String password) {
		String query = "update T41_UserImformation set password=? where uid=?;";
		int updateNum = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = makeConnection();
		try {
			ps = conn.prepareStatement(query);
			//���e��Ž��
			ps.setString(1, password);
			ps.setInt(2, uid);
			updateNum = ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//�����귽
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return updateNum;
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
	public int signUpAccount(UserDTO user) {
		String query = "insert into dbtest.T41_UserImformation (uname, password, gender, age, birth) values (?, ?, ?, ?, ?);";
		Connection conn = null;
		PreparedStatement ps = null;
		int updateNum = 0;
		conn = makeConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPassword());
			ps.setByte(3, user.getGender());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getBirth());
			updateNum = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//�����귽
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateNum;
	}
}