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

	String cars[] = request.getParameterValues("cars2");
	
	String str="";
	for(String car : cars){
		str += car + " ";
	}
	
%>
<%=str%>
</body>
</html>