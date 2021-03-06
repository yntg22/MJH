package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.stream.FileImageInputStream;

public class FileCopyTest {

	/*
		문제)
			'd:/d_other' 폴더에 있는 '보노보노.jpg'파일을
			'd:/d_other/연습용' 폴더에 '복사본_보노보노.jpg'로 복사하는 프로그램을 작성하시오.
	*/
	
	public static void main(String[] args) {

		try {
			//읽어올 파일정보를 인수값을 받는 FileInputStream객체 생성
			
			// 방법 1
//			FileInputStream fin = new FileInputStream("d:/d_other/test.txt");
			// 방법2
			File file = new File("d:/d_other/보노보노.jpg");
			FileInputStream fin = new FileInputStream(file);
			
			//인풋스트림과 파일리더의 차이는 읽어오는 byte 수의 차이이다?
			//텍스트 파일 이외에 그림파일..등등은 읽어오다가 flag(-1)로 읽혀서 멈춘다?
			//그래서 크기가 작은 파일들로 실험하다보면 성공할수도 있다
			
			
			FileOutputStream fout = new FileOutputStream("d:/d_other/연습보노보노3.jpg");
			int c;
			while( (c = fin.read()) != -1) {
				//읽어온 데이터를 화면에 출력하기
				fout.write(c);
			}
			
			
			
			System.out.println("출력 작업 완료...");
			
			fout.close(); // 스트림 닫기
			
			// 작업 완료 후 스트림 닫기
			fin.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("입출력 오류입니다.");
			e.printStackTrace();
		}
	}

}
