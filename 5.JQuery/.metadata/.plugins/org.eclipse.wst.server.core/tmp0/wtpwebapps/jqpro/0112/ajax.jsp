<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP : Java Server Page</h1>
<%
	request.setCharacterEncoding("utf-8");

	String sid = request.getParameter("id");
	String sname = request.getParameter("name");
	
	//DB연결 CRUD작업 처리
	//결과값을 출력
	
%>

아이디 : <%= sid %><br>
이름 : <%= sname %><br>

</body>
</html>