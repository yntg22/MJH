<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Info</title>
<%
	MemberVO memvo = (MemberVO)request.getAttribute("memvo");
%>
</head>
<body>
	<table border="1" style="margin : 0 auto;">
		<tr><td>회원ID</td> <td><%=memvo.getMem_id() %></td></tr>
		<tr><td>비밀번호</td> <td><%=memvo.getMem_pass() %></td></tr>
		<tr><td>회원이름</td> <td><%=memvo.getMem_name() %></td></tr>
		<tr><td>전화번호</td> <td><%=memvo.getMem_tel() %></td></tr>
		<tr><td>회원주소</td> <td><%=memvo.getMem_addr() %></td></tr>
		<tr>
			<td><input type="button" value="수정"> </td>
			<td><input type="button" value="삭제"> </td>
			<td><input type="button" value="회원목록"> </td>
		</tr>
	</table>
</body>
</html>