package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jmx.snmp.Enumerated;


@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// Session 데이터 읽어오기
		
		// 1. Session객체를 생성하거나 현재 Session객체 가져오기
		HttpSession session = request.getSession();
		
		// 2. Session 데이터 읽어오기 ==> getAttribute()메서드 이용
		// 형식) session객체.getAttribute("key값");
		// session에 저장할때 Object로 저장됨 ==> 꺼낼때 형변환 해야함
		String sessionValue = (String)session.getAttribute("testSession");
		
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Session 읽기</title></head>");
		out.println("<body>");
		out.println("<h2>Session데이터 확인하기</h2>");
		if(sessionValue==null) {
			out.println("<h3>testSession의 세션값이 없습니다.</h3>");
		}else {
			out.println("<h3>testSession : " + sessionValue +"</h3>");
		}
		
		out.println("<br><hr><br>");
		
		// 전체 Session데이터 가져오기
		
		// 세션의 모든 key값 구하기
		Enumeration<String> sessionNames = session.getAttributeNames();
		
		int cnt = 0;
		out.println("<ol>");
		while(sessionNames.hasMoreElements()) {
			cnt++;
			String sessionKey = sessionNames.nextElement();
			out.println("<li>" + sessionKey + " : " + session.getAttribute(sessionKey) + "</li>");
		}
		if(cnt==0) out.println("<li>Session데이터가 하나도 없습니다.</li>");
		
		out.println("</ol>");
		
		out.println("<br><hr><br>");
		
		out.println("<h2>기타 Session 정보</h2>");
		// 세션 ID ==> 세션을 구분하기 위한 고유한 값
		out.println("세션ID : " + session.getId() + "<br>");
		
		// 생성시간 ==> 1970년1월1일부터 경과한 시간(밀리세컨드 단위)
		out.println("세션 생성 시간 : " + session.getCreationTime() + "<br>");
		
		// 가장 최근에 세션에 접근한 시간 ==> 1970년1월1일부터 경과한 시간(밀리세컨드 단위)
		out.println("세션 최근 접근 시간 : " + session.getLastAccessedTime() + "<br>");
		
		// 세션의 유효시간 ==> 세션이 사용된 후 자동으로 삭제될 때까지의 시간(단위 초)
		// 유효시간 설정 방법 ==> session.setMaxInactiveInterval(초단위 시간)
		/*
		  - web.xml에 유효시간 설정방법
		 <session-config>
		 	<session-timeout>분단위 시간</session-timeout>
		 </session-config>
		*/
		out.println("세션 유효시간 : " + session.getMaxInactiveInterval() + "<br>");
		
		out.println("<br><hr><br>");
		
		out.println("<a href='"+request.getContextPath() +
				"/basic/session/sessionTest.jsp'>시작문서로 가기</a>");
		
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
