package kr.or.ddit.join.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.join.service.IMemberService;
import kr.or.ddit.join.service.MemberServiceImpl;

/**
 * Servlet implementation class IDCheck
 */
@WebServlet("/IDCheck")
public class IDCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IDCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청시 전송데이터를 받는다 - 입력받은 id
		String userId = request.getParameter("id");
		
		// service객체를 얻어온다
		IMemberService service = MemberServiceImpl.getInstance();
		
		// service메소드 호출 - 결과값을 받는다
		String id = service.selelctById(userId);
		
		//html로 출력 하거나 json데이터로 생성 - jsp로 위임한다
		//결과값 id를 request객체에 저장
		request.setAttribute("keyid", id);
		
		//jsp 페이지로 이동 - forword, redirect
		request.getRequestDispatcher("0118/checkId.jsp").forward(request, response);
		
		// 결과값을 가지고 출력한다 - json데이터를 생성
		/*PrintWriter out = response.getWriter();
		//json데이터로 만들수있꼬
		if(id != null) {
			out.print("{");
				out.print("\"sw\" : \"사용불가능한 아이디입니다.\"");
			out.print("}");
		}else {
			out.print("{");
				out.print("\"sw\" : \"사용가능한 아이디입니다.\"");
					out.print("}");
		}
		//html로도 만들수있따
		out.print("<html>");
		out.print("<body>");
		out.print("<p>사용가능한 아이디입니다</p>");
		out.print("");
		out.print("</body>");
		out.print("</html>");*/
		
		
	}

}
