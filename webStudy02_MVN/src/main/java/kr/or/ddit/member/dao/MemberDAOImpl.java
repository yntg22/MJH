package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	
	private SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public MemberVO selectMemberForAuth(MemberVO input) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
				return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMemberForAuth", input);
		}
	}

	@Override
	public int insertMember(MemberVO member) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			
//			return sqlSession.insert("kr.or.ddit.member.dao.MemberDAO.insertMember",member);
			MemberDAO mapper = sqlSession.getMapper(MemberDAO.class); //메퍼 프록시
			int rowcnt = mapper.insertMember(member);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public List<MemberVO> selectMemberList() {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			return sqlSession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
		}
	}

	@Override
	public MemberVO selectMember(String memId) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMember",memId);
		}
	}

	@Override
	public int updateMember(MemberVO member) {
		try(
				//opensession() 커밋안됨 (false) (true) 검색해볼것
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			int rowcnt = sqlSession.update("kr.or.ddit.member.dao.MemberDAO.updateMember", member);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int deleteMember(String memId) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			int rowcnt = sqlSession.update("kr.or.ddit.member.dao.MemberDAO.deleteMember",memId);
			sqlSession.commit();
			return rowcnt;
		}
	}

}
