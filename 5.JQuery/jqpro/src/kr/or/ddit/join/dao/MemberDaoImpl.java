package kr.or.ddit.join.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.config.SqlMapClientFactory;
import kr.or.ddit.join.vo.MemberVO;
import kr.or.ddit.join.vo.ZipVO;

//1. 자신의 객체를 생성해서 리턴
//2. SqlMapClient객체
public class MemberDaoImpl implements IMemberDao {

	private SqlMapClient client;
	private static IMemberDao dao;
	
	private MemberDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IMemberDao getInstance() {
		
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public String selelctById(String id) {
		String resid = null;
		
		try {
			resid = (String) client.queryForObject("join.selectById",id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resid;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		List<ZipVO> list = null;
		
		try {
			list = client.queryForList("join.selectByDong",dong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String insertMember(MemberVO vo) {
		String memID = null;
		
		try {
			memID = (String) client.insert("join.insertMember", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memID;
	}

	@Override
	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		try {
			list=client.queryForList("join.selectAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
