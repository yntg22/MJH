package kr.or.ddit.buyer.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BuyerVO;

public class BuyerDAOImpl implements BuyerDAO {

   private SqlSessionFactory SqlSessionFactory =
         CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
   @Override
   public BuyerVO selectBuyer(String buyerId) {
      try(
         SqlSession sqlSession = SqlSessionFactory.openSession();
      ){
         BuyerDAO mapper = sqlSession.getMapper(BuyerDAO.class);
         return mapper.selectBuyer(buyerId);
      }
   }

}