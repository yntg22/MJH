package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

/**
 * Service객체는 DAO에 만들어진 메서드를 원하는 작업에 맞게 호출하여 실행하고
 * 실행된 결과를 받아와서 받아온 결과를 Controller에게 보내주는 역할을 수행한다.
 * 
 * @author PC-17
 *
 */

public interface IBoardService {
	/**
	 *  BoardVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * @param boardVo DB에 insert할 자료가 저장된 BoardVO객체
	 * @return 작업 성공 : 1이상의 정수, 작업실패 : 0
	 */
	public int insertBoard(BoardVO boardVo);
	
	/**
	 * 게시물번호를 매개변수로 받아서 해당 게시물을 삭제하는 메서드
	 * @param boardNum 삭제할 게시물번호(int)
	 * @return 작업 성공 : 1, 작업실패 : 0
	 */
	public int deleteBoard(int boardNum);
	
	/**
	 * BoardVO자료를 이용하여 게시물 내용을 수정하는 메서드
	 * @param boardVo 수정할 게시물 정보가 저장된 BoardVO객체
	 * @return 수정 성공 : 1, 수정 실패 : 0
	 */
	public int updateBoard(BoardVO boardVo);
	
	/**
	 * 게시물 전체 정보를 가져와서 List에 담아서 반환하는 메서드
	 * @return BoardVO를 담고있는 List객체
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 검색할 게시물 제목을 매개변수로 받고, 받은 제목이 들어가는 모든 게시물을
	 * 검색하여 반환하는 메서드
	 * @param boardTitle 검색할 게시물 제목
	 * @return 검색된 모든 BoardVO를 담고있는 List객체
	 */
	public List<BoardVO> searchBoard(String boardTitle);
	
	/**
	 * 보고싶은 게시물 번호를 매개변수로 받고, 게시물번호에 맞는 게시물
	 * 내용을 조회하는 메서드
	 * @param boardNo 보고싶은 게시물 번호
	 * @return 조회할 게시물의 BoardVO객체
	 */
	public BoardVO selectBoard(int boardNo);
}
