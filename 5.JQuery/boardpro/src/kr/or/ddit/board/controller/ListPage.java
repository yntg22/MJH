package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;


@WebServlet("/ListPage.do")
public class ListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 클라이언트 요청시 전송데이터 받기 - page
		int page = Integer.parseInt(request.getParameter("page"));
		
		//2. service객체 얻어오기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//3. service메소드 호출하기 - 결과값 얻기
		Map<String, Object> map = service.pageInfo(page);
		
		java.util.List<BoardVO> list = service.selectByPage(map);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("totalpage", (Integer) map.get("totalPage"));
		obj.addProperty("startpage", (Integer) map.get("startPage"));
		obj.addProperty("endpage", (Integer) map.get("endPage"));
		
		Gson gson = new Gson();
		JsonElement ele = gson.toJsonTree(list);
		
		obj.add("datas", ele);
		
		out.print(obj);
		
		
//		4. 결과값으로 json데이터 생성
//		request에 결과값 저장
//		request.setAttribute("map", map); //start, end, startPage, endPage, totalPage
//		request.setAttribute("list", list);
//		//5. jsp로 forward
//		request.getRequestDispatcher("board2/pagelist.jsp").forward(request, response);
	}

	
}
