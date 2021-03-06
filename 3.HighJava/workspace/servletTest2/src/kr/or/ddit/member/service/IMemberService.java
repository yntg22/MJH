package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

public interface IMemberService {

	//멤버전체리스트
	public List<MemberVO> getAllMember();
	
	//멤버의 상세정보검색
	public MemberVO getMemberInfo(String memId);
}
