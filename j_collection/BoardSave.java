package j_collection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import e_oop.ScanUtil;

public class BoardSave {
	int number = 1;
	HashMap<String,Object> save = new HashMap();
	BoardSave(){
	}
	
	HashMap save(){
			// 현재 날짜 구하기
			LocalDate now = LocalDate.now();
			// 포맷 정의
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd");
			// 포맷 적용
			String formatedNow = now.format(formatter);
	
		 //해쉬맵만들고
			
			save = new HashMap();
			System.out.print("제목 입력 : ");
			String input = ScanUtil.nextLine();
			
			save.put("number", number); //for문으로 돌리면 1은 i로 만들어서 증가한다?
			save.put("date", formatedNow);
			save.put("title", input); //제목
			
			System.out.print("이름 입력 : ");
			input = ScanUtil.nextLine();
			save.put("name", input); //이름
			
			System.out.print("내용 입력 : ");
			input = ScanUtil.nextLine();
			save.put("contents", input); //내용
			number++;
			//이렇게 입력받은걸.. 리스트에 저장
			return save;
	}
	//수정과 삭제를 하려면
	//ArrayList에 있는 1번을 삭제한다고 하면 ?
	//해쉬맵 수정은 똑같은 키에 다른값을 넣어주면 된다고 했따.
	//
	HashMap save(int m){
		// 현재 날짜 구하기
		LocalDate now = LocalDate.now();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd");
		// 포맷 적용
		String formatedNow = now.format(formatter);

		 //해쉬맵만들고
		
		save = new HashMap();
		System.out.print("제목 입력 : ");
		String input = ScanUtil.nextLine();
		
		save.put("number", m); //for문으로 돌리면 1은 i로 만들어서 증가한다?
		save.put("date", formatedNow);
		save.put("title", input); //제목
		
		System.out.print("이름 입력 : ");
		input = ScanUtil.nextLine();
		save.put("name", input); //이름
		
		System.out.print("내용 입력 : ");
		input = ScanUtil.nextLine();
		save.put("contents", input); //내용
		//이렇게 입력받은걸.. 리스트에 저장
		return save;
	}
	
}
