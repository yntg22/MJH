package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieArr = request.getCookies();
		
		if(cookieArr==null || cookieArr.length == 1) {
			count = 1;
		}else {
			
			
		
		count++;
		
		}
		Cookie countCookie = new Cookie("count",Integer.toString(count));
		//String.valueOf();도 사용가능
		response.addCookie(countCookie);
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>쿠키 Count 연습</title></head>");
		out.println("<body>");
		out.println("<h2>어서오세요. 당신은 "+count+"번째 방문입니다.</h2><br><br>");
		out.println("<a href='"+ request.getContextPath() +"/basic/cookie/cookieTest02.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
