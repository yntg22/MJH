package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {

	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; //입력할 때 사용할 byte배열
		
		//입력과 출력을 담당할 스트림 객체 생성
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			// 읽어올 데이터가 있는지 확인 [읽고남은데이터가 몇개냐 = available]
			while(input.available()>0) {
//				input.read(temp); //temp바이트배열 크기만큼 읽어와서 temp에 저장한다 == 4byte씩 읽어온다.
//				output.write(temp);
				
				int len = input.read(temp);
				output.write(temp, 0, len);
				System.out.println("반복문 안에서 temp : " + Arrays.toString(temp));
			}
			
			outSrc = output.toByteArray();
			
			System.out.println("  inSrc = " + Arrays.toString(inSrc));
			System.out.println(" outSrc = " + Arrays.toString(outSrc));
			
			input.close();
			output.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
