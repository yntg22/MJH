package j_collection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import e_oop.ScanUtil;
public class Board {

	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 컬럼 : 번호, 제목, 내용, 작성자, 작성일
		 * 
		 * 첫화면 : 목록
		 * 목록 : 조회, 등록, 종료
		 * 조회 : 수정, 삭제, 목록 //조회를 했을떄 가능하게
		 * 
		 * ==================================
		 * 번호    제목          작성자          작성일
		 * 3	안녕		홍길동	11/26
		 * 2	안녕		홍길동	11/26
		 * 1	안녕		홍길동	11/26
		 * =================================
		 * 1.조회2.등록0.종료>
		 * 
		*/
		//리스트 안에 들어갈 키 값 = number,1 title,"안녕" name,"홍길동" date"11/26"
		//등록부터 해야겠지

		ArrayList<HashMap<String,Object>> main = new ArrayList(); //리스트를 만들고
		HashMap<String,Object> save = new HashMap(); //해쉬맵만들고
		BoardSave boardsave = new BoardSave();
		while(true) {
		//메인화면
		System.out.println("===============================================");
		System.out.println("번호\t제목\t작성자\t작성일");
		for(int i = 0; i < main.size(); i++) {
			System.out.print(main.get(i).get("number") + "\t");
			System.out.print(main.get(i).get("title") + "\t");
			System.out.print(main.get(i).get("name") + "\t");
			System.out.println(main.get(i).get("date"));
		}
		
		System.out.println("===============================================");
		System.out.println("1.조회 2.등록 0.종료");
		
		int input = ScanUtil.nextInt();
		
		switch(input){
		case 1:
			System.out.println("조회할 게시글 번호  : ");
			input = ScanUtil.nextInt();
			//입력받고 
			for(int i = 0; i < main.size(); i++) {
			if((int)main.get(i).get("number") == input) { //비교해서 같으면 출력
				System.out.print("번호 : "+main.get(i).get("number") + "\t");
				System.out.print("제목 : "+main.get(i).get("title") + "\t");
				System.out.print("작성자 : "+main.get(i).get("name") + "\t");
				System.out.print("작성일 : "+main.get(i).get("date") + "\n");
				System.out.println("내용 : "+main.get(i).get("contents"));
				//수정 삭제 목록
				System.out.println("1.수정 2.삭제 3.목록");
				int input1 = ScanUtil.nextInt();
				switch(input1) {
				case 1 : //수정 
					for(int j = 0; j < main.size();j++) {
						if((int)main.get(j).get("number") == input) {
						main.set(j,boardsave.save(input));
						}
					}
					break;
				case 2 : //삭제  //삭제를하면 번호가 앞당겨 와야하는데 ? 그러면 애초에 번호를 저장할떄? main ArrayList의 인덱스 +1번으로 지정한다?
					for(int j = 0; j < main.size();j++) {
						if((int)main.get(j).get("number") == input) {
						main.remove(j);
						}
					}
					for(int k = 0; i < main.size();i++) {
					main.set(k,boardsave.remove(i));
					}
					break;
				case 3 : //목록
					break;
				}
				break;
			}
			}
			break;
		case 2:
			main.add(boardsave.save());
			break;
		}
	
	
		}
	
	
	
	
	}
}
