package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberDaoImpl implements IMemberDao{
	private SqlMapClient smc;
	
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		
		return dao;
	}

	
	//전체멤버
	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memberList = new ArrayList<>();
		
		try {
			memberList = smc.queryForList("member.getAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	//상세정보
	@Override
	public MemberVO getMemberInfo(String memId) {
		MemberVO memvo = new MemberVO();
		
		try {
			memvo = (MemberVO) smc.queryForObject("member.getMemberInfo",memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memvo;
	}

}
