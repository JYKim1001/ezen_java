package com.lec.ex01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/*
 		JDBC 를 이용한 Java와 DB 연동하기
 		
 		Java 와 DB 를 연동하기 위해서는 각 RDBMS 의 버전에 맞는 JRE 실행환경 라이브러리를 Java 프로젝트에 추가해야 한다. 
 		
 		JDBC 드라이버는 DB 버전에 맞는 JDBC 드라이버(오라클은 ojdbc8.jar, mysql 은 mysql-connecter 등을)를 추가 해야 한다.
 		
 		(Oracle JDBC 의 버전 별 참고 사이트 https://oingdaddy.tistory.com/372)
 		
 		(mariaDB JDBC 의 버전 별 참고 사이트 https://mariadb.com/downloads/connectors/)
 		
 		(여러 가지 DB JDBC Connection 사이트 https://mvnrepository.com/)
 		
 		
 		A. 라이브러리를 추가하는 방법
 			1. Java Project 우클릭
 			2. Build Path > Add to Build Path
 				or Build Path > Configure Build Path > (tab)Libraries > (button) Add Jars... > (button) Apply & Close
 				
 		B. JDBC 프로그램 작성 단계
 		
 			1. JDBC 드라이버 로딩 (DB 에 따라 드라이버가 상이)
 				a. Oracle 	: Class.forName("oracle.jdbc.OcracleDriver")
 				b. mariadb 	: Class.forName("org.mariadb.jdbc.Driver")
 				c. mysql 	: Class.forName("com.mysql.jdbc.Driver")
 				
 				* Class.forName() 메서드는 클래스 파일 (*.class)파일을 읽어서 자동으로 객체를 생성해주는 메서드이다.
 				* DB 드라이버를 로딩하면 DriverManager 에 등록이 된다.
 				
 			2. Connection 객체 생성
 				Connection 객체에 연결하는 것은 DriverManager 에 등록된 각 드라이버를 getConnection() 메서드를 이용해서 식별한다.
 				getConnection 의 매개값은 'DB 의 URL 주소, 사용자 ID , 비밀번호'를 전달한다.
 				연결할 때 URL 식별자 정보를 이용해서 Mapping 을 하고 찾지 못했을 경우에는 에러가 발생한다.
 				getConnection() 메서드의 결과는 Connection 객체로 리턴한다.
 				
 				getConnection (String URL, String user, String password);
 				
 				a. oracle 	: getcConnection("jbdc:oracle:thin:@localhost:1521:xe", "hr" , "hr")
 				b. mariadb 	: getcConnection("jbdc:mariadb://localhost:3307:db 이름", "root" , "12345")
 				c. mysql 	: getcConnection("jbdc:mysql://localhost:3306:db 이름", "root" , "12345")
 		
 			3. Statement(Statement/PreparedStatement/CallableStatement)
 			
 				SQL 생성 및 실행을 하면 반환된 결과를 가져오게 할 작업영역을 제공한다.
 				Statement 객체는 Connection() 메서드를 사용하여 생성한다.
 				
 				이 단계부터는 JDBC 드라이버에 구애를 받지 않는다.
 				즉, DB와 상관없이 동일한 명령으로 사용할 수 있다.
 				단, SQl 표준문법을 준수할 경우에는 동일함 SQL 명령을 사용할 수 있따.
 				DB마다 고유한 SQL 명령이라면 각 DB의 문법에 맞게 작성되어야 한다.
 				
 				Statement stmt = conn.createStatement()
 				PreparedStatement pstmt = conn.Statement();
 				CallableStatement cstmt = conn.preparedCall("{call 스트어드 프로시저명 (?,?,?)}");
 				
 				예시)
 					Statement = select * from xxx where id = 10;
 					PreparedStatement = select * from xxx where id = ?;
 					CallableStatement = insert into values(?,?,?);	
 		
 			4. Query 실행
 				Statement 객체가 생성된 후에 Statement 객체의 executeQuery(), executeUpdate() 메서드를 사용하여 처리한다.
 				이 객체는 ResultSet 이라는 객체를 리턴한다.
 				
 				ResultSet rs = stmt.executeQuery("select * from user");
 				ResultSet rp = pstmt.executeQuery("select * from user where id = ? and name = ?");
 				ResultSet rc = cstmt.executeQuery();
 */

public class JDBCConnection {

	final static String DRV = "oracle.jdbc.OcracleDriver";
	final static String URL = "jbdc:oracle:thin:@localhost:1521:xe";
	final static String USR = "hr";
	final static String PWD = "hr";
	
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from employees where employees_id = 100";
		
		try {
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			
			int emplyee_id = rs.getInt(1);
			String first_name = rs.getString(2);
			String last_name = rs.getString("LAST NAME");
			int salary = rs.getInt("salary");
			
			System.out.println(emplyee_id + ", " + first_name + "," + last_name + "," + salary);
			
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
