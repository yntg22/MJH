package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao {
	private SqlMapClient smc;
	
	//1
	private static BoardDaoImpl dao;
	
	//2
	private BoardDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
		
	//3
	public static BoardDaoImpl getInstance() {
		if(dao==null) dao = new BoardDaoImpl();
		
		return dao;
	}

	@Override
	public int insertBoard(BoardVO boardVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("board.insertBoard",boardVo);
			if(obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNum) {
		int cnt = 0;
		try {
			cnt = smc.delete("board.deleteBoard",boardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		int cnt = 0;
		try {
			cnt = smc.update("board.updateBoard",boardVo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
				boardList = smc.queryForList("board.getAllBoard");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return boardList;
	}

	@Override
	public List<BoardVO> searchBoard(String boardTitle) {
		List<BoardVO> boardList = new ArrayList<>();	
		try {
			
			boardList = smc.queryForList("board.searchBoard",boardTitle);
			
		} catch (SQLException e) {

			e.printStackTrace();
		} 
		return boardList;
	}

	@Override
	public BoardVO selectBoard(int boardNo) {
		
		BoardVO boardVo = new BoardVO();
	try {
		boardVo = (BoardVO) smc.queryForObject("board.selectBoard",boardNo);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	
		try {
			smc.update("board.selectBoard2");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 

		return boardVo;
	}

	

}
