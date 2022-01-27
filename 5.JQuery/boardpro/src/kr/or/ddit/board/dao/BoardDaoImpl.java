package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.config.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao {
	private SqlMapClient client;
	private static BoardDaoImpl dao;
	private BoardDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static BoardDaoImpl getInstance() {
		if(dao==null)dao = new BoardDaoImpl();
		
		return dao;
	}
	
	
	
	@Override
	public List<BoardVO> selectBoard() {
		List<BoardVO> list=null;
		
		try {
			list = client.queryForList("board.selectBoard");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		int num = 0;
		try {
			num = (int) client.insert("board.insertBoard",boardVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int deleteBoard(int n) {
		int num=0;
		try {
			num = (int)client.delete("board.deleteBoard",n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		int num=0;
		
		try {
			num=client.update("board.updateBoard", boardVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}

	@Override
	public int insertReply(ReplyVO replyVO) {
		int num=0;
		try {
			num= (int) client.insert("board.insertReply", replyVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int updateReply(ReplyVO replyVO) {
		int num =0;
		try {
			num=client.update("board.updateReply", replyVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	@Override
	public int deleteReply(int renum) {
		int num=0;
		try {
			num=client.delete("board.deleteReply", renum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	@Override
	public List<ReplyVO> selectReply() {
		List<ReplyVO> list =null;
		try {
			list = client.queryForList("board.selectReply");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int updateHit(int n) {
		int num=0;
		try {
			num = client.update("board.updateHit", n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
//	@Override
//	public int selectBoardCount() {
//		int num=0;		
//		try {
//			num = (int) client.queryForObject("board.selectBoardCount");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return num;
//	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		List<BoardVO> list = null;
		
		try {
			list = client.queryForList("board.selectByPage",map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

@Override
public int getTotalCount() {
	int cnt = 0;
	
	try {
		cnt = (int)client.queryForObject("board.getTotalCount");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return cnt;
}

@Override
public List<BoardVO> selectByPS(Map<String, Object> map) {
	List<BoardVO> list = null;
	
	try {
		list = client.queryForList("board.selectByPS", map);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}

@Override
public int searchCount(Map<String, Object> map) {
	int count = 0;
	
	try {
		count = (int)client.queryForObject("board.searchCount", map);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return count;
}

}
