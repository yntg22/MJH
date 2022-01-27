package kr.or.ddit.join.dao;

import java.util.List;

import kr.or.ddit.join.vo.MemberVO;
import kr.or.ddit.join.vo.ZipVO;

public interface IMemberDao {

	//id 중복
	public String selelctById(String id);

	//우편번호
	public List<ZipVO> selectByDong(String dong);

	//저장
	public String insertMember(MemberVO vo);
	
	//전체리스트
	public List<MemberVO> selectAll();
}
