package com.lec.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCConnection {

	final static String DRV = "org.mariadb.jdbc.Driver";
	final static String URL = "jdbc:mariadb://localhost:3307/employees";
	final static String USR = "root";
	final static String PWD = "12345";
	
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from employees where employee_id = 100";
		
		try {
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD); 	// DB 연결
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			
			int emplyee_id = rs.getInt(1);
			String first_name = rs.getString(2);
			String last_name = rs.getString("LAST_NAME");
			int salary = rs.getInt("salary");
			
			System.out.println(emplyee_id + ", " + first_name + ", " + last_name + ", " + salary);
			
		} catch (Exception e) {
			System.out.println("DB 연결 실패!!");
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
	}

}
