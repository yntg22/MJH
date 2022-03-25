package kr.or.ddit.prod.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;

public class ProdDAOImpl implements ProdDAO{

	private SqlSessionFactory SqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public ProdVO selectProd(String prodId) {
		try(
			SqlSession sqlSession = SqlSessionFactory.openSession();
		){
			ProdDAO mapper = sqlSession.getMapper(ProdDAO.class);
			return mapper.selectProd(prodId);
		}
	}

	@Override
	public int insertProd(ProdVO prod) {
		try(
			SqlSession sqlSession = SqlSessionFactory.openSession();
		){
			ProdDAO mapper = sqlSession.getMapper(ProdDAO.class);
			int rowcnt = mapper.insertProd(prod);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int updateProd(ProdVO prod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectTotalRecord(PagingVO<ProdVO> paging) {
		try (SqlSession sqlSession = SqlSessionFactory.openSession();) {
			ProdDAO mapper = sqlSession.getMapper(ProdDAO.class);
			return mapper.selectTotalRecord(paging);
		}
	}
	@Override
	public List<ProdVO> selectProdList(PagingVO<ProdVO> paging) {
		try(
				SqlSession sqlSession = SqlSessionFactory.openSession();
			){
				ProdDAO mapper = sqlSession.getMapper(ProdDAO.class);
				return mapper.selectProdList(paging);
			}
	}


}
