<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border : 1px solid green;
	margin : 20px auto;
}

td{
	width : 150px;
	height : 50px;
	text-align: center;
	font-size: 1.4em;
}
</style>


</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String sid = request.getParameter("id");
	String sname = request.getParameter("name");
	String stel = request.getParameter("tel");
	
	//db와 연결하는 작업(crud)
	//crud처리후 결과를 가지고 응답 데이터를 생성
	
%>

<table border="1">
	<tr>
		<td>아이디</td>
		<td><%=sid%></td>		
	</tr>
	
	<tr>
		<td>이름</td>
		<td><%=sname%></td>		
	</tr>
	
	<tr>
		<td>아이디</td>
		<td><%=stel%></td>		
	</tr>

</table>
</body>
</html>