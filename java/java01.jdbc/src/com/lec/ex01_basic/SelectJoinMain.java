package com.lec.ex01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectJoinMain {

	
	final static String DRV = "oracle.jdbc.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String USR = "hr";
	final static String PWD = "hr";
	
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	
	public static void main(String[] args) {
		try {
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL,USR,PWD);
			String sql = "	select EMPLOYEE_ID 사원번호"
					+ "			, FIRST_NAME || '.' || LAST_NAME as 사원이름"
					+ "			, EMP.DEPARTMENT_ID	부서번호"
					+ "			, DPT.DEPARTMENT_NAME	부서이름"
					+ "		from EMPLOYEES	emp	"
					+ "			, DEPARTMENTS dpt"
					+ "		where emp.DEPARTMENT_ID = dpt.DEPARTMENT_ID"
					+ "		and emp.DEPARTMENT_ID = ?";
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 100);
			rs = pstmt.executeQuery();
			
			System.out.println("====================================================================");
			System.out.println("사원번호\t사원이름\t부서번호\t부서이름");
			System.out.println("====================================================================");
			
			while(rs.next()) {
				int employee_id = rs.getInt(1);
				String emp_name = rs.getString(2);
				int dept_id = rs.getInt(3);
				String dept_name = rs.getString(4);

				System.out.print(employee_id + "\t" );
				System.out.print(emp_name + "." + "\t" );
				System.out.print(dept_id + "\t" );
				System.out.println(dept_name + "\t" );
			}
		}catch(Exception e) {
			System.out.println("데이터 베이스 연결 실패!!");
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
