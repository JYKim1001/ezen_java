package com.lec.ex02_file;

import java.io.FileReader;

public class FileReaderMain {

	public static void main(String[] args) throws Exception {
		
		//FileMain.java 파일 읽어 오기
		
		FileReader fr = new FileReader("src\\com\\lec\\ex02_file\\FileMain.java");
		
		int readChar;
		char[] cbuf = new char [100];
		while((readChar = fr.read(cbuf)) != -1) {
			String data =new String(cbuf,0 ,readChar );
			System.out.println(data);
		}
		fr.close();
	}

}
