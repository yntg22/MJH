/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-01-24 06:54:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class board_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>아코디언게시판</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/public.css\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"></script>\r\n");
      out.write("  <script src=\"../js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("  \r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write(".box{\r\n");
      out.write("\tpadding : 20px;\r\n");
      out.write("}\r\n");
      out.write(".card{\r\n");
      out.write("\tmargin : 2px;\r\n");
      out.write("}\r\n");
      out.write(".card-header{\r\n");
      out.write("\tbackground: #32AAFF;\r\n");
      out.write("}\r\n");
      out.write(".card-header:hover{\r\n");
      out.write("\tbackground: lightblue;\r\n");
      out.write("}\r\n");
      out.write(".card-link{\r\n");
      out.write("\tcolor : black;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl\t\t: '/boardpro/List2.do',\r\n");
      out.write("\t\tmethod\t: 'get',\r\n");
      out.write("\t\tsuccess : function(res){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tcode = '<div id=\"accordion\">';\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.each(res, function(i, v){\r\n");
      out.write("\t\t\t\tcode += '<div class=\"card\">'\r\n");
      out.write("\t\t\t\tcode += '<div class=\"card-header\">'\r\n");
      out.write("\t\t\t\tcode += '<a class=\"card-link\" data-toggle=\"collapse\" href=\"#collapse'+v.num+'\">'\r\n");
      out.write("\t\t\t\tcode += v.subject;\r\n");
      out.write("\t\t\t\tcode += '</a>'\r\n");
      out.write("\t\t\t\tcode += '</div>'\r\n");
      out.write("\t\t\t\tcode += '<div id=\"collapse'+v.num+'\" class=\"collapse\" data-parent=\"#accordion\">'\r\n");
      out.write("\t\t\t\tcode += '<div class=\"card-body\">'\r\n");
      out.write("\t\t\t\tcode += '<p class=\"p1\">'\r\n");
      out.write("\t\t\t\tcode += '작성자 : <span class=\"wr\">'+v.writer+'</span> &nbsp;&nbsp;&nbsp;&nbsp;'\r\n");
      out.write("\t\t\t\tcode += '이메일 : <span class=\"em\">'+v.mail+'</span> &nbsp;&nbsp;&nbsp;&nbsp;'\r\n");
      out.write("\t\t\t\tcode += '조회수 : <span class=\"hit\">'+v.hit+'</span> &nbsp;&nbsp;&nbsp;&nbsp;'\r\n");
      out.write("\t\t\t\tcode += '날짜 : <span class=\"da\">'+v.wdate+'</span> &nbsp;&nbsp;&nbsp;&nbsp;'\r\n");
      out.write("\t\t\t\tcode += '</p>'\r\n");
      out.write("\t\t\t\tcode += '<p class=\"p2\">'\r\n");
      out.write("\t\t\t\tcode += '<input type=\"button\" class=\"action\" name=\"modify\" idx=\"'+v.num+'\" value=\"수정\" >'\r\n");
      out.write("\t\t\t\tcode += '<input type=\"button\" class=\"action\" name=\"delete\" idx=\"'+v.num+'\" value=\"삭제\" >'\r\n");
      out.write("\t\t\t\tcode += '</p>'\r\n");
      out.write("\t\t\t\tcode += '<hr>'\r\n");
      out.write("\t\t\t\tcode += '<p class=\"p3\">'\r\n");
      out.write("\t\t\t\tcode += '내용보기 내용출력<br>'\r\n");
      out.write("\t\t\t\tcode += v.content;\r\n");
      out.write("\t\t\t\tcode += '</p>'\r\n");
      out.write("\t\t\t\tcode += '<p class=\"p4\">'\r\n");
      out.write("\t\t\t\tcode += '<textarea rows=\"\" cols=\"100\"></textarea>'\r\n");
      out.write("\t\t\t\tcode += '<input type=\"button\" class=\"action\" name=\"reply\" idx=\"'+v.num+'\" value=\"등록\">'\r\n");
      out.write("\t\t\t\tcode += '</p>'\r\n");
      out.write("\t\t\t\tcode += '</div>'\r\n");
      out.write("\t\t\t\tcode += '</div>'\r\n");
      out.write("\t\t\t\tcode += '</div>'\r\n");
      out.write("\t\t\t})                                                                                 \r\n");
      out.write("\t\t\t                                                                                          \r\n");
      out.write("\t\t\tcode += \"</div>\"\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$('.box').html(code);\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror : function(xhr){\r\n");
      out.write("\t\t\talert(\"상태 : \" + xhr.status);\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tdataType : 'json'\r\n");
      out.write("\t})\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"box\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}