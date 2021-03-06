package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	//싱글톤패턴
	private IMemberDao memberDao;
	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	
	//모든 멤버리스트
	@Override
	public List<MemberVO> getAllMember() {
		return memberDao.getAllMember();
	}
	
	//멤버 상세정보
	@Override
	public MemberVO getMemberInfo(String memId) {
		return memberDao.getMemberInfo(memId);
	}
	
}
