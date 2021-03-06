package kr.or.ddit.join.service;

import java.util.List;

import kr.or.ddit.join.dao.IMemberDao;
import kr.or.ddit.join.dao.MemberDaoImpl;
import kr.or.ddit.join.vo.MemberVO;
import kr.or.ddit.join.vo.ZipVO;

//1. 자신의 객체를 생성하여 리턴
//2. dao객체얻어오기

public class MemberServiceImpl implements IMemberService {
	
	private static IMemberService service;
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	
	@Override
	public String selelctById(String id) {
//		String sid = null;
//		sid = dao.selelctById(id);
//		return sid;
		
		return dao.selelctById(id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		// TODO Auto-generated method stub
		return dao.selectByDong(dong);
	}

	@Override
	public String insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.insertMember(vo);
	}

	@Override
	public List<MemberVO> selectAll() {
		return dao.selectAll();
	}
	

}
