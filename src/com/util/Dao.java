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
		//  1��ע�����ݿ������,ʹ�÷���ע������
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        Connection connection = null;
         //2��������ݿ�����ӷ���Ȩ��
        try {
			connection = DriverManager.getConnection(URL, USER, PASSWD);
        } catch (SQLException e) {
			e.printStackTrace();
		}
         //3�������ݿⷢ��ִ�е�SQLִ�����
        PreparedStatement pstmt;
        
        	String sql = "insert into hotel_brand_test(brand_value,title) Values(?,?) ";
        	pstmt = (PreparedStatement) connection.prepareStatement(sql);
        	pstmt.setString(1, value);
            pstmt.setString(2, title);
            pstmt.executeUpdate();
         //5���ر����ݿ�����
		 try {
			pstmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
       
	}
}
