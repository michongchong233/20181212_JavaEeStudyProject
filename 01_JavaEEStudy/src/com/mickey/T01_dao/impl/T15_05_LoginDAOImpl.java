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
 * 使用JDBC
 *
 */
public class T15_05_LoginDAOImpl implements T15_04_LoginDAO {
	@SuppressWarnings("rawtypes")
	Class myClass = this.getClass();
	//連接數據庫需要的信息
	private String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
	private String userName = "root";
	private String userPassword = "s70103SS*";//要記得改自己root的密碼
		
	//公用，建立JDBC連接
	private Connection makeConnection() {
		//聲明JDBC對象
		Connection conn = null;
		//加載驅動
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
		//創建SQL命令
		String loginSql = "select * from T14_login where uname=? and password=?;";
		//聲明JDBC對象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//聲明數據存儲對象
		T15_02_LoginUser user = null;
		try {
			conn = makeConnection();
			//創建SQL命令對象
			ps = conn.prepareStatement(loginSql);
			//給占位符賦值
			ps.setString(1, uname);
			ps.setString(2, password);
			//執行
			rs = ps.executeQuery();
			if(rs != null) {
				//遍歷執行結果
				while(rs.next()) {
					user = new T15_02_LoginUser();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setPassword(rs.getString("password"));
				}
			}
		} catch (Exception e) {//不建議這麼寫，會難除錯
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

	@Override
	public T15_02_LoginUser checkUidDao(String uid) {
		String checkUidSql = "select * from t14_login where uid=?;";
		//聲明JDBC對象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		T15_02_LoginUser user = null;
		try {
			conn = makeConnection();
			ps = conn.prepareStatement(checkUidSql);
			//給占位符賦值
			ps.setString(1, uid);
			rs = ps.executeQuery();
			//遍歷執行結果
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
			//關閉資源
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