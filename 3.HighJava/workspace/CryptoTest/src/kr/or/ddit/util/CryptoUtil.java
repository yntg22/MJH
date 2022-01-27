package kr.or.ddit.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtil {
	/**
	 * SHA-512방식의 단방향 암호화 메서드
	 * @param str 암호화할 문자열
	 * @return 암호화된 문자열
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public static String sha512(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//		MessageDigest md = MessageDigest.getInstance("MD5");
//		MessageDigest md = MessageDigest.getInstance("SHA-256");
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		
		md.update(str.getBytes("utf-8"));
		
		return Base64.getEncoder().encodeToString(md.digest());
	}
	
	// 양방향 암복호화 방식
	
		/**
		 *  AES 256 방식으로 암호화하는 메서드
		 * @param str 암호화할 문자열
		 * @param key 암호키 문자열
		 * @return 암호화된 문자열
		 * @throws UnsupportedEncodingException 
		 * @throws NoSuchPaddingException 
		 * @throws NoSuchAlgorithmException 
		 * @throws InvalidAlgorithmParameterException 
		 * @throws InvalidKeyException 
		 * @throws BadPaddingException 
		 * @throws IllegalBlockSizeException 
		 */
		public static String encryptAES256(String str, String key) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
			byte[] keyBytes = new byte[16];
			System.arraycopy(key.getBytes("utf-8"), 0, keyBytes, 0, keyBytes.length);
			
			// 비밀키 생성
			SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
			
			// Cipher 생성 및 초기화
			// 알고리즘/모드/패딩
			// CBC : Cipher Block Chainning Mode ==> 동일한 평문 블록과 암호문 블록의 쌍이
			//			발생하지 않도록 이전 단계의 암복호화한 결과가 현 단계에 영향을 주는 운영모드이다.
			// Padding : 마지막 블록이 블록의 길이와 항상 딱 맞아 떨어지지 않기 때문에 
			//			  부족한 길이만큼 '0'으로 채우거나 임의의 비트들로 채워 넣는것을 의미한다.
			// 
			
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			
			// 초기화 벡터(Initial Vector, IV)
			// 			==> 첫번째 블록을 암호화할 때 사용하는 값 (CBC모드에서 사용)
			//			==> 암호문이 패턴화 되지 않도록 사용하는 데이터를 말한다.
			String iv = key.substring(0, 16);
			
			byte[] ivBytes = new byte[16];
			System.arraycopy(iv.getBytes("utf-8"), 0, ivBytes, 0, ivBytes.length);
			
			// 암호를 옵션 종류에 맞게 초기화 한다.
			// 옵션 종류 : ENCRYPT_MODE(암호화 모드), DECRYPT_MODE(복호화 모드)
			c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(ivBytes));
			
			// 암호문 생성
			byte[] encrypted = c.doFinal(str.getBytes("utf-8"));
			
			// 암호화된 데이터를 encoding한다
			String enStr = Base64.getEncoder().encodeToString(encrypted);
			
			return enStr;
			
		}
		
		/**
		 * AES-256방식으로 암호화한 데이터를 복호화하는 메서드
		 * @param str 암호화된 문자열 (복호화할 데이터)
		 * @param key 암호키 문자열
		 * @return 복호화된 문자열
		 * @throws UnsupportedEncodingException 
		 * @throws NoSuchPaddingException 
		 * @throws NoSuchAlgorithmException 
		 * @throws InvalidAlgorithmParameterException 
		 * @throws InvalidKeyException 
		 * @throws BadPaddingException 
		 * @throws IllegalBlockSizeException 
		 */
		public static String decryptAES256(String str, String key) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
			byte[] keyBytes = new byte[16];
			System.arraycopy(key.getBytes("utf-8"), 0, keyBytes, 0, keyBytes.length);
			
			// 비밀키 생성
			SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
			
			// Cipher 생성 및 초기화
			// 알고리즘/모드/패딩
			// CBC : Cipher Block Chainning Mode ==> 동일한 평문 블록과 암호문 블록의 쌍이
			//			발생하지 않도록 이전 단계의 암복호화한 결과가 현 단계에 영향을 주는 운영모드이다.
			// Padding : 마지막 블록이 블록의 길이와 항상 딱 맞아 떨어지지 않기 때문에 
			//			  부족한 길이만큼 '0'으로 채우거나 임의의 비트들로 채워 넣는것을 의미한다.
			// 
			
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			
			// 초기화 벡터(Initial Vector, IV)
			// 			==> 첫번째 블록을 암호화할 때 사용하는 값 (CBC모드에서 사용)
			//			==> 암호문이 패턴화 되지 않도록 사용하는 데이터를 말한다.
			String iv = key.substring(0, 16);
			
			byte[] ivBytes = new byte[16];
			System.arraycopy(iv.getBytes("utf-8"), 0, ivBytes, 0, ivBytes.length);
			
			c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(ivBytes));
			
			// 암호화된 데이터를 decoding한다.
			byte[] byteStr = Base64.getDecoder().decode(str);
			
			return new String(c.doFinal(byteStr), "utf-8");
		}
}
