package kr.or.ddit.buyer.dao;

import kr.or.ddit.vo.BuyerVO;

public interface BuyerDAO {
	public BuyerVO selectBuyer(String buyerId);
}
