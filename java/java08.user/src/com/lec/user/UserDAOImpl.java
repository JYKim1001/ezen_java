package com.lec.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.lec.user.UserVO;
import com.lec.user.ConnectionFactory;

public class UserDAOImpl {

private UserVO inputUser() {
		
		UserVO user = new UserVO();
		
		String id = JOptionPane.showInputDialog("아이디를 입력하세요!");
		String name = JOptionPane.showInputDialog("작성자를 입력하세요!");
		String tel = JOptionPane.showInputDialog("전화번호를 입력하세요!");
		
		
		user.setId(id);
		user.setName(name);
		user.setTel(tel);
		
		return user;
	}
	
	
	
	public void createUser() {
		// 글제목 , 작성자 , 글내용
		UserVO user = inputUser();
	
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		String sql = cf.getInsert();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getTel());
			
			int row = pstmt.executeUpdate();
			System.out.println(row + "건이 성공적으로 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				//dummy
			}
		}
		
		
		
	}


	
}
