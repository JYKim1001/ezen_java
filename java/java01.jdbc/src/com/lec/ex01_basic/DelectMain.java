package com.lec.ex01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DelectMain {

	final static String DRV = "oracle.jdbc.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String USR = "hr";
	final static String PWD = "hr";
	
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL,USR,PWD);
			sql = "delete from employees where employee_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1000);
			int row = pstmt.executeUpdate();
			
			System.out.println(row + "건이 삭제되었습니다.");
			
			
			
		}catch(Exception e) {
			System.out.println("DB 연결 실패!");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
		
			}	
		}
	}
}
