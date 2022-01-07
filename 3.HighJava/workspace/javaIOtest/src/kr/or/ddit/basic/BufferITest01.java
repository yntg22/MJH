package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferITest01 {

	public static void main(String[] args) {
		// 입출력의 성능 향상을 위하여 Buffered 스트림을 사용한다.
		try {
			// 기반 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
			
			// 버퍼의 크기가 5인 Buffered스트림 객체 생성
			// 버퍼의 크기를 지정하지 않으면 기본크기인 8Kb(81976byte)
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for (int i = '1'; i <= '9'; i++) {
				bout.write(i);
			}
			bout.flush();
			
			bout.close();
			System.out.println("작업 끝...");
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

}
