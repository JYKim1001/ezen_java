package com.lec.user;

import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.lec.user.ConnectionFactory;

public class ConnectionFactory {

private String path = ConnectionFactory.class.getResource("JDBCConnector1.properties").getPath();
	
	private String DRV = null;
	private String URL = null;
	private String USR = null;
	private String PWD = null;
	
	String insert = null; 
	String select = null; 
	String update = null; 
	String delete = null;
	
	public ConnectionFactory() {
		try {
			setUp();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void setUp() throws Exception {
		Properties p = new Properties();
		path = URLDecoder.decode(path,"utf-8");
		p.load(new FileReader(path));
		
		//1.DB 접속정보
		DRV = p.getProperty("DRV");
		URL = p.getProperty("URL");
		USR = p.getProperty("USR");
		PWD = p.getProperty("PWD");
		
		
		//2.SQL 정보
		insert = p.getProperty("insert");
		select = p.getProperty("select");
		update = p.getProperty("update");
		delete = p.getProperty("delete");
		
		System.out.println(DRV);
		System.out.println(URL);
		System.out.println(USR);
		System.out.println(PWD);
		/*
		
		System.out.println(insert);
		System.out.println(select);
		System.out.println(update);
		System.out.println(delete);
		*/
		
		Class.forName(DRV);
		
	}
	
	public Connection getConnection(){
		try {
			return DriverManager.getConnection(URL , USR , PWD);
		} catch (SQLException e) {
			System.out.println("DB 연결 실패!!");
			e.printStackTrace();
			return null;
		}
	}

	public String getInsert() {
		return insert;
	}

	public String getSelect() {
		return select;
	}

	public String getUpdate() {
		return update;
	}

	public String getDelete() {
		return delete;
	}
	
	
	
	
}
