package com.lec.ex01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCMySQLConnection {

	
	final static String DRV = "com.mysql.js.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306:payroll";
	final static String USR = "root";
	final static String PWD = "12345";
	
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static void main(String[] args) {
		
		try {
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL,USR,PWD);
						
			if(conn != null) {
				System.out.println("DB 접속 성공");
			}
			
		}catch(Exception e) {
			System.out.println("DB 연결 실패!");
			e.printStackTrace();
		}
		
		try {
			String sql = "select * from payroll.employees";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			String employee_id = null;
			String first_name = null;
			String last_name = null;
						
			while (rs.next()) {
				employee_id = rs.getString(1);
				first_name = rs.getString(2);
				last_name = rs.getString(3);
			}
			
			System.out.println("부서 번호 : " + employee_id + "\t");
			System.out.println("성 : " + first_name + "\t");
			System.out.println("이름 : " + last_name + "\t");
					
		}catch(Exception e) {
			System.out.println("error : " + e);
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
		}
	}

}
