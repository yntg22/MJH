package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {
		// File객체 만들기 연습
		
		// 1. new File(String 파일 또는 경로);
		//		==> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의
		//			구분문자는 '/'를 사용하거나 '\'를 사용할 수 있다.
		
		File file1 = new File("d:/D_Other/test.txt"); //구분문자를 '/'로 사용
		File file2 = new File("d:\\D_Other\\test.txt"); //구분문자를 '\'로 사용
		
		System.out.println("파일명 : " + file1.getName()); //파일이름 가져오기
		System.out.println("Path : " + file2.getPath()); //파일경로와 이름?
		System.out.println("디렉토리 여부 : " + file1.isDirectory());
		System.out.println("파일 여부 : " + file1.isFile());
		System.out.println("--------------------------------------");
		
		File file3 = new File("d:/d_other");
		
		System.out.println("파일명 : " + file3.getName()); //파일이름 가져오기
		System.out.println("Path : " + file3.getPath()); //파일경로와 이름?
		System.out.println("디렉토리 여부 : " + file3.isDirectory());
		System.out.println("파일 여부 : " + file3.isFile());
		System.out.println("--------------------------------------");
		
		File file4 = new File("d:/testtesttest");
		
		System.out.println("파일명 : " + file4.getName()); //파일이름 가져오기
		System.out.println("Path : " + file4.getPath()); //파일경로와 이름?
		System.out.println("디렉토리 여부 : " + file4.isDirectory());
		System.out.println("파일 여부 : " + file4.isFile());
		System.out.println("--------------------------------------");
		
		// 2. new File(File parent, String child)
		//		==> 'parent'디렉토리 안에 있는 'child'를 갖는다.
		File file5 = new File(file3, "test.txt");
		
		System.out.println("파일명 : " + file5.getName()); //파일이름 가져오기
		System.out.println("Path : " + file5.getPath()); //파일경로와 이름?
		System.out.println("디렉토리 여부 : " + file5.isDirectory());
		System.out.println("파일 여부 : " + file5.isFile());
		System.out.println("--------------------------------------");
		
		// 3. new File(String parent, String child)
		File file6 = new File("d:/d_other", "test.txt");
		
		System.out.println("파일명 : " + file6.getName()); //파일이름 가져오기
		System.out.println("Path : " + file6.getPath()); //파일경로와 이름?
		System.out.println("디렉토리 여부 : " + file6.isDirectory());
		System.out.println("파일 여부 : " + file6.isFile());
		System.out.println("--------------------------------------");
		
		
		
		
		
		
		
	}

}
