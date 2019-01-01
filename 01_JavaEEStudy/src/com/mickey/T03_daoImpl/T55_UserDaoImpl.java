package com.mickey.T03_daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mickey.T03_dao.T55_UserDao;
import com.mickey.T55_pojo.T55_User;

public class T55_UserDaoImpl implements T55_UserDao{

	@Override
	public T55_User getUserInfo(String name) {
		String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
		String userName = "root";
		String userPassword = "1234";//要記得改自己root的密碼
		//聲明JDBC對象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		T55_User u = null;
		try {
			//加載驅動
			Class.forName("com.mysql.cj.jdbc.Driver");
			//獲取連接對象
			conn = DriverManager.getConnection(url, userName, userPassword);
			//創建sql命令
			String sql = "select * from users where uname=?";
			//創建sql命令對象
			ps = conn.prepareStatement(sql);
			//給占位符賦值
			ps.setString(1, name);
			//遍歷查詢
			rs = ps.executeQuery();
			if(rs!=null && rs.next()) {
				u = new T55_User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPrice(rs.getDouble("price"));
				u.setLoc(rs.getString("loc"));
				u.setDesc(rs.getString("des"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//關閉資源
			try {
				if(rs != null)rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return u;
	}

}
