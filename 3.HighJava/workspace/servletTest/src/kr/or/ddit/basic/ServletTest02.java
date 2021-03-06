package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	이 예제는 작성한 서블릿을 어노테이션(@WebServlet)을 이용해서
 	등록하여 실행하는 예제이다.
 	
 	이 애노테이션(@WebServlet)은 Servlet버전 3.0이상에서 사용 가능하다.
 	
*/

/*
	@WebServlet애노테이션의 설정 방법 (제공하는 속성과 그 역할)
	1) name : 서블릿 이름을 설정한다. (기본값 : 빈문자열("") )
	2) urlPatterns : 서블릿의 URL패턴의 목록을 설정한다. (기본값 : 빈배열({}))
			예) urlPatterns="/url1" 또는 urlPatterns={"/url1"} ==> 등록 URL패턴이 1개일 경우
			예) urlPatterns={"/url1", "/url2", ...} ==> 등록 URL패턴이 2개 이상일 경우
	3) value : urlPatterns와 동일한 기능을 한다.
	4) description : 주석(설명글)을 기술한다.
	
*/
@WebServlet(
		name="servletTest2", urlPatterns="/servletTest02.do",
		description="애노테이션을 이용한 서블릿입니다."
)
public class ServletTest02 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
			// 응답을 보낸다. ==> HTML문서의 내용을 출력한다.
			
			// 방법2) print()메서드 또는 println()메서드 이용하기
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='utf-8'>");
			out.println("<title>두번째 Servlet</title></head>");
			out.println("<body>");
			out.println("<h2 style='text-align:center'>");
			out.println("애노테이션으로 설정한 두번째 서블릿 입니다.");
			out.println("ContextPath : " + request.getContextPath());
			out.println("</body></html>");
			
			
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
