package kr.or.ddit.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.CryptoUtil;

public class MemberController {
	private IMemberService memService;  // service객체가 저장될 변수 선언
	private Scanner scan = new Scanner(System.in);
	
	// 생성자
	public MemberController() {
		//memService = new MemberServiceImpl(); // service객체 생성
		memService = MemberServiceImpl.getInstance(); // service객체 생성
	}
	
	public static void main(String[] args) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		new MemberController().memberStart();
	}
	
	// 시작 메서드
	public void memberStart() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		System.out.println();
		System.out.println("=========================");
		System.out.println("    회 원 관 리 프 로 그 램");
		System.out.println("=========================");
		System.out.println();
		while(true) {
			int choice = displayMenu();
			switch(choice) {
				case 1 :	// 추가 
					insertMember(); break;  
				case 2 :	// 삭제 
					deleteMember(); break;
				case 3 :	// 전체 수정 
					updateMember(); break;
				case 4 :	// 전체 자료 출력
					displayMember();
					break;
				case 5 :	// 원하는 항목 수정 
					updateMember2(); 
					break;
				case 0 :
					System.out.println("프로그램을 종료합니다.");
					return;
				default : System.out.println("작업 번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}
	}
	
	
	// 회원 정보를 수정하는 메서드 ==> 원하는 항목만 수정
	private void updateMember2() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String key = "id15656klk456asd";
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("회원ID >> ");
		String memId = scan.next();
		
		int count = memService.getMemberCount(CryptoUtil.encryptAES256(memId, key));
		
		if(count==0) { // 해당 회원이 없으면...
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			System.out.println("수정작업을 종료합니다.");
			return;
		}
		
		String updateField = null;  // 수정할 항목명(컬럼명)이 저장될 변수
		String updateData = null;	// 수정할 항목의 변경될 값이 저장될 변수
		String updateTitle = null;  // 수정할 항목의 제목이 저장될 변수
		
		int num; 	// 수정할 항목의 선택 번호가 저장될 변수
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요.");
			System.out.println(" 1.비밀번호     2.회원이름    3.전화번호    4.회원주소");
			System.out.println("----------------------------------------");
			System.out.print("수정할 항목 선택 >> ");
			num = scan.nextInt();
			
			switch(num) {
				case 1 : updateField = "mem_pass"; updateTitle="비밀번호"; break;
				case 2 : updateField = "mem_name"; updateTitle="회원이름"; break;
				case 3 : updateField = "mem_tel"; updateTitle="전화번호"; break;
				case 4 : updateField = "mem_addr"; updateTitle="회원주소"; break;
				default : 
					System.out.println("수정할 항목을 잘못 선택했습니다. 다시 선택하세요.");
			}
			
		}while(num<1 || num>4);
		
		System.out.println();
		scan.nextLine();	// 버퍼 비우기
		System.out.print("새로운 " + updateTitle + " >> ");
		updateData = scan.nextLine();
		if(num == 1) {
			updateData = CryptoUtil.sha512(updateData);
		}
		
		// 수정할 정보를 Map객체에 추가한다.
		
		// key값 정보 ==> 회원ID(memId), 수정할 컬럼(field), 수정할데이터(data)
		Map<String, String>	updateMap = new HashMap<>();
		
		updateMap.put("memId", CryptoUtil.encryptAES256(memId, key));
		updateMap.put("field", updateField);
		updateMap.put("data", updateData);
		
		int cnt = memService.updateMember2(updateMap);
		
		
		if(cnt>0) {
			System.out.println("수정 작업 성공!!!");
		}else {
			System.out.println("수정 작업 실패~~~");
		}
			
		
	}	
		
	
	
	
	// 회원 정보를 수정하는 메서드 ==> 전체 항목 수정
	private void updateMember() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String key = "id15656klk456asd";
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("회원ID >> ");
		String memId = scan.next();
		
		int count = memService.getMemberCount(CryptoUtil.encryptAES256(memId, key));
		if(count==0) { // 해당 회원이 없으면...
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			System.out.println("수정작업을 종료합니다.");
			return;
		}
		
		System.out.println();
		System.out.print("새로운 비밀번호 >> ");
		String newMemPass = scan.next();
		
		System.out.print("새로운 회원이름 >> ");
		String newMemName = scan.next();
		
		System.out.print("새로운 전화번호 >> ");
		String newMemTel = scan.next();
		
		scan.nextLine();
		System.out.print("새로운 회원주소 >> ");
		String newMemAddr = scan.nextLine();
		
		// 수정작업을 위해 입력한 정보를 MemberVO객체에 setting한다.
		MemberVO memvo = new MemberVO();
		memvo.setMem_id(CryptoUtil.encryptAES256(memId, key));
		memvo.setMem_pass(CryptoUtil.sha512(newMemPass));
		memvo.setMem_name(newMemName);
		memvo.setMem_tel(newMemTel);
		memvo.setMem_addr(newMemAddr);
		
		int cnt = memService.updateMember(memvo);
			
		if(cnt>0) {
			System.out.println(memId + "회원 정보 수정 완료!!!");
		}else {
			System.out.println(memId + "회원 정보 수정 실패~~~");
		}
		
	}
	
	
	
	// 회원 정보를 삭제하는 메서드
	private void deleteMember() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String key = "id15656klk456asd";
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("회원ID >> ");
		String memId = scan.next();
		
		int cnt = memService.deleteMember(CryptoUtil.encryptAES256(memId, key));
			
		if(cnt>0) {
			System.out.println("회원ID가 " + memId + "인 회원 삭제 성공!!!");
		}else {
			System.out.println(memId + "회원은 없는 회원이거나 삭제에 실패했습니다.");
		}
		
	}
	
	
	// 회원 정보를 추가하는 메서드
	private void insertMember() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		int count = 0;
		String memId = null;  // 회원ID가 저장될 변수 선언
		String key = "id15656klk456asd";

		String enStr = null;
		do {
			System.out.print("회원ID >> ");
			memId = scan.next();
			
			
			//회원아이디 받음
			
			
			
			count = memService.getMemberCount(CryptoUtil.encryptAES256(memId, key));
			if(count>0) {
				System.out.println(memId + "은(는) 이미 등록된 회원ID입니다.");
				System.out.println("다른 회원ID를 입력하세요...");
			}
			
		}while(count>0);
		
		System.out.print("비밀번호 >> ");
		String memPass = scan.next();
		
		//비밀번호받음
		String enPass = CryptoUtil.sha512(memPass);
		
		System.out.print("회원이름 >> ");
		String memName = scan.next();
		
		System.out.print("전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine();   // 버퍼 비우기
		System.out.print("회원주소 >> ");
		String memAddr = scan.nextLine();
		
		enStr = CryptoUtil.encryptAES256(memId, key);
		
		// 입력한 자료를 MemberVO객체에 셋팅한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(enStr);
		memVo.setMem_pass(enPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		int cnt = memService.insertMember(memVo);
			
		if(cnt>0) {
			System.out.println("새로운 회원 등록 완료!!!");
		}else {
			System.out.println("회원 등록 실패~~~");
		}
		
	}
	
	// 전체 회원 정보를 출력하는 메서드
	private void displayMember() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String key = "id15656klk456asd";
		List<MemberVO> memList = memService.getAllMember();
		
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println(" ID    비밀번호      이 름       전화번호       주 소");
		System.out.println("-------------------------------------------");

		if(memList==null || memList.size()==0) {
			System.out.println(" 등록한 회원 목록이 없습니다.");
		}else {
			for(MemberVO memvo : memList) {
				System.out.println(CryptoUtil.decryptAES256(memvo.getMem_id(), key) + "    " 
							+ memvo.getMem_pass() + "    "
							+ memvo.getMem_name() + "    "
							+ memvo.getMem_tel() + "    "
							+ memvo.getMem_addr());
			}
		}
		System.out.println("-------------------------------------------");
			
		
	}
	
	// 메뉴을 출력하고 선택한 작업번호를 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("=== 작업 선택 ===");
	    System.out.println("   1. 자료 추가 ");
	    System.out.println("   2. 자료 삭제");
	    System.out.println("   3. 자료 수정");
	    System.out.println("   4. 전체 자료 출력");
	    System.out.println("   5. 자료 수정2");
	    System.out.println("   0. 작업 끝.");
	    System.out.println("-------------------");
	    System.out.print("작업 번호 >> ");
	    int num = scan.nextInt();
	    
	    return num;
	}
	

}
