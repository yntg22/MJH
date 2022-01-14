package h_exception;

import java.io.IOException;

public class ThrowException {

	public static void main(String[] args) {
		//예외 발생시키기
		try {
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//========================================================//
//		throw new NullPointerException();
		
//		String str = null;
//		
//		str.equals(""); //null은 비교할수없다
	//=======================================================//
//		throw new IndexOutOfBoundsException(); //인덱스의범위를 벗어났다
		
//		int[] arr = new int[5];
//		
//		System.out.println(arr[5]);
		
		
		
		
	}

}
