package h_exception;

import java.io.IOException;

public class ThrowsException {

	public static void main(String[] args) {
		//메서드에 예외 선언하기
		//호출하는쪽이 예외처리를 해야함 (예외를 떠넘기다..?)
		try {
			method();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void method() throws IOException {
		throw new IOException();
	}

}
