package com.lec.user;

import java.util.ArrayList;

import com.lec.user.UserVO;

public interface UserDAOService {

	void createUser();										//1. 글쓰기
	ArrayList<UserVO> listUser(); 						//2. 글몰록
	UserVO viewuser();								//3. 글조회
	void updateUser(); 								//4. 글수정
	void deleteUser(); 								//5. 글삭제
	ArrayList<UserVO> findBySubjectUser(String Id); 	//6. 글검색 by 제목
	ArrayList<UserVO> findByWriterUser(String name); 	//7. 글검색 by 작성자
	
}
