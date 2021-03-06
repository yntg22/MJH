package kr.or.ddit.basic.json;


import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.DBUtil3;

public class LprodDaoImpl {
	
	private static LprodDaoImpl dao;
	
	private LprodDaoImpl() {}
	
	public static LprodDaoImpl getInstance() {
		if(dao==null) dao = new LprodDaoImpl();
		return dao;
	}
	
	public List<LprodVO> getLprod() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		LprodVO lvo = null;
		List<LprodVO> lprodList = new ArrayList<>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from lprod";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				lvo = new LprodVO();
				
				lvo.setLprod_id(rs.getString("lprod_id"));
				lvo.setLprod_gu(rs.getString("lprod_gu"));
				lvo.setLprod_nm(rs.getString("lprod_nm"));
				
				lprodList.add(lvo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); }catch(SQLException e) {}
			if(stmt!=null) try { stmt.close(); }catch(SQLException e) {}
			if(conn!=null) try { conn.close(); }catch(SQLException e) {}
		}
		return lprodList;
	}
	
}
