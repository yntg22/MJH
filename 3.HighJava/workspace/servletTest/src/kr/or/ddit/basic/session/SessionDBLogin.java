package kr.or.ddit.basic.session;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.util.DBUtil3;



@WebServlet("/sessionDBLogin.do")
public class SessionDBLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 회원ID와 Password를 파라미터로 받아온다.
		String memId = request.getParameter("userid");
		String memPass = request.getParameter("userpass");
		
		// 파라미터로 받아온 데이터를 VO객체에 넣는다.
		MemberVO memvo = new MemberVO();
		memvo.setMem_id(memId);
		memvo.setMem_pass(memPass);
		
		// Service객체 생성
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		
		MemberVO loginMember = service.getMember(memvo);
		
		HttpSession session = request.getSession();
		
		if(loginMember!=null) { //로그인 성공시
			session.setAttribute("loginUser", loginMember);
		}
		
		response.sendRedirect(request.getContextPath()
								+"/basic/session/sessionDBLogin.jsp");
		
		/*response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		//세션 생성
		HttpSession session = request.getSession();
		
		String memId = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String memId2 = null;
		String pass2 = null;
		String memname = null;
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from member where mem_id = ? and mem_pass = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memId2 = rs.getString(1);
				pass2 = rs.getString(2);
				memname = rs.getString(3);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
	
		
		
		if(memId2 != null && pass2 != null) {
		session.setAttribute("userId", memId);
		session.setAttribute("userPass", pass);
		session.setAttribute("name", memname);
		}
		response.sendRedirect(request.getContextPath()+"/basic/session/sessionDBLogin.jsp");*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
