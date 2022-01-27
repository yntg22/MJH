<%@page import="kr.or.ddit.basic.json.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
	text-align: center;
}
</style>
<%
	
List<LprodVO> list = (List<LprodVO>)request.getAttribute("lprod");


%>
</head>
<body>
	<h2>동기방식 Lprod 목록 출력</h2>
	<table border="1" style="margin : 0 auto;">
		<tr>
			<td>Lprod_ID</td>
			<td>Lprod_GU</td>
			<td>Lprod_NM</td>
		</tr>
		<%
			for(LprodVO vo : list){
				
		%>	
			<tr>
				<td><%=vo.getLprod_id() %></td>
				<td><%=vo.getLprod_gu() %></td>
				<td><%=vo.getLprod_nm() %></td>
			</tr>
			
			<%} %>
	</table>
</body>
</html>