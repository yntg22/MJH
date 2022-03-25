package kr.or.ddit.member.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteServlet extends HttpServlet{
   private MemberService service = new MemberServiceImpl();
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
      MemberVO authMember = (MemberVO)session.getAttribute("authMember");
      String memId = authMember.getMemId();
      String memPass = req.getParameter("memPass");
      if(StringUtils.isBlank(memPass)) {
         resp.sendError(400, "필수 파라미터 누락");
         return;
      }
      ServiceResult result = service.removeMember(new MemberVO(memId, memPass));
      String viewName = null;
      switch (result) {
      case INVALIDPASSWORD:
         viewName = "redirect:/myPage.do";
         session.setAttribute("message", "비밀번호 오류");
         break;
      case FAIL:
         viewName = "redirect:/myPage.do";
         session.setAttribute("message", "서버 오류, 쫌따 다시 탈퇴!");
         break;

      default:
         session.invalidate();
         viewName = "redirect:/";
         break;
      }
      
      viewResolve(viewName, req, resp);
   }
   private void viewResolve(String viewName, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
//         5. 뷰로 이동.
   if(viewName.startsWith("redirect:")) {
      viewName = viewName.substring("redirect:".length());
      resp.sendRedirect(req.getContextPath()+viewName);
   }else if(viewName.startsWith("forward:")){
      viewName = viewName.substring("forward:".length());
      req.getRequestDispatcher(viewName).forward(req, resp);
   }else {
      String prefix = "/WEB-INF/views/";
      String suffix = ".jsp";
      req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);
   }
}
}