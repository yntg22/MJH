package kr.or.ddit.buyer.service;

import kr.or.ddit.buyer.dao.BuyerDAO;
import kr.or.ddit.buyer.dao.BuyerDAOImpl;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.ProdVO;

public class BuyerServiceImpl implements BuyerService{
	private BuyerDAO dao = new BuyerDAOImpl();
	@Override
	public BuyerVO retrieveBuyer(String buyerId) {
		BuyerVO prod = dao.selectBuyer(buyerId);
		if(prod==null)
			throw new PKNotFoundException(buyerId + "에 해당하는 상품이 없음");
		return prod;
	}

}
