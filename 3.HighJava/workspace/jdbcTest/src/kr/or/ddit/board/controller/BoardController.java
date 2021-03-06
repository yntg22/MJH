package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardController {
	private IBoardService boardService;
	private Scanner scan = new Scanner(System.in);
	
	//생성자
	public BoardController() {
		boardService = BoardServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new BoardController().boardStart();
		
	}

	private void boardStart() {
		
		while(true) {
		List<BoardVO> boardList = boardService.getAllBoard();
	
		System.out.println();
		System.out.println("====================================");
		System.out.println("No          제목            작성자          조회수 ");
		System.out.println("====================================");
		if(boardList == null || boardList.size()==0) {
			System.out.println("아직 등록된 게시물이 없습니다");
		}else {
			for(BoardVO boardvo : boardList) {
				System.out.println(boardvo.getBoard_no()+"                       "+ 
								   boardvo.getBoard_title()+"             "+
								   boardvo.getBoard_writer()+"                \t"+
								   boardvo.getBoard_cnt());
			}
		}
		System.out.println("===================================");
		System.out.println("1.새글작성 2.게시물보기 3.검색 0.작업끝");
			int choice = displayMenu();
			switch(choice) {
			case 1: 
				insertBoard(); break;
			case 2: 
				selectBoard(); break;
			case 3: 
				searchBoard();break;
			case 0:	
				System.out.println("프로그램을 종료합니다.");
				return;
			default : System.out.println("작업 번호를 잘못 입력했습니다 다시 입력하세요");
			}
		}
	}

	
	private void selectBoard() {
		System.out.println();
		System.out.println("=======================");
		System.out.println("조회할 게시물 번호 : ");
		int boardNo = scan.nextInt();
		BoardVO boardVo = boardService.selectBoard(boardNo);
		System.out.println(boardNo+"번글 내용");
		System.out.println("=======================");
		System.out.println("제 목 : " + boardVo.getBoard_title());
		System.out.println("작 성 자 : " + boardVo.getBoard_writer());
		System.out.println("내 용 : " + boardVo.getBoard_content());
		System.out.println("작 성 일 : " + boardVo.getBoard_date());
		System.out.println("조회수 : " + boardVo.getBoard_cnt());
		System.out.println("-----------------------------------");
		System.out.println("1.수정 2.삭제 3.리스트로가기");
		int choice = scan.nextInt();
		switch(choice) {
		case 1:
			updateBoard(boardVo); break;
		case 2:
			boardService.deleteBoard(boardVo.getBoard_no());
		case 3:break;
		}
	}

	private void updateBoard(BoardVO boardVo) {
		System.out.println("제  목 : ");
		boardVo.setBoard_title(scan.next());
		System.out.println("내  용 : ");
		boardVo.setBoard_content(scan.next());
		int cnt = boardService.updateBoard(boardVo);
		if(cnt>0) {
			System.out.println("글 수정 완료!!!");
		}else {
			System.out.println("글 수정 실패 ㅠㅠ");
		}
		
	}

	private void searchBoard() {
		
		System.out.println();
		System.out.println("================");
		System.out.println("검색할 제목 입력 : ");
		String boardTitle = scan.next();
		List<BoardVO> boardList = boardService.searchBoard(boardTitle);
		System.out.println();
		System.out.println("====================================");
		System.out.println("No          제목            작성자          조회수 ");
		System.out.println("====================================");
		if(boardList == null || boardList.size()==0) {
			System.out.println("아직 등록된 게시물이 없습니다");
		}else {
			for(BoardVO boardvo : boardList) {
				System.out.println(boardvo.getBoard_no()+"                       "+ 
								   boardvo.getBoard_title()+"             "+
								   boardvo.getBoard_writer()+"                \t"+
								   boardvo.getBoard_cnt());
			}
		}
		System.out.println("===================================");
		System.out.println("1.새글작성 2.게시물보기 3.검색 0.작업끝");
		
		
	}

	private void insertBoard() {
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("========================");
		
		System.out.print("-제 목 : ");
		String boardTitle = scan.next();
		
		System.out.print("-작 성 자 : ");
		String boardWriter = scan.next();
		
		System.out.print("-내 용 : ");
		String boardContent = scan.next();
		
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(boardTitle);
		boardVo.setBoard_writer(boardWriter);
		boardVo.setBoard_content(boardContent);
		
		int cnt = boardService.insertBoard(boardVo);
		
		if(cnt>0) {
			System.out.println("새로운 글 등록 완료!!!");
		}else {
			System.out.println("새로운 글 등록 실패 ㅠㅠ");
		}
		
	}

	private int displayMenu() {
	    System.out.print("작업 번호 >> ");
	    int num = scan.nextInt();
	    
	    return num;
	}
	
	
}
