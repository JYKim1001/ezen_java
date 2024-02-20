package com.lec.ex01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {

	public static void main(String[] args) {
		
		
		//1. Non-Generic
		
		List list1 = new ArrayList();
		list1.add("문자열");
		list1.add(new String("문자열"));
		list1.add(100);
		list1.add(new User());
		list1.add(new Member());
		
		String str1 = (String) list1.get(0);
		String str2 = (String) list1.get(1);
		int age = (int) list1.get(2);
		User user = (User) list1.get(3);
		Member member = (Member) list1.get(4);
				
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println();
		
		
		
		//2. Generic
		
		List<String> list2 = new ArrayList();
		list2.add("문자열");
		//list2.add(new User());		//List 는 애초에 String 문자열로 받기로 설정해 놨기 때문에 , 오류 발생
		list2.add("손흥민");
		
		String str3 = list2.get(0);
		String str4 = list2.get(1);		//get 을 이용하여 List 에 추가한 데이터 불러오기
		
		System.out.println(str3);
		System.out.println(str4);
		

	}

}

class User {
	String name;
	int age;
	
	
}

class Member{
	int id;
	String name;
}