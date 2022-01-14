package service;

import java.util.List;
import java.util.Map;

import dao.LostBoardDao;
import util.View;

public class LostBoardService {

	private LostBoardService () {}
	private static LostBoardService  instance;
	public static LostBoardService  getInstance() {
		if (instance == null) {
			instance = new LostBoardService ();
		}
		return instance;
	}
	
	private LostBoardDao boardDao = LostBoardDao.getInstance();
	
	public int boardList() {
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		System.out.println("────────────────────────────────── 유실물 게시판 ──────────────────────────────────");
		System.out.println("번호\t제목\t\t특징\t\t\t작성일자\t수령여부");
		System.out.println("──────────────────────────────────────────────────────────────────────────────");

		for (int i = 0; i < boardList.size(); i++) {
			Map<String, Object> board = boardList.get(i);
			System.out.print(board.get("MI_NO") + "\t");
			System.out.print(board.get("MI_TITLE") + "\t\t");
			System.out.print(board.get("MI_CONTENT") + "\t\t");
			System.out.print(board.get("MI_START") + "\t");
			System.out.println(board.get("MI_BIGO") + "\t");

		}
		System.out.println("──────────────────────────────────────────────────────────────────────────────");
		System.out.println("                              \t유실물 보관 및 수령 안내                                                              ");
		System.out.println("	\t 1. 유실물 보관은 \"5\"개월간 가능합니다.					");
		System.out.println("    \t\t 2. 유실물은 방문하셔서 수령 가능합니다.(신분증지참)				 ");
		System.out.println("	\t 3. 방문하시기 전에 전화 한번 주시고 방문해주시면 편리합니다.				");
		System.out.println("─────────────── ※ 전화문의 >> 042-532-3576 ─────────────────────────── ");
		System.out.println("──────────────────────────────────────────────────────────────────────────────");
		return View.WINDOW;

	
	}
	
	
	
}
