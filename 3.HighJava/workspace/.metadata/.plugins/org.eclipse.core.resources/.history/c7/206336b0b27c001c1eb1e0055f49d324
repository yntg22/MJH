package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 전달되는 문자의 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");
		
		// 응답을 위한 사전 설정
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//------------------------------------
				
		
		
		// 전달되는 데이터 받기 (Request객체를 이용한다.)
		
		// 1) getParameter("파라미터명"); ==> 해당 파라미터에 설정된 '값'을 가져온다.
		//				==> 가져오는 '값'의 자료형은 'String'이다.
		// 		파라미터명은 <form>태그 안에 데이터를 구성하는 태그들의 name속성의 속성값을 말한다.
		String userName = request.getParameter("username");	//""안에 값은 대소문자 구분
		String job = request.getParameter("job");
		
		// 2) getParameterValues("파라미터명"); 
		//				==> 파라미터명이 같은 것이 여러개 일 경우에 사용한다.
		//				==> 가져온 '값'의 자료형 'String[]'이 된다.
		
		String[] hobbies = request.getParameterValues("hobby");
		
		
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Request객체 연습</title></head>");
		out.println("<body>");
		out.println("<h2>request 테스트 결과</h2><hr>");
		out.println("<table border='1'>");
		out.println("<tr><td>이 름</td><td>" + userName + " </td></tr>");
		out.println("<tr><td>이 름</td><td>" + job + " </td></tr>");
		
		out.println("<tr><td>취미</td><td>");
		if(hobbies==null) {
			out.println("없음");
		}else {
			for(String h : hobbies) {
				out.println(h + "<br>");
			}
		}
		out.println("</td><tr>");
		
		
		out.println("</table>");
		
		//--------------------------------------------------------
		out.println("<br><hr><br>");
		
		out.println("<h2>request객체의 메서드들...</h2>");
		out.println("<ol>");
		out.println("<li>클라이언트의 IP주소 : " + request.getRemoteAddr() + "</li>" );
		out.println("<li>요청 메서드 : " + request.getMethod() + "</li>" );
		out.println("<li>ContextPath : " + request.getContextPath() + "</li>" );
		out.println("<li>프로토콜 : " + request.getProtocol() + "</li>" );
		out.println("<li>URL정보 : " + request.getRequestURL() + "</li>" );
		out.println("<li>URI정보 : " + request.getRequestURI() + "</li>" );
		out.println("</ol>");
		
		
		out.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
