package com.lec.board;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.security.auth.Subject;
import javax.swing.JOptionPane;

public class BoardMenu {
	
	private double ver;
	
	public BoardMenu(double ver) {
		this.ver = ver;
		
	}
	
	public void mainBoardMenu() throws Exception {
		
		BoardDAOImpl bddao = BoardFactory.getInstance();
		
		while(true) {
			int menuNo = mainMenuUi();
			switch(menuNo) {
			case 1: makeBoard(bddao); break;
			case 2: listBoard(bddao); break;
			case 3: contentView(bddao); break;
			case 4: updateBoard(bddao); break;
			case 5: deleteBoard(bddao); break;
			case 6: findBySubject(bddao); break;
			case 7: findByWriterBoard(bddao);System.out.println("게시판 검색하기(작성자)"); break;
			case 0: System.out.println("프로그램 종료"); System.exit(0);
			}
		}
	}

	
	private void findByWriterBoard(BoardDAOImpl bddao) {
		
		//실습 . 작성별 글목록 조회하기
		//findBySubject() 와 동일 로직
		
		String writer = JOptionPane.showInputDialog("검색할 글목록를 입력하세요!");
		
		ArrayList<BoardVO> boards = bddao.findByWriterBoard(writer);
		//select * from board where content like "%목록%";
		//listBoard 와 유사한 로직
		
		System.out.println("=======================================================");
		System.out.println("글번호\t\t제목\t\t작성자\t\t글내용");
		System.out.println("=======================================================");
		
		for(BoardVO board : boards) {
			System.out.println(board.toString());
		}
		
		System.out.println("-------- 게시판 목록 출력 종료 ---------\n\n");
		
	}
	
	
	private void findBySubject(BoardDAOImpl bddao) {
		String subject = JOptionPane.showInputDialog("검색할 글제목를 입력하세요!");
		
		ArrayList<BoardVO> boards = bddao.findBySubjectBoard(subject);
		//select * from board where subject like "%제목%";
		//listBoard 와 유사한 로직
		
		System.out.println("=======================================================");
		System.out.println("글번호\t\t제목\t\t작성자\t\t글내용");
		System.out.println("=======================================================");
		
		for(BoardVO board : boards) {
			System.out.println(board.toString());
		}
		
		System.out.println("-------- 게시판 목록 출력 종료 ---------\n\n");
		
		
		
		
	}
	
	
	
	
	private void deleteBoard(BoardDAOImpl bddao) {
		
		String bno = JOptionPane.showInputDialog("삭제할 글번호를 입력하세요!");
		if((bno == null) || (bno.equals(""))) {
			return;
		}else {
			bddao.deleteBoard(Integer.parseInt(bno));	
		}
		
		
	}
	
	
	private void updateBoard(BoardDAOImpl bddao) {
		
		String bno = JOptionPane.showInputDialog("수정할 글번호를 입력하세요!");
		if((bno == null) || (bno.equals(""))) {
			return;
		}else {
			bddao.updateBoard(Integer.parseInt(bno));	
		}
		
	}
	
	
	
	private void contentView(BoardDAOImpl bddao) {
		String bno = JOptionPane.showInputDialog("조회할 글 번호를 입력하세요!");
		
		if(bno == null || bno.equals("")) {
			return;
		}else {
			BoardVO board = bddao.viewBoard(Integer.parseInt(bno));	
			System.out.println("글제목 : " + board.getSubject());
			System.out.println("작성자 : " + board.getWriter());
			System.out.println("글내용 : " + board.getContent());
		}
	}
	
	
	
	private void listBoard(BoardDAOImpl bddao) throws Exception {
		ArrayList<BoardVO> boards = bddao.listBoard();
		
		System.out.println("=======================================================");
		System.out.println("글번호\t\t제목\t\t작성자\t\t글내용");
		System.out.println("=======================================================");
		
		for(BoardVO board : boards) {
			System.out.println(board.toString());
		}
		
		
		
		
		
		// 실습. 결과물 boards 를 boards.txt 파일로 출력(저장)하세요!
		
		for(BoardVO board : boards) {
			File file = new File("src\\com\\lec\\board\\boards.txt");
			
			FileWriter fw = new FileWriter(file , false);
			
			fw.write("=======================================================\n"
					+"글번호\t\t제목\t\t작성자\t\t글내용\n" 
					+"=======================================================\n"
					+boards.toString());
			
			fw.flush();
			fw.close();
		}
	
		
		System.out.println("\n파일이 성공적으로 저장되었습니다!\n");
		
		
			File file = new File("src\\com\\lec\\board\\boards.html");
			
			FileWriter fw = new FileWriter(file , false);
		
		for(BoardVO board : boards) {	
			
			fw.write("<table board ='1'>");
			
			fw.write(board.toHtml());
			
		}
		
		
		System.out.println("-------- 게시판 목록 출력 종료 ---------\n\n");
	}
	
	
	private void makeBoard(BoardDAOImpl bddao) {
		bddao.createBoard();
	}
	
	
	private int mainMenuUi() {
		String menuNo = JOptionPane.showInputDialog(
				"===== 게시판 관리 프로그램 V" + this.ver + "=======\n\n"+
				"1. 새로운 글쓰기 \n" +
				"2. 전체글 목록 조회\n"+
				"3. 본문글 보기\n"+
				"4. 본문글 수정\n"+
				"5. 본문글 삭제\n"+
				"6. 제목으로 검색하기\n"+
				"7. 작성자로 검색하기\n"+
				"0. 종료\n\n"+
				"처리할 작업 번호를 입력하세요!! : "
				
		);
		if((menuNo == null) || (menuNo.equals(""))) {
			return 0;

		}else {
			return Integer.parseInt(menuNo);
		}

		
		
	}

}



