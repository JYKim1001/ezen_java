package com.lec.ex02_connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyDBConnection {

	public static void main(String[] args) {

		Connection conn = JDBCConnector.getConnection();
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from employees where department_id =?");
			pstmt.setInt(1, 110);
			rs = pstmt.executeQuery();
			
			System.out.println("=========================================");
			System.out.println("사원번호\t사원이름\t급여\t전화번호\t");
			System.out.println("=========================================");
			
			while(rs.next()) {
				int employee_id = rs.getInt(1);
				String first_name = rs.getString(2);
				String last_name = rs.getString("last_name");
				int salary = rs.getInt("salary");
				String phone_number = rs.getString("phone_number");
				
				System.out.print(employee_id + "\t" );
				System.out.print(first_name + "." + "\t" );
				System.out.print(last_name + "\t" );
				System.out.print(salary + "\t" );
				System.out.println(phone_number + '\t');
			}
			
			
		}catch(Exception e) {
			System.out.println("DB 연결 실패!");
			e.printStackTrace();
		}finally {
			JDBCConnector.close(conn, pstmt, rs);
		}
	}

}
