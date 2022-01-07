package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest04 {
	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일로 저장하기
		// 콘솔로 출력한다 = 모니터에 출력한다 | 콘솔로 입력한다 = 키보드나 마우스로 입력한다
		try {
//			System.out.print("아무거나 입력하세요 : ");
//			int c = System.in.read();
//			
//			System.out.println("입력값 : " + (char)c);
			
			// InputStreamReader
			//		==> 바이트 기반의 스트림을 문자 기반의 스트림으로 변환해주는 보조스트림
			InputStreamReader isr = new InputStreamReader(System.in);
			
			// 파일로 출력하기 위한 문자 기반의 스트림 객체 생성
			FileWriter fw = new FileWriter("d:/d_other/testChar.txt");
			
			int c;
			
			System.out.println("아무 내용이나 입력하세요(입력의 끝은 Ctrl + Z 입니다.)");
			
			while((c = isr.read()) != -1) { // 키보드로 입력한 값을 읽어들인다.
				fw.write(c); 	// 콘솔로 입력 받은 데이터를 파일에 출력한다.
			}
			
			System.out.println("완료");
			isr.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
