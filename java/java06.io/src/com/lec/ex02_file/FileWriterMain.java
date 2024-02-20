package com.lec.ex02_file;

import java.io.File;
import java.io.FileWriter;

public class FileWriterMain {

	public static void main(String[] args) throws Exception {
		
		/*
		File file = new File("c:/temp/야생화.txt");
		FileWriter fw = new FileWriter(file, false);
		
		fw.write("하얗게 피어난\n");
		fw.write("장미꽃 하나가\n");

		fw.flush();
		fw.close();
		System.out.println("파일이 성공적으로 저장되었습니다.!");
		*/
		
		File file = new File("c:/temp/index.html");
		FileWriter fw = new FileWriter(file, false);
		
		fw.write("<h1> 박효신의 야생화 </h1>");
		fw.write("<h2> 박효신의 야생화 </h2>");
		fw.write("<h3> 박효신의 야생화 </h3>");
		
		fw.write("<hr>");
		
		fw.write("<h4> 하얗게 피어난 </h4>");
		fw.write("<h5> 장미꽃 하나가 </h5>");
		
		System.out.println("파일이 성공적으로 저장되었습니다.!");
		
		
	}

}
