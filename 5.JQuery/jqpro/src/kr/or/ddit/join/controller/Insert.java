package kr.or.ddit.join.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.join.service.IMemberService;
import kr.or.ddit.join.service.MemberServiceImpl;
import kr.or.ddit.join.vo.MemberVO;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert.do")
public class Insert extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
                //한글로 들어오는 값, doPost에서는 깨진다.(doGet에서는 안 깨진다.)
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      request.setCharacterEncoding("UTF-8");
      
      //1.클라이언트 요청시 전송되는 값을 받는다.- 8개 mem_id, ...
      String id = request.getParameter("mem_id");
      String name = request.getParameter("mem_name");
      String pass = request.getParameter("mem_pass");
      String mail = request.getParameter("mem_mail");
      String zip = request.getParameter("mem_zip");
      String add1 = request.getParameter("mem_add1");
      String add2 = request.getParameter("mem_add2");
      String hp = request.getParameter("mem_hp");
      
      MemberVO vo = new MemberVO();
      
      vo.setMem_id(id);
      vo.setMem_name(name);
      vo.setMem_pass(pass);
      vo.setMem_mail(mail);
      vo.setMem_zip(zip);
      vo.setMem_add1(add1);
      vo.setMem_add2(add2);
      vo.setMem_hp(hp);
      
      //2.service객체 얻기
      
      IMemberService svc = MemberServiceImpl.getInstance();
      
      //3.service메서드 호출하기 - 결과값 받기
      
      String sid = svc.insertMember(vo);
      
      //4.결과값으로 응답데이터 생성 - JSP로 위임하기
         //request에 결과값 저장
      request.setAttribute("sid", sid);
      
      //5.JSP로 이동 - forward
      request.getRequestDispatcher("0118/insert.jsp").forward(request, response);
   
   }

}







