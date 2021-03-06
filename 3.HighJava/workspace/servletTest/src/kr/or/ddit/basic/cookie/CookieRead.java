package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieRead.do")
public class CookieRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장된 Cookie정보 읽어오기
		// 1. 전체 쿠키 정보를 request객체를 이용하여 가져온다.
		//		==> 가져온 쿠키 정보들은 배열에 저장된다.
		// 형식) Cookie[] 쿠키배열변수 = request.getCookies();
		Cookie[] cookieArr = request.getCookies();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Cookie 읽기 연습</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 쿠키 정보 확인하기</h2>");
		
		if(cookieArr==null || cookieArr.length == 0) {
			out.println("<div style='color:red;'>저장된 쿠키가 하나도 없습니다.</div>");
		}else {
			// 2. 쿠키 배열에서 해당 쿠키 정보를 구해온다.
			for(Cookie cookie : cookieArr) {
				String cookieName = cookie.getName(); // '쿠키변수' 가져오기
				
//				String cookieValue = cookie.getValue(); // '쿠키값' 가져오기
				//인코딩된 데이터를 가져올 때는 디코딩해서 사용한다.
				String cookieValue = URLDecoder.decode(cookie.getValue(), "utf-8");
				
				out.println("쿠키변수 : " + cookieName + "<br>");
				out.println("쿠키 값 : " + cookieValue + "<br><hr>");
			}
			
		}
		
		
		out.println("<a href='"+ request.getContextPath() +"/basic/cookie/cookieTest01.jsp'>시작문서로 가기</a>");
		
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
