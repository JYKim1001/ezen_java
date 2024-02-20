package com.lec.board;

public class BoardFactory {

	//1. 외부에서 생성자를 접근하지 못하도록 private 으로 접근 제한
	private BoardFactory() {}
	
	//2. DAO 를 1개만 생성하도록 정적메세드로 저의
	private static BoardDAOImpl bddao = null;
	
	//3. getter 로 접근
	public static BoardDAOImpl getInstance() {
		if(bddao == null) bddao = new BoardDAOImpl();
		return bddao;
	}



	
	
}
