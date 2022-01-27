<%@page import="kr.or.ddit.join.vo.MemberVO"%>
<%@page import="java.util.List"%>
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
	List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
%>
	<table>
		<tr><td>아이디</td>
		<td>이름</td>
		<td>메일</td>
		<td>전화번호</td></tr>
		
		<%for(int i=0; i<list.size(); i++) {
			MemberVO vo = list.get(i);
		%>
			<tr><td><%= vo.getMem_id()%></td>
		<td><%= vo.getMem_name()%></td>
			<td><%=vo.getMem_mail() %></td>
			<td><%=vo.getMem_hp() %></td></tr>
		<%}%>
		</table>
</body>
</html>