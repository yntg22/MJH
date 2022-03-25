package kr.or.ddit.prod.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;
import kr.or.ddit.vo.SimpleSearchVO;

@WebServlet("/prod/prodList.do")
public class ProdListServlet extends HttpServlet{
	private ProdService service = new ProdServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageParam = req.getParameter("page");
		
		String searchType = req.getParameter("searchType");
		String searchWord = req.getParameter("searchWord");
		SimpleSearchVO simpleCondition = new SimpleSearchVO(searchType, searchWord);
		
		
		
		int currentPage = 1;
		if(StringUtils.isNumeric(pageParam)) {
			currentPage = Integer.parseInt(pageParam);
		}
		
		PagingVO<ProdVO> paging = new PagingVO<>(3, 2);
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition); //검색
		service.retrieveProdList(paging);
		
		req.setAttribute("paging", paging);
		
		String viewName = "prod/prodList";
		viewResolve(viewName, req, resp);
	}
	
	private void viewResolve(String viewName, HttpServletRequest req, HttpServletResponse resp)
	         throws ServletException, IOException{
//	      5. 뷰로 이동.
    if(viewName.startsWith("redirect:")) {
       viewName = viewName.substring("redirect:".length());
       resp.sendRedirect(req.getContextPath()+viewName);
    }else if(viewName.startsWith("forward:")){
       viewName = viewName.substring("forward:".length());
       req.getRequestDispatcher(viewName).forward(req, resp);
    }else {
       String prefix = "/WEB-INF/views/";
       String suffix = ".jsp";
       req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);
    }
 }
}
