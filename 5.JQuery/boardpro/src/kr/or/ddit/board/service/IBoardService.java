package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
	//전체 리스트 가져오기
		public List<BoardVO> selectBoard();

		//페이지별 리스트 가져오기 - 검색 포함 안됨
		public List<BoardVO> selectByPage(Map<String, Object> map);
		
		
		// 페이지별 리스트 가져오기 - 검색포함 - boardsearch - boardpage.jsp
		public List<BoardVO> selectByPS(Map<String, Object> map);
		
		// 전체 글개수 가져오기 - 검색포함
		public int searchCount(Map<String,Object> map);
		
		//글저장하기
		public int insertBoard(BoardVO boardVO);
		
		//글삭제하기
		public int deleteBoard(int num);	
		
		//글수정하기
		public int updateBoard(BoardVO boardVO);
		
		//댓글 등록
		public int insertReply(ReplyVO rep);
		
		//댓글 수정
		public int updateReply(ReplyVO replyVO);
		
		//댓글 삭제
		public int deleteReply(int renum);
		
		//댓글 리스트
		public List<ReplyVO> selectReply(); 
		
		//조회수 증가
		public int updateHit (int num);
		
		//전체 글갯수 가져오기(수)
//		public int selectBoardCount();
		public int getTotalCount();

		//페이지정보 얻기 - start, end, startpage, endpage, totalpage
		public Map<String, Object> pageInfo(int page);
}
