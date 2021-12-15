package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.ReBoardDao;
import util.ScanUtil;
import util.View;

public class ReBoardService {

	// 싱글톤 패턴
	private ReBoardService() {}
	private static ReBoardService instance;
	public static ReBoardService getInstance() {
		if (instance == null) {
			instance = new ReBoardService();
		}
		return instance;
	}

	private ReBoardDao boardDao = ReBoardDao.getInstance();

	//문의게시판 출력
		public int boardList() {
			List<Map<String, Object>> boardList = boardDao.boardList();
			System.out.println("──────────────────────── Q & A ────────────────────────");
			System.out.println("번호\t제목\t\t\t작성자\t작성일자\t답변등록상태");
			System.out.println("───────────────────────────────────────────────────────");

			for (int i = 0; i < boardList.size(); i++) {
				Map<String, Object> board = boardList.get(i);
				System.out.print(board.get("BOARD_NO") + "\t");
				System.out.print(board.get("BOARD_TITLE") + "\t\t");
				System.out.print(board.get("M_NAME") + "\t");
				System.out.print(board.get("BOARD_DATE") + "\t");
				System.out.println(board.get("BOARD_RE"));

			}
			System.out.println("───────────────────────────────────────────────────────");

			System.out.println("< 1.조회 2.등록 9.로그아웃 0.목록 >");
			int search = ScanUtil.nextInt();

			switch (search) {
			case 1 :
				return View.BOARD_VIEW;
			case 2 :
				return View.BOARD_INSERT;
			case 9 :
				Controller.loginMember = null;
				return View.HOME;	
			case 0 :
				return View.WINDOW;
			}
			
			return View.WINDOW;
			
		}
		
		public static int boardNo;
		
		
		//문의게시판 조회 
		public int boardView() {
			System.out.println("조회하실 문의사항 번호를 입력해주세요 > ");
			boardNo = ScanUtil.nextInt();
			
			Map<String, Object> view = boardDao.boardView(boardNo);
			System.out.println("─────────────────────────────────────");
			System.out.println("제목  : " + view.get("BOARD_TITLE"));
			System.out.println("내용  : " + view.get("BOARD_CONTENT"));
			System.out.print("작성자  : " + view.get("M_NAME") + "\t");
			System.out.println("\t작성일 : " + view.get("BOARD_DATE"));
			System.out.println("─────────────────────────────────────");

			System.out.print("< 1.수정  2.삭제  9.로그아웃 0.목록 >");
			int update = ScanUtil.nextInt();

			switch (update) {
			case 1:
				return View.BOARD_AMEND;
			case 2:
				return View.BOARD_DELETE;
			case 9: //로그아웃
				Controller.loginMember = null;
				return View.HOME;
			case 0:
				return View.BOARD_LIST;
				}
			return View.BOARD_LIST;
		}
		
		
				
		//문의게시판 등록
		public int boardUpload() {
			System.out.println("────────────── [ 새로운 글 등록하기 ] ──────────────");
			System.out.print("제목 >> ");
			String title = ScanUtil.nextLine();
			System.out.println("내용 >> ");
			String content = ScanUtil.nextLine();
//			System.out.println("작성자 >> ");
			Object user = Controller.loginMember.get("M_NAME");
//			String user = ScanUtil.nextLine();
//			System.out.println("사용자번호 >> ");
//			int mNo = ScanUtil.nextInt();
			
			Map<String, Object> param = new HashMap<>();
			param.put("BOARD_TITLE", title);
			
			param.put("BOARD_CONTENT", content);
			param.put("M_NAME", user);
			
			
			int result = boardDao.update(param);
			
			if (0 < result) {
				System.out.println("게시물 등록 완료");
			} else {
				System.out.println("게시물 등록 실패");
			}
			return View.BOARD_LIST;
		}
		
		
		//문의게시판 수정 > 수정은 아이디 이름과 작성자 이름이 동일할때 가능
		
	
		public int boardInsert() {
			
			Object name = Controller.loginMember.get("M_NAME");
			
			Map<String, Object> view = boardDao.boardView(boardNo);
			Object boardName = view.get("M_NAME");
			
			
//			System.out.println("사용자 이름입력 > ");
//			String userName = ScanUtil.nextLine();
//			Map<String, Object> checking = boardDao.user(boardNo,userName);
			
			if(boardName.equals(name)) {
			System.out.println("수정할 항목을 입력해주세요.");
			System.out.println("1.제목\t2.내용\t3.제목과 내용");
			int insert = ScanUtil.nextInt();
			if (insert == 1) {
				System.out.println("────────────── [ 수정 해주세요 ] ──────────────");
				System.out.print("제목>");
				String title = ScanUtil.nextLine();

				int change = boardDao.insert(boardNo, title);
				
				if(0 < change) {
					System.out.println("수정완료");
				}else {
					System.out.println("수정실패ㅠㅠ");
					
				}
				
		
			} else if (insert == 2) {
				System.out.println("────────────── [ 수정 해주세요] ──────────────");
				System.out.print("내용>");
				String content = ScanUtil.nextLine();

				int change = boardDao.insert2(boardNo, content);
				
				if(0 < change) {
					System.out.println("수정완료");
				}else {
					System.out.println("수정실패ㅠㅠ");
					
				}

			} else if (insert == 3) {
				System.out.println("────────────── [ 수정 해주세요] ──────────────");
				System.out.print("제목>");
				String title = ScanUtil.nextLine();
				System.out.print("내용>");
				String content = ScanUtil.nextLine();

				int change = boardDao.insert3(boardNo, title, content);
				
				if(0 < change) {
					System.out.println("수정완료");
				}else {
					System.out.println("수정실패ㅠㅠ");
					
				}
			}
			
			}else {
				System.out.println("사용자와 동일인이 아닙니다. 수정하실 수 업습니다.");
			}
			return View.BOARD_LOOK;
		}
		
		
		
		// 수정 후 공지사항 확인
			public int boardLook() {
				
				Map<String, Object> board = boardDao.read(boardNo);
				System.out.println("─────────────────────────────────────");
				System.out.println("제목  : " + board.get("BOARD_TITLE"));
				System.out.println("내용  : " + board.get("BOARD_CONTENT"));
				System.out.print("작성자  : " + board.get("M_NAME") + "\t");
				System.out.println("\t작성일 : " + board.get("BOARD_DATE"));
				System.out.println("─────────────────────────────────────");
				
				return View.BOARD_LIST;
			}
		
	//문의게시판 삭제 > 삭제는 아이디 이름과 작성자 이름이 동일할때 가능
		public int boardDelete() {	

			Object name = Controller.loginMember.get("M_NAME");
			
			Map<String, Object> view = boardDao.boardView(boardNo);
			Object boardName = view.get("M_NAME");
			if(boardName.equals(name)) {
			System.out.println("────────────── [ 삭제 ] ──────────────");
			System.out.print("정말 삭제하시겠습니까?(Y/N)>");
			String delete = ScanUtil.nextLine();
				
			if(delete.equals("Y")||delete.equals("y")) {
			int delete2 = boardDao.delete(boardNo);
								
			if(0 < delete2 ) {
					System.out.println("삭제되었습니다.");
			}else {
				System.out.println("삭제에 실패하였습니다.");
				}			
			}
			}else {
				System.out.println("사용자와 동일인이 아닙니다. 삭제하실 수 업습니다.");
			}
			
			return View.BOARD_LIST;
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//	public int reboardList() {
//		List<Map<String,Object>> boardList = boardDao.selectBoardList();
//		
//		System.out.println("====================================");
//		System.out.println("번호\t제목\t작성자\t작성일");
//		System.out.println("------------------------------------");
//		for (int i = 0; i < boardList.size(); i++) {
//			Map<String, Object> board = boardList.get(i);
//			System.out.print(board.get("BOARD_NO") + "\t");
//			System.out.print(board.get("BOARD_TITLE") + "\t");
//			System.out.print(board.get("M_NAME") + "\t");
//			System.out.print(board.get("BOARD_DATE") + "\n");
//		}
//		System.out.println("=====================================");
//		
//		System.out.print("1.조회	2.등록  0.로그아웃>");
//		int input = ScanUtil.nextInt();
//		
//		switch(input) {
//		case 1: //조회 조회할수있게 리턴해주고 controller에서 case 추가후 
//			return View.BOARD_VIEW;
//		case 2: //등록
//			return View.BOARD_INSERT;
//		case 0: //로그아웃
//			Controller.loginMember = null;
//			return View.HOME;
//		}
//		
//		return View.BOARD_LIST;
//	}
//
//	public int reboardView() {
//		System.out.println("조회할 게시글 번호>");
//		int num = ScanUtil.nextInt();
//		Map<String, Object> selectBoardget = boardDao.selectBoardget(num);
//		
//		System.out.print("번호 : " + selectBoardget.get("BOARD_NO")+ "\t");
//		System.out.print("제목 : " + selectBoardget.get("BOARD_TITLE")+ "\t");
//		System.out.print("날짜 : " + selectBoardget.get("BOARD_DATE")+ "\t");
//		System.out.println("작성자 : " + selectBoardget.get("MEM_ID"));
//		System.out.println("----------------------------------------------");
//		System.out.print("내용 : " + selectBoardget.get("CONTENT") + "\n");
//		
//		System.out.println("-----------------------------------");
//		System.out.println("1.무비서비스 2.삭제 3.목록");
//		int input = ScanUtil.nextInt();
//		
//		switch(input) {
//		case 1: //수정
//			return View.R_TIME;
//		case 2: //삭제
//			return View.BOARD_DELETE;
//		case 0: //목록
//			return View.BOARD_LIST;
//		}
//		
//		return View.BOARD_LIST;
//	}
//
//	public int reboardInsert() { //등록
//		System.out.println("제목 : ");
//		String title = ScanUtil.nextLine();
//		System.out.println("내용 : ");
//		String content = ScanUtil.nextLine();
//		
//		
//		int result = boardDao.boardinsert(title,content);
//		if(result > 0) {
//			System.out.println(result +"개의 게시글이 등록되었습니다");
//		}else {
//			System.out.println("등록 실패");
//			return View.BOARD_INSERT; //실패하면 다시등록
//		}
//		return View.BOARD_LIST; //성공하면 게시글 리스트로
//	}
//	
//	public int reboardAmend() {
//		return View.BOARD_LIST;
//	}
//	
//	public int reboardDelete() {
//		return View.BOARD_DELETE;
//	}
//	
	
}
