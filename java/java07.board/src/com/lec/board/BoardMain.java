package com.lec.board;

public class BoardMain {

	/*
		게시판 Application
		
		1. Board Database 생성(MySQL)
		
			1) create database board;
		
			2) board 테이블 생성
		
				create table board(
	            bno         number         not null primary key
	           , subject      varchar2(100)   not null
	           , writer      varchar2(50)   not null
	           , content    varchar2(256)   
	           , crtdate      date         default now()
	           , readcnt         number        default 0
      			);
			
		         CREATE TABLE BOARD (
		           bno  int NOT NULL AUTO_INCREMENT COMMENT '글번호',
		           subject varchar(100) NOT NULL COMMENT '글제목',
		           writer  varchar(50) NOT NULL COMMENT '작성자',
		           content varchar(255) DEFAULT NULL COMMENT '본문글',
		           crtdate date DEFAULT (now()) COMMENT '작성일',
		           readcnt int DEFAULT NULL COMMENT '조회수',
		           PRIMARY KEY (`bno`)
		         );

		
		2. DB 접속 정보
		
			JDBCConnector1.properties
		
		3. board application
		
			1) BoardMain			: 게시판 메인 클래스
			2) VoardVO				: 게시판 Model 클래스(DTO)
			3) ConnectionFactory	: DB 접속 정보를 공통으로 사용하기 위한 클래스 (Factory Pattern)
			4) BoardDAOService		: 게시판 Interface 클래스(DAO - Interface)
			5) BoardDAOImpl			: 게시판 구현 클래스 (DAO)
			6) BoardFactory			: 게시판 생성 클래스 (Singleton Pattern)
			7) BoardMenu			: 게시판 메인메뉴 클래스



create database users
create table user(id, name, tel, ssn)
user application
UserMainn, UserVO, ConnectionFactory, UserDAOService , UserDAOImpl , UserFactory , UserMen
	 */
	
	public static void main(String[] args) throws Exception {
		
		BoardMenu menu = new BoardMenu(1.0);
		menu.mainBoardMenu();
		
	}

}
