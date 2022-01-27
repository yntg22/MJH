package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/List.do")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트 요청시 전송데이타 받기
		
		//2. service 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		//3. service메소드 호출 - 결과값 받기
		java.util.List<BoardVO> list = service.selectBoard();
		//4. 결과 값을 출력 또는 json 데이터 생성 - jsp위임
		
		//request에 결과값을 저장
		request.setAttribute("sdasdf",list);
		//5. jsp로 forward
		request.getRequestDispatcher("board/listjson.jsp").forward(request, response);
	}

	

}
