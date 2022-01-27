package kr.or.ddit.join.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.join.service.IMemberService;
import kr.or.ddit.join.service.MemberServiceImpl;
import kr.or.ddit.join.vo.ZipVO;

/**
 * Servlet implementation class ZipDong
 */
@WebServlet("/ZipDong")
public class ZipDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ZipDong() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 클라이언트 요청시 전송되는 값 가져오기 - dong
		String dongdong = request.getParameter("dong");
		// 2. service객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		// 3. service메소드 호출 - 결과값 받기
		List<ZipVO> list = service.selectByDong(dongdong);
		// 4. 결과값을 request에 저장
		request.setAttribute("list", list);
		// 5. jsp로 이동
		request.getRequestDispatcher("0118/zipsearch.jsp").forward(request, response);
	}

}
