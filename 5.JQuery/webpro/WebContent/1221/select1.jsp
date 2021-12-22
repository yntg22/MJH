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
	request.setCharacterEncoding("UTF-8");
	String cars = request.getParameter("cars1");
	
%>
	<p>선택한 차량은 <%=cars%>입니다</p>
</body>
</html>