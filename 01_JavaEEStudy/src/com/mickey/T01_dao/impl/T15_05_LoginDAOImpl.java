package com.mickey.T01_dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mickey.T01_dao.T15_04_LoginDAO;
import com.mickey.T01pojo.T15_02_LoginUser;

/**
 * 使用JDBC
 *
 */
public class T15_05_LoginDAOImpl implements T15_04_LoginDAO {
	@Override
	public T15_02_LoginUser checkLoginDao(String uname, String password) {
		//聲明JDBC對象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//聲明數據存儲對象
		T15_02_LoginUser user = null;
		//加載驅動
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//獲取連接對象
			String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
			String userName = "root";
			String userPassword = "s70103ss";//要記得改自己root的密碼
			conn = DriverManager.getConnection(url, userName, userPassword);
			//創建SQL命令
			String sql = "select * from T14_login where uname=? and password=?;";
			//創建SQL命令對象
			ps = conn.prepareStatement(sql);
			//給占位符賦值
			ps.setString(1, uname);
			ps.setString(2, password);
			//執行
			rs = ps.executeQuery();
			//遍歷執行結果
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
				//關閉資源
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//返回
		return user;
	}
}