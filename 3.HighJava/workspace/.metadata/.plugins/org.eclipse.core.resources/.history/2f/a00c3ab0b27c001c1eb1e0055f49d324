package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseTest02.do")
public class ResponseTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	
		- redirect방식
			==> 다른 페이지로 제어가 넘어가도록 한다.
			==> 응답시 브라우저에게 '이동할 URL'을 전송하면 브라우저가 해당 URL을 받아서 
				바로 재 요청하여 이동하는 방식이다.
			==> 이 때는 무조건 "GET"방식으로 재 요청이 된다.(그래서  URL의 길이에 제한이 있다.)	
	*/	
	/*	
		// redirect방식은 Request객체를 유지하지 못한다.
		// (브라우저에서 새롭게 요청하기 때문에..)
		request.setAttribute("tel", "010-4450-8698");
		
		// 이동할 경로는 전체 URL을 모두 기술한다.
		response.sendRedirect(
				request.getContextPath() + "/responseRedirectTest.do");
	*/
		
		
		// 데이터를 보내려면 사용자가 보낸 데이터를 구한 후 GET방식으로 보낼 수 있다.
		String userName = request.getParameter("username");
		// 보낼 새로운 데이터도 구성한다.
		String myTel = "010-9876-5432";
		
		response.setCharacterEncoding("utf-8");
		
		
		response.sendRedirect(
				request.getContextPath() 
				+ "/responseRedirectTest.do?username=" 
					+ userName + "&tel=" + myTel );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
