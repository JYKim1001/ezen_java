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
 				
 				a. oracle 	: getcConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr" , "hr")
 				b. mariadb 	: getcConnection("jdbc:mariadb://localhost:3307:db 이름", "root" , "12345")
 				c. mysql 	: getcConnection("jdbc:mysql://localhost:3306:db 이름", "root" , "12345")
 		
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
 			
 			5. ResultSet 처리
 			
 				executeQuery() 메서드 결과를 ResultSet 으로 리턴한다.
 				이 ResultSet 으로 부터 읽은 데이터를 추출하는 과정이 ResultSet 을 처리하는 과정이다.
 				
 				데이터를 추출하는 방법은 ResultSet 에서 rs.next() 메서드로 한 행(row)씩 이동하면서 getXXX() 메서드를
 				이용하여 데이터를 추출하는데 이때 rs.getInt() or rs.getString() 메서드로 한 컬럼의 정보를 추출한다.
 				
 		
 		C. JDBC 에서 사용되는 객체
 		
 			1. DriveManager
 				DriveManager 클래스는 데이터 원본에 JDBC 드라이버를 통해 Connection 객체를 만드는 역할을한다.
 				DriveManager 클래스는 Class.forName() 메서드를 통해 생성되는데 이 메서드는 인터페이스 드라이버를 구현하는 작업을 한다.
 				
 				Class.forName() 처럼 특징 클래스를 로드하면 자동으로 객체가 생성되고 DriverManager 에 등록된다.
 				드라이버를 찾지 못했을 경우에는 forName() 메서드는 ClassNotFoundException 예외를 발생시키기 때문에 반드시 예외 처리를 해야 한다.
 				
 				일반적으로 드라이버 클래스들은 로드될 때 자신의 인스턴스를 생성하고 자동으로 DriverManager 클래스의 메서드를 호출하여
 				그 인스턴스를 등록한다. DriverManager 클래스의 모든 메서드는 static 메서드이기 때문에 객체를 생성할 필요가 없다.
 				
 				DriveManager 클래스 Connection 인터페이스의 구현 객체를 생성하는데 getConnection() 메서드를 사용한다.
 				
 			2. Connection 인터페이스
 				특정 데이터 원본에 대한 커넥션은 Connection 인터페이스가 구현된 클래스의 객체로 표현된다.
 				특정의 SQL 문을 실행 시키기 전에 우선 Connection 객체 있어야 한다.
 				Connection 객체는 특정 데이터 원본과 연결된 Connection 을 나타내고 특정한 SQL 문장을 정의하고 실행 시킬 수 있는 Statement 객체를 생성할 때도
 				Connection 객체를 사용한다.
 				
 				또한, Connection 객체는 데이터 베이스에 대한 메타 정보를 데이터 원본에 질의하는데 사용한다.
 				이때에는 사용 가능한 테이블의 이름, 특정 테이블의 컬럼 정보를 포함한다.
 				
 			
 			3. Statement 인터페이스
 				Statement 인터페이스는 Connection 객체에 의한 리턴되는 일정의 메서드 집합을 의미한다.
 				Statement 객체는 Statement 인터페이스를 구현한 객체로서 항상 매개 변수가 없는 createStatement() 메서드를 호출함으로서 얻어 진다.
 				
 				일단, Statement 객체를 생성하면 Statement.executeQuery() 메서드를 호출해서 SQL 빌의를 실행시킬 수 있다.
 				메서드의 매개값으로 ,SQL 문장을 저장한 String 객체를 전달한다. STatement 객체는 단순질의문을 사용하는 것이 좋다.
 			
 			4. PreparedStatement 인터페이스
 				PreparedStatement 인터페이스는 Connection 객체의 PreparedStatement() 메서드를 사용해서 객체를 생성한다.
 				PreparedStatement 객체는 SQL 문장이 사전에 컴파일이 되어 실행 시간 동안 파라미터 값을 위한 공간을 확보 한다는 점에서 Statement 객체와 구별된다.
 				
 				PreparedStatement 객체는 동일한 질의문을 특정값만 변경해서 여러번 반복 실행해야 할 때, 많은 데이터를 다루는 SQL 문을 간략하게 할때,
 				파라미터값이 많아서 SQL을 간단하게 할 필요가 있을 때 사용하면 유용하다.
 				또한, Statement 객체의 SQL문은 실행할 때마다 DB 서버에서 SQL문이 분석이 되어야 하지만
 				PreparedStatement 객체는 한번만 분셕(컴파일)이 되면 재사용할 수 있다는 강점이 있다.
 				
 				PreparedStatement 인터페이스는 각각의 매개값의 위치홀더(placeholder,?)를 사용하여 SQL문장을 정의할 수 있게 해준다.
 				위치홀더는 물음표(?)로 표현된다.
 				위치홀더는 SQL문장에 나타나는 토큰(token)인데 이것은 SQL 문장이 실행되기 전에 실제값으로 대체된다.
 				이런 방법을 사용하면 특정값으로 문자열을 연결하는 방법보다 훨씬 쉽게 SQL 문장을 만들 수 있다.
 				
 				PreparedStatement 객체는 각각의 SQL 데이터타입을 처리할 수 있는 setXXX() 메서드를 제공한다.
 				여기서 XXX 는 해당 테이블의 컬럼데이터타입과 관련이 있다.
 				해당 필드의 데이터타입이 문자열이면 setString(), 숫자일 경우 setInt(), setDouble() 등이 있다.
 				setXXX(위치, 값) 형태로 매개값을 전달한다.
 				위치는 위치홀더의 순서위치를 의미한다.
 				
 				PreparedStatement 객체가 제공하는 메서드는
 				
 				setString , setInt , setLong , setDouble , setDate , setTimestamp , setObject 가 있다.
 				
 				PreparedStatement의 장점
 				1) 동일한 SQL문을 특정값만 변경해서 여러번 실행해야할 경우, 많은 데이터를 처리할 경우
 				매개값이 많아서 SQL문을 간소화할 경우 등 사용하면 편리하다.
 				2) 사전에 컴파일이 되기 때문에 쿼리의 실행속도가 Statement 객체 보다 빠르다.
 				3) Statement 객체는 쿼리 실행 시에 작은 따오표(')가 있으면 작은 따옴표 2개로 표시해야 하는 번거로움이 있지만
 				PreparedStatement 객체는 작은 따옴표의 문제를 쿼리 실행 시에 자동처리하기 때문에 신경을 쓸 필요가 없다.
 				
 			
 			5. CallableStatement 인터페이스
 				CallableStatement 인터페이스는 Connection 객체의 prepareCall() 메서드를 이용해서 객체를 생성한다.
 				CallableStatement 객체는 주로 스토어드프로시저(Stored Procedure, Function)를 실행하기 위해서 사용한다.
 				Stored Procedure 는 사전에 저장된 쿼리를 사용해서 DB 서버가 처리하기 때문에 수행 속도가 빠르다.
 				
 				사용방법 : CallableStatement cstmr = conn.prepareCall();
 				
 				CallableStatement 는 데이터베이스에 저장된 Stored Procedure 를 호출하는 것만으로 실행이 가능하며
 				conn.prepareCall("{call 프로시저명(?,?.....)}")의 형태로 사용한다.
 				
 				CallableStatement 의 호출방법은 다음과 같다.
 				1) 단순 호출 : { call 프로시저명(?,?....)}
 				2) 호출결과를 리턴 : { ? = call 프로시저명(?,?....)}
 				3) 파라미터가 없는 프로시저 호출 { call 프로시저명() }
 				
 				
 			6. ResultSet 인터페이스
 				SQL문 중에서 Select 문을 사용한 쿼리가 성공했을 경우에 그 결과로 ResultSet 객체를 리턴한다.
 				ResultSet 은 SQL 질의에 의해 생성된 테이블(커서)를 저장하고 있다.
 				또한, ResultSet 객체는 Cursor 객체를 가지고 있는데 이것으로 특정값에 대한 참조를 처리할 수 있다.
 				
 				커서는 초기에 첫 번째 행의 바로 앞을 가리키도록 되어 있는데 ResultSet 객체의 next() 메서드를 이용해서 다음 행으로 이동할 수가 있다.
 				
 				ResultSet 의 메서드
 				1) first()	: 커서를 첫 번째 행으로 이동
 				2) last()	: 커서를 마지막 행으로 이동
 				3) beforeFirst() : 커서를 첫 번째 이전으로 이동
 				4) afterLast() : 커서를 마지막행 이후로 이동
 				5) next()	: 커서를 다음행으로 이동
 				6) previous() : 커서를 이전행으로 이동
 			
 				ResultSet 에서 행을 처리하는데 반복문을 사용하여 next() 메서드가 유효한 행이 true, 없으면 false 를 리턴하는 것을 이용하여
 				while 문으로 제어할 수 있다. 
 				ResultSet 객체에서 값을 가져올 경우 getXxx()메서드를 사용한다.
 				
 				ResultSet 이 제공하는 메서드
 				
 				getString , getInt , getLong , getDouble , getFloat , getDate , getTimestamp , getObject , getBytes 가 있다.
 				
 			
 			7. JDBC Transaction
 				
 				Transaction 은 여러 단계의 작업을 일괄로 처리하는 것으로 하나의 작업으로 인식된 작업이 모두 성공적으로
 				종료가 된면 commit 가 되고 하나라도 문제가 있을 경우 rollback 이 되어서 작업 수행전으로 되돌린다.
 				이런 처리리로 Transaction 은 데이터의 정확성을 보장하게 된다.
 				
 				Connection 객체는 commit() , rollback() 메서드를 제공한다.
 				기본적으로 Connection 객체는 setAutoCommit(boolean) 메서드를 제공하는데
 				기본값이 ture 로 설정 되어 있다. 그렇기 때문에 JDBC 는 commit 이 자동으로 수행되는데
 				자동으로 수행되는 것을 방지하려면 conn.setAutoCommit(false)로 지정헤야 한다.
 			
 			
 			
 			
 			
 			
 */

public class JDBCConnection {

	final static String DRV = "oracle.jdbc.OracleDriver";
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String USR = "hr";
	final static String PWD = "hr";
	
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
