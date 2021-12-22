<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p{
		font-size : 2.0em;
		text-align : center;
		margin : 10px;
		border : 1px solid pink;
	}
</style>
</head>
<body>
<h1>JSP : Java Server Page</h1>
<%
	int price = Integer.parseInt(request.getParameter("price"));	
	int qty = Integer.parseInt(request.getParameter("qty"));
	
	int res = price * qty;
%>

	<p>가격 : <%= price %></p>
	<p>수량 : <%= qty %></p>
	<p>총액 : <%= res %></p>
	
</body>
</html>