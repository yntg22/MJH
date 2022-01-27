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

@WebServlet("/MemberJSON.do")
public class MemberJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//service객체 얻기
				IMemberService service = MemberServiceImpl.getInstance();
				//service메서드 호출
				List<MemberVO> list = service.selectAll();
				
				request.setAttribute("list", list);
				request.getRequestDispatcher("ajax비동기json/member.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
