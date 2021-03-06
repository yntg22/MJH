package kr.or.ddit.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * SQL문을 DB서버에 보내서 결과를 얻어오는 역할을 수행하는 클래스
 * 이 클래스에서 작성된 메서드는 메서드 하나가 DB와 관련된 작업 1개를
 * 수행하도록 작성한다. 
 * @author PC-17
 */
public interface IMemberDao {
	/**
	 * MemberVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param memVo DB에 insert할 자료가 저장된 MemberVO객체
	 * @return 작업 성공 : 1이상의 정수, 작업실패 : 0
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * @param memId 삭제할 회원ID(String)
	 * @return 작업 성공 : 1, 작업실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVO자료를 이용하여 회원 정보를 수정하는 메서드
	 * @param memVo 수정할 회원 정보가 저장된  MemberVO객체
	 * @return 수정 성공 : 1, 수정실패 : 0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * 회원 정보 전체를 가져와서 List에 담아서 반환하는 메서드
	 * @return MemberVO를 담고있는 List객체
	 */
	public List<MemberVO> getAllMember();

	/**
	 * 회원ID를 매개변수로 받아서 해당 회원의 개수를 반환하는 메서드
	 * @param memId 검색할 회원ID
	 * @return 검색된 회원ID 개수
	 */
	public int getMemberCount(String memId);

	int updateMember2(Map<String, String> paramMap);

}
