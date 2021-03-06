package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTestT {

	public static void main(String[] args) {
		File file = new File("d:/d_other/보노보노.jpg");
		
		if(!file.exists()) {
			System.out.println(file.getName() + " 파일이 없습니다.");
			System.out.println("복사 작업 중단");
			return;
		}
		
		try {
			// 파일을 입출력할 스트림객체 생성
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream("d:/d_other/연습용/복사본_국화2.jpg");
			
			//버퍼용 입출력 스트림 객체 생성
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			System.out.println("복사 작업 시작 ...");
//			int data;
//			while((data=fis.read()) != -1) {
//				fos.write(data);
//			}
			
			int data;
			while((data=bis.read()) != -1) {
				bos.write(data);
			}
			bos.flush();
			
//			byte[] arr = new byte[1024];
//			int len = 0;
//			while((len = fis.read(arr)) > -1) {
//				fos.write(arr, 0, len);
//			}
			bis.close();
			bos.close();
			//스트림 닫기
			fos.close();
			fis.close();
			System.out.println("복사 작업 끝");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
