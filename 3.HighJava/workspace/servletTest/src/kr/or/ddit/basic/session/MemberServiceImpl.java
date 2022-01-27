package kr.or.ddit.basic.session;

public class MemberServiceImpl {
	private static MemberServiceImpl service;
	private MemberDaoImpl dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	
	public MemberVO getMember(MemberVO memvo) {
		return dao.getMember(memvo);
	}
	
}
