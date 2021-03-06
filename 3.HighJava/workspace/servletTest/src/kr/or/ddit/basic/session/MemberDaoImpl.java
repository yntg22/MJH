package kr.or.ddit.basic.session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl {
	// 1번
	private static MemberDaoImpl dao;
	
	// 2번
	private MemberDaoImpl() { }
	
	// 3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	public MemberVO getMember(MemberVO memvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO mVo = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember "
					+ " where mem_id=? and mem_pass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memvo.getMem_id());
			pstmt.setString(2, memvo.getMem_pass());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mVo = new MemberVO();
				
				mVo.setMem_id(rs.getString("mem_id"));
				mVo.setMem_pass(rs.getString("mem_pass"));
				mVo.setMem_name(rs.getString("mem_name"));
				mVo.setMem_tel(rs.getString("mem_tel"));
				mVo.setMem_addr(rs.getString("mem_addr"));

			}
			System.out.println(mVo.getMem_id());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try { rs.close(); }catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(SQLException e) {}
			if(conn!=null) try { conn.close(); }catch(SQLException e) {}
		}
		
		return mVo;
	}
	
}
	
	