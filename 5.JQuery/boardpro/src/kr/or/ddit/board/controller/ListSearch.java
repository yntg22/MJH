package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;

@WebServlet("/ListSearch.do")
public class ListSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트 요청시 전송값 - page, type, word
		int cpage = Integer.parseInt(request.getParameter("page"));
		String stype = request.getParameter("type");
		String sword = request.getParameter("word");
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		map.put("cpage", cpage);
		
		// service객체 얻기
		
		
		// service 메소드 호출 - 결과값 얻기 
		
		// 결과값으로 json데이터 생성하기
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
