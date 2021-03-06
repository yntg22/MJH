package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookieArr = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>쿠키 삭제 연습</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 쿠키 정보 삭제하기</h2><br><br>");
		
		
		
		if(cookieArr==null || cookieArr.length == 0) {
			out.println("<div style='color:red;'>저장된 쿠키가 하나도 없습니다.</div>");
		}else {
			// 3. 쿠키 배열에서 삭제할 쿠키 정보를 구해온다.
			for(Cookie cookie : cookieArr) {
				String cookieName = cookie.getName(); // '쿠키 변수' 구하기
				
				//예) gender 쿠키를 삭제해 보자
				if("count".equals(cookieName)) {
					cookie.setMaxAge(0); // 4. 유지시간을 0으로 설정한다.
					
					response.addCookie(cookie); // 5. 새로 저장한다.
				}
			}
		}
		out.println("count가 초기화 되었습니다.");
		out.println("<a href='"+ request.getContextPath() +"/basic/cookie/cookieTest02.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
