package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.AdminLostBoardDao;
import util.ScanUtil;
import util.View;

public class AdminLostBoardService {

	private AdminLostBoardService() {

	}
	
	private static AdminLostBoardService instance; // 객체를 저장해 놓으 변수

	public static AdminLostBoardService getInstance() {// 다른 클래스가 필요하다고 요청하는 메서드
		if (instance == null) {
			instance = new AdminLostBoardService();
		}
		return instance; // 첫호출때 null인경우에만 객체생성이 되서 리턴을 해줘 / 두번째 호출부터는 리턴값만 돌려줘
	}
	
	private AdminLostBoardDao lostboardDao = AdminLostBoardDao.getInstance();
	
	
	public int lostList() {
		
		List<Map<String, Object>> lostList = lostboardDao.lostBoardList();
		
		System.out.println("==============================유실물 목록=============================================");
		System.out.println("번호\t분실물명\t상세설명\t\t발견일\t\t수령자\t연락처\t\t       비고");
		System.out.println("==================================================================================");
			for ( int i = 0; i < lostList.size(); i++ ) {
				Map<String, Object> lost = lostList.get(i);
				System.out.print(lost.get("MI_NO") + "\t");
				System.out.print(lost.get("MI_TITLE") + "\t");
				System.out.print(lost.get("MI_CONTENT") + "\t");
				System.out.print(lost.get("MI_START") + "\t");
				System.out.print(lost.get("MI_OWNER") + "\t");
				System.out.print(lost.get("MI_HP") + "\t");
				System.out.println("\t" +lost.get("MI_BIGO") + "\t");
			}
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("                              \t유실물 보관 및 수령 안내                                                              ");
			System.out.println("	\t 1. 유실물 보관은 \"5\"개월간 가능합니다.					");
			System.out.println("    \t\t 2. 유실물은 방문하셔서 수령 가능합니다.(신분증지참)				 ");
			System.out.println("	\t 3. 방문하시기 전에 전화 한번 주시고 방문해주시면 편리합니다.				");
			System.out.println(" ------ ----- ---- --- -- - ※ 전화문의 >> 042-532-3576 - -- --- ---- ----- -----");
			System.out.println("------------------------------------------------------------------------------");
		System.out.println("1.등록 2.수정 3.삭제 0.목록");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1:
			return View.BOARD_LOSTUPDATE;
		case 2:
			return View.BOARD_LOSTINSERT;
		case 3:
			return View.BOARD_LOSTDELETE;
		case 0:
			return View.BOARD_ANNOUNCEMENT;
		}
		return View.BOARD_ANNOUNCEMENT;
	}

	
	public static int lostBoardNo;
	
	//유실물 등록
	
	public int lostUpdate() {
		System.out.println("────────── 분실물 등록 ──────────");
		System.out.print("분실물 >> ");
		String title = ScanUtil.nextLine();
		System.out.println("상세설명 >> ");
		String content = ScanUtil.nextLine();
		Object empNo = Controller.loginMember.get("EMP_NO");
//		System.out.println("직원번호 >> ");
//		int empNo = ScanUtil.nextInt();
//		System.out.println("수령인 >> ");
		String owner = " ";  //미수령
//		System.out.println("전화번호 >> ");
		String hp = " "; // 000-0000-0000
		String bigo = "미수령";
		
		Map<String, Object> param = new HashMap<>();
		param.put("MI_TITLE", title);
		param.put("MI_CONTENT", content);
		param.put("EMP_NO", empNo);
		param.put("MI_OWNER", owner);
		param.put("MI_HP", hp);
		param.put("MI_BIGO", bigo);
		
		
		int reasult = lostboardDao.lostupdate(param);
		
		return View.BOARD_LOSTVIEW;
	}
	
	
	//유실물 수정
	public int lostInsert() {
		System.out.println("수정 할 유실물 번호를 입력해주세요");
			lostBoardNo = ScanUtil.nextInt();
		
		System.out.println("수정할 항목을 선택해주세요.");
		System.out.println("1.분실물명\t2.상세설명\t3.분실명과 상세설명\t4.수령인과 연락처");
		int input =ScanUtil.nextInt();
		
		if(input == 1) {
			System.out.println("───────────── [분실물 대장 수정] ─────────────");
			System.out.print("분실물명 >>");
			String title = ScanUtil.nextLine();
			
			int change = lostboardDao.lostInsert(lostBoardNo, title);
			if(0 < change) {
				System.out.println("---- ♥수정완료♥ ----");
			}else {
				System.out.println("수정실패ㅠㅠ");
			}
			
		}else if(input ==2) {
			System.out.println("───────────── [분실물 대장 수정] ─────────────");
			System.out.print("상세설명 >> ");
			String content = ScanUtil.nextLine();
			
			int change = lostboardDao.lostInsert2(lostBoardNo, content);
			if(0 < change) {
				System.out.println("---- ♥수정완료♥ ----");
			}else {
				System.out.println("수정실패ㅠㅠ");
			}
			
		}else if(input == 3){
			System.out.println("───────────── [ 분실물 대장 수정] ─────────────");
			System.out.print("분실물명 >> ");
			String title = ScanUtil.nextLine();
			System.out.print("상세설명 >> ");
			String content = ScanUtil.nextLine();
			
			int change = lostboardDao.lostInsert3(lostBoardNo, title, content);
			if(0 < change) {
				System.out.println("---- ♥수정완료♥ ----");
			}else {
				System.out.println("수정실패ㅠㅠ");
			}
			
		}else if(input == 4) {
			System.out.println("───────────── [ 수령 ] ─────────────");
			System.out.print("수령인 >> ");
			String owner = ScanUtil.nextLine();
			System.out.println("수령인 연락처 >> ");
			String hp = ScanUtil.nextLine();
			System.out.println("수령여부 >> ");
			String bigo = ScanUtil.nextLine();
			
			int change = lostboardDao.lostInsert4(lostBoardNo, owner, hp, bigo);
			if(0 < change) {
				System.out.println("---- ♥수정완료♥ ----");
			}else {
				System.out.println("수정실패ㅠㅠ");
			}
				
			}else {
				return View.BOARD_LOSTVIEW;
			}
		
		return View.BOARD_LOSTVIEW;
	}
	
	//유시물 삭제
	
	public int lostDelete() {
		System.out.println("삭제 할 유실물 번호를 입력해주세요");
		lostBoardNo = ScanUtil.nextInt();
		
		System.out.println("───────────── [ 삭제 ] ─────────────");
		System.out.print("정말 삭제하시겠습니까?(Y/N)>");
		String delete = ScanUtil.nextLine();
		
		if(delete.equals("Y") ||delete.equals("y")) {
		int delete2 = lostboardDao.delete(lostBoardNo);
						
		if(0 < delete2 ) {
			System.out.println("─────────── 삭제되었습니다 ───────────");
		}else {
			System.out.println("삭제에 실패하였습니다.");
			}			
		}
		
		return View.BOARD_LOSTVIEW;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
