package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;


public class BoardServiceImpl implements IBoardService {

	private IBoardDao dao;
	
	private static BoardServiceImpl service;
	
	private BoardServiceImpl()	{
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service == null)service = new BoardServiceImpl();
		return service;
	}

	
	@Override
	public List<BoardVO> selectBoard() {
		
		return dao.selectBoard();
	}
	@Override
	public int insertBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return dao.insertBoard(boardVO);
	}
	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(num);
	}
	@Override
	public int updateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return dao.updateBoard(boardVO);
	}
	@Override
	public int insertReply(ReplyVO rep) {
		// TODO Auto-generated method stub
		return dao.insertReply(rep);
	}
	@Override
	public int updateReply(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return dao.updateReply(replyVO);
	}
	@Override
	public int deleteReply(int renum) {
		// TODO Auto-generated method stub
		return dao.deleteReply(renum);
	}
	@Override
	public List<ReplyVO> selectReply() {
		// TODO Auto-generated method stub
		return dao.selectReply();
	}
	@Override
	public int updateHit(int num) {
		// TODO Auto-generated method stub
		return dao.updateHit(num);
	}
//	@Override
//	public int selectBoardCount() {
//		// TODO Auto-generated method stub
//		return dao.selectBoardCount();
//	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		
		return dao.selectByPage(map);
	}

	@Override
	public Map<String, Object> pageInfo(int page) {
		// 전체글 개수 가져오기 - 20개
		int count = this.getTotalCount();
		
		//한페이지당 출력할 글 개수 = 3
		int perList = 3;
		
		//한화면에 출력할 페이지 개수
		int perPage = 2;
		
		//전체페이지
		int totalPage = (int)Math.ceil((double)count / perList);
		
		//보여줄 rownum 번호 - 게시판 글 리스트
		//page가 1일때 start=1 end=3
		//page가 2일떄 start=4 end=6
		//page가 3일떄 start=7 end=9
		int start = (page-1) * perList + 1;
		int end = start + perList - 1;
		
		if(end > count) end = count;
		
		//보여줄 페이지번호
		//page가 1일때 startPage=1 endPage=2
		//page가 2일떄 startPage=1 endPage=2
		//page가 3일떄 startPage=3 endPage=4
		//page가 4일떄 startPage=3 endPage=4
		//page가 5,6일떄 startPage=5 endPage=6
		int startPage = ((page-1) / perPage * perPage)+1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("start", start);
		map.put("end", end);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		
		return map;
	}

	@Override
	public int getTotalCount() {
		
		return dao.getTotalCount();
	}

	@Override
	public List<BoardVO> selectByPS(Map<String, Object> map) {
		
		return dao.selectByPS(map);
	}

	@Override
	public int searchCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.searchCount(map);
	}


}
