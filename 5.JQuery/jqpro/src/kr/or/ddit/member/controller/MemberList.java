package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.join.service.IMemberService;
import kr.or.ddit.join.service.MemberServiceImpl;
import kr.or.ddit.join.vo.MemberVO;


@WebServlet("/MemberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//service객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		//service메서드 호출
		List<MemberVO> list = service.selectAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("동기html/member.jsp").forward(request, response);
		
		/*response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//결과값 출력하기
		out.print("<html>");
		out.print("<body>");
		out.print("<table>");
		out.print("<tr><td>아이디</td>");
		out.print("<td>이름</td>");
		out.print("<td>메일</td>");
		out.print("<td>전화번호</td></tr>");
		
		for(int i=0; i<list.size(); i++) {
			MemberVO vo = list.get(i);
			
			out.print("<tr><td>"+vo.getMem_id()+"</td>");
			out.print("<td>"+vo.getMem_name()+"</td>");
			out.print("<td>"+vo.getMem_mail()+"</td>");
			out.print("<td>"+vo.getMem_hp()+"</td></tr>");
		}
		out.print("</table>");
		out.print("</body>");*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
