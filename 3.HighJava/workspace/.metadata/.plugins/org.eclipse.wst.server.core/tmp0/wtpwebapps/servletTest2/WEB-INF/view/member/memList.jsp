<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList</title>
<style>
body{
	text-align: center;
}
#td1{
	text-align: right;
}
</style>
<%

	List<MemberVO> list = (List<MemberVO>)request.getAttribute("memlist");
%>
</head>
<body>
	<h2>회원 목록 보기</h2>
	<table border="1" style="margin : 0 auto;">
		<tr><td id="td1" colspan="5"><input id="btn1" type="button" value="회원추가"></td> </tr>
		<tr>
			<td>ID</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>전화</td>
			<td>주소</td>
		</tr>
		<%
			for(MemberVO vo : list){
			
		%>
			<tr>
				<td><a href="<%=request.getContextPath() %>/memberInfo.do?memId=<%=vo.getMem_id()%>"><%=vo.getMem_id() %></a></td>
				<td><%=vo.getMem_pass() %></td>
				<td><%=vo.getMem_name() %></td>
				<td><%=vo.getMem_tel() %></td>
				<td><%=vo.getMem_addr() %></td>
			</tr>
		<%} %>

	</table>

</body>
</html>