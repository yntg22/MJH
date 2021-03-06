package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	private IBoardDao boardDao;
	private static BoardServiceImpl service;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service == null) service = new BoardServiceImpl();
		
		return service;
	}

	@Override
	public int insertBoard(BoardVO boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	@Override
	public int deleteBoard(int boardNum) {
		return boardDao.deleteBoard(boardNum);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		return boardDao.updateBoard(boardVo);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return boardDao.getAllBoard();
	}

	@Override
	public List<BoardVO> searchBoard(String boardTitle) {
		return boardDao.searchBoard(boardTitle);
	}

	@Override
	public BoardVO selectBoard(int boardNo) {
		return boardDao.selectBoard(boardNo);
	}
	
	

}
