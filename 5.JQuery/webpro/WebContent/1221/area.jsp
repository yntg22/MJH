<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table{
	border : 1px solid blue;
	margin : 20px auto; /*위아래 20px 양옆은 자동*/
}

td{
	width : 200px;
	height : 200px;
	padding : 10px;
}

#cont{
	width : 500px;
}

	
</style>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String content = request.getParameter("area");
	
	//content에는 엔터(\r\n)가 포함
	
	String cont = content.replaceAll("\r", "")
						 .replaceAll("\n","<br>");
	
%>

<table border="1">
	<tr>
		<td><%=name%></td>
		<td id="cont"><%=cont%></td>
	</tr>
</table>
</body>
</html>