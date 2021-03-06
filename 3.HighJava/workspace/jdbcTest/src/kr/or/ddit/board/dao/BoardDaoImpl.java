package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.DBUtil3;

public class BoardDaoImpl implements IBoardDao {
	
	//1
	private static BoardDaoImpl dao;
	
	//2
	private BoardDaoImpl() {}
	
	//3
	public static BoardDaoImpl getInstance() {
		if(dao==null) dao = new BoardDaoImpl();
		
		return dao;
	}

	@Override
	public int insertBoard(BoardVO boardVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "insert into jdbc_board "
					+ "	values(board_seq.nextVal,?,?,sysdate,0,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_writer());
			pstmt.setString(3, boardVo.getBoard_content());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board set board_title=?, board_content=?"
					+ " where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_content());
			pstmt.setInt(3, boardVo.getBoard_no());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e) {}
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_content(rs.getString("board_content"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				
				boardList.add(boardVo);
			}
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		} finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(stmt!=null)try {stmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return boardList;
	}

	@Override
	public List<BoardVO> searchBoard(String boardTitle) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where board_title like ?";
			String boardTitle2 = "%"+boardTitle+"%";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardTitle);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_content(rs.getString("board_content"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				
				boardList.add(boardVo);
			}
			
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		} finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e) {}
		}
		return boardList;
	}

	@Override
	public BoardVO selectBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVO boardVo = new BoardVO();
	try {
		String sql = "select * from jdbc_board where board_no = ?";
		conn = DBUtil3.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, boardNo);
		
		rs = pstmt.executeQuery();
			rs.next();
			boardVo.setBoard_no(rs.getInt("board_no"));
			boardVo.setBoard_title(rs.getString("board_title"));
			boardVo.setBoard_writer(rs.getString("board_writer"));
			boardVo.setBoard_content(rs.getString("board_content"));
			boardVo.setBoard_date(rs.getString("board_date"));
			boardVo.setBoard_cnt(rs.getInt("board_cnt"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e) {}
		}	
		try {
			
			String sql = "update jdbc_board set board_cnt=board_cnt+1 where board_no = ?";
			conn = DBUtil3.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if(pstmt!=null) try { pstmt.close(); } catch (SQLException e) {}
			if(conn!=null) try { conn.close(); } catch (SQLException e) {}
		}
	
	
	
		
		return boardVo;
	}

	

}
