package kr.or.ddit.basic.reqNresp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseTest01.do")
public class ResponseTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			- forward방식
				==> 특정 서블릿에 대한 요청을 다른 서블릿이나 JSP로 넘겨준다.
				==> 클라이언트 URL주소는 처음 요청할 때의 값이 바뀌지 않으며
					서버 내부에서만 접근이 가능하다.
				==> 처음 요청을 받은 서블릿과 제어를 넘겨받은 서블릿이나  JSP에서는
					Request객체와 Response객체를 공유해서 같이 사용할 수 있다.
				
				==> 보통 이동되는 페이지로 값을 넘기려면 Request객체의 setAttribute()메서드로
				 	데이터를 셋팅하여 보내고, 받는 쪽에서는 getAttribute()메서드로
				 	데이터를 읽어서 사용할 수 있다.
		
		*/
		/*
		 	형식) request.setAttribute(키값, 데이터값);
		 			==> 키값 : 반드시 문자열로 지정한다.
		 			==> 데이터값 : 자바의 모든 데이터 종류
		*/
		
			request.setAttribute("tel", "010-1234-5678");
			
			// 이동할 URL주소는 ContextPath이후의 경로를 기술한다.
			// '/servletTest/responseForwardTest.do'
			RequestDispatcher rd =
					request.getRequestDispatcher("/responseForwardTest.do");
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
