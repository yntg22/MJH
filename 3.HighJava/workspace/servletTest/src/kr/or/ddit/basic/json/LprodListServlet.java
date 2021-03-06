package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/lprodListServlet.do")
public class LprodListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LprodDaoImpl dao = LprodDaoImpl.getInstance();
		
		/*List<LprodVO> lvo = dao.getLprod();
		
		request.setAttribute("lvo", lvo);
		request.getRequestDispatcher("/basic/jsonTest/lprod.jsp").forward(request, response);
		*/
		//GSON라이브러리를 이용해서 Ajax용 json응답데이터를 구성해서 보내주는 서블릿
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// DB에서 원하는 자료를 구해온다.
		List<LprodVO> lprodList = dao.getLprod();
		
		// 처리된 데이터를 JSON데이터 구조로 변경한다.
		Gson gson = new Gson();
		
		// toJson(자바의 자료) ==> '자바의 자료'를 JSON구조의 문자열로 변환해 준다.
		String jsonData = gson.toJson(lprodList);
		
		System.out.println(jsonData);
		// 변환된 데이터를 응답으로 보낸다.
		out.write(jsonData);

		response.flushBuffer();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
