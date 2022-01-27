package kr.or.ddit.basic;

import kr.or.ddit.util.CryptoUtil;

public class CryptoTest {
	
	public static void main(String[] args) throws Exception{
		 String plainText = "Hello, World 가나다라 마바사아 123456 &*()_+";
		 String key = "a1b2c3d4e5f6g7h8";
		 
		 System.out.println("원본 데이터 : " + plainText);
		 System.out.println("SHA-512방식 암호화 : " + CryptoUtil.sha512(plainText));
		 System.out.println("---------------------------------------------------------------");
		 
		 String enStr = CryptoUtil.encryptAES256(plainText, key);
		 System.out.println("AES 256 방식 암호화 : " + enStr);
		 
		 String deStr = CryptoUtil.decryptAES256(enStr, key);
		 System.out.println("AES 256 방식 복호화 : " + deStr);
		 
	}
	
	
	
}
