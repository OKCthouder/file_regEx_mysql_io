package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Dao {
	private static final String USER = "root";
	private static final String PASSWD = "123456";
	private static final String URL = "jdbc:mysql://localhost:3306/data?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	
	public static void add(String value,String title) throws SQLException {
		//  1、注册数据库的驱动,使用反射注册驱动
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        Connection connection = null;
         //2、获得数据库的连接访问权限
        try {
			connection = DriverManager.getConnection(URL, USER, PASSWD);
        } catch (SQLException e) {
			e.printStackTrace();
		}
         //3、向数据库发送执行的SQL执行语句
        PreparedStatement pstmt;
        
        	String sql = "insert into hotel_brand_test(brand_value,title) Values(?,?) ";
        	pstmt = (PreparedStatement) connection.prepareStatement(sql);
        	pstmt.setString(1, value);
            pstmt.setString(2, title);
            pstmt.executeUpdate();
         //5、关闭数据库连接
		 try {
			pstmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
       
	}
}
