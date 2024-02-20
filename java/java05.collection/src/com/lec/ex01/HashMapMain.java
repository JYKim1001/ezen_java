package com.lec.ex01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		
		// 1. Map 객체 생성
		
		Map<String, Integer> map = new HashMap<>();
		map.put("홍길동",100);
		map.put("홍길동",90);
		
		System.out.println(map.size());		// Key 의 갯수
		System.out.println(map.get("홍길동"));
		
		System.out.println();
		
		Map<Student, Integer> students = new HashMap<Student, Integer>();
		students.put(new Student(1,"소향"), 100);
		students.put(new Student(1,"소향"), 90);
		System.out.println(map.size());
		
		System.out.println();
		
		Set<Student> keyset = students.keySet();		//keySet = return 값이 students
		Iterator<Student> xxx = keyset.iterator();
		
		while(xxx.hasNext()) {
			Student student = xxx.next();
			Integer score = students.get(student);
			System.out.println(student + "의 점수 = " + score );
		}
		
		
		
	}
}

class Student{
	
	private int sno;
	private String name;
	
	
	public Student(int i, String string) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student [sno=" + sno + ", name = " + name + "]";
	}
	
	
}
