package com.lec.ex01;

import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesMain {

	public static void main(String[] args) throws Exception {
		
		//Properties 파일 읽기
		//1. 파일 경로 읽기
		String path = PropertiesMain.class.getResource("JDBCConnector1.properties").getPath();
		path = URLDecoder.decode(path, "utf-8");
//		System.out.println(path);
		
		
		//2. 파일 읽기
		Properties properties = new Properties();
		properties.load(new FileReader(path));
		
		//3. Key 와 Values
		String driver = properties.getProperty("DRV");
		String url = properties.getProperty("URL");
		String user = properties.getProperty("USR");
		String pwd = properties.getProperty("PWD");
		System.out.println(driver);
		System.out.println(url);
		System.out.println(user);
		System.out.println(pwd);
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pwd);
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employees where employee_id = 100");
		
		rs.next();
		
		int employee_id = rs.getInt(1);
		String first_name = rs.getString(2);
		String last_name = rs.getString("LAST_NAME");
		String gender = rs.getString("gender");
		
		System.out.println(employee_id + "," + first_name + "," + last_name + "," + gender );
	
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(Exception e2) {
			System.out.println("DB 연결 실패!");
			e2.printStackTrace();
		}
		
		
		
	}

}
