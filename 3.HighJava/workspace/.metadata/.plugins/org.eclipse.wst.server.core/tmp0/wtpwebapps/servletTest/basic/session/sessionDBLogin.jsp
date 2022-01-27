<%@page import="kr.or.ddit.basic.session.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
	// session에 저장된 데이터 가져오기
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
// 	if(session.getAttribute("name") != null ){
		if(loginMember != null){
%>
<%-- <h2><%=session.getAttribute("name") %>님 반갑습니다.</h2> --%>
<h2><%=loginMember.getMem_name() %>님 반갑습니다.</h2>
	<a href="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>
<% }else{ %>
	<form action="<%=request.getContextPath() %>/sessionDBLogin.do" method="post">
<table style="margin:0 auto;">
<tr>
   <td> ID : </td>
   <td> <input type="text" name="userid" placeholder="ID를 입력하세요">

</tr>   
<tr>
   <td> PASS : </td>
   <td> <input type="password" name="userpass" placeholder="Password를 입력하세요">

</tr>
  
<tr>
   <td colspan="2" style="text-align:cnter;">
      <input type="submit" value="Login">
   </td>   
</tr>   
</table>

</form>
<%} %>
</body>
</html>