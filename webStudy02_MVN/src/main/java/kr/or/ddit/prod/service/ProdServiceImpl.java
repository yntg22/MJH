package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.utils.PasswordUtils;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements ProdService{
	private ProdDAO prodDAO = new ProdDAOImpl();
	
	@Override
	public ProdVO retrieveProd(String prodId) {
		ProdVO prod = prodDAO.selectProd(prodId);
		if(prod==null)
			throw new PKNotFoundException(prodId + "에 해당하는 상품이 없습니다");
		return prod;
	}

	@Override
	public ServiceResult createProd(ProdVO prod) {
		ServiceResult result = null;
		try {
			retrieveProd(prod.getProdId());
			result = ServiceResult.PKDUPLICATED;
		} catch (Exception e) {
			int rowcnt = prodDAO.insertProd(prod);
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
		return result;
	}

	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdVO> retrieveProdList(PagingVO<ProdVO> paging) {
		int totalRecord = prodDAO.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		List<ProdVO> prodList =  prodDAO.selectProdList(paging);
		paging.setDataList(prodList);
		return prodList;
	}

}
