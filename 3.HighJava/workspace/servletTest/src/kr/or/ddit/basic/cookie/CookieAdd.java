package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieAdd.do")
public class CookieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// Cookie 저장하는 방법
		// 1.Cookie객체를 생성한다. ==> '쿠키변수'와 '쿠키값'을 문자열로 지정하여 생성한다.
		// 형식) Cookie cookie변수 = new Cookie("쿠키변수", "쿠키값");
		//	==> 쿠키값으로 한글을 사용할 경우 URLEncoder.encode()메서드로 인코딩한 후 사용한다.
//		Cookie nameCookie = new Cookie("name","홍길동");
		//한글이 깨지면..
		Cookie nameCookie = new Cookie("name",URLEncoder.encode("홍길동", "UTF-8"));
		
		Cookie ageCookie = new Cookie("age","20");
		Cookie genderCookie = new Cookie("gender","Male");
		
		// 2. 쿠키 속성을 설정한다.
		// cookie변수.setPath("적용경로"); ==> 지정한 경로와 그 하위 경로에서 사용가능하다.
		//									생략하면 쿠키를 설정할 당시의 경로가 설정된다.
		// cookie변수.setMaxAge(유지시간); ==> 단위(초)
		//								==> -1 : 브라우저가 종료될 때까지 유지(기본값)
		//								==> 0 : 즉시 쿠키가 삭제된다.
		// cookie변수.setDomain("적용도메인명");
		//								==> 예) ".ddit.or.kr" --> www.ddit.or.kr, mail.ddit.or.kr, cafe.ddit.or.kr
		// cookie변수.setSecure(보안여부);
		//								==> true : 보안적용, false : 보안미적용(기본값)
		
		// 3. response객체를 이용하여 쿠키를 웹브라우저에 응답으로 보내면 웹브라우저가 이 쿠키를
		//    받아서 저장한다.
		// 형식) response.addCookie(1번에서 만든 cookie변수)
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genderCookie);
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>쿠키 저장 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Cookie 데이터가 저장되었습니다.</h2><br><br>");
		out.println("<a href='"+ request.getContextPath() +"/basic/cookie/cookieTest01.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
		
		
		
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
