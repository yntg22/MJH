<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	h1{
		border : 1px solid pink;
		margin-left : 20%;
		width : 50%;
	}

	table{
		border : 2px solid orange;
		border-collapse : collapse;
		margin-left : 20%;
	}
	
	td{
		width : 150px;
		heigth : 50px;
		text-align : center;
	}
</style>

</head>
<body>
<h1>JSP : Java Server Page</h1>
<%
	request.setCharacterEncoding("UTF-8");

	String userId = request.getParameter("id");
	
	String userPass = request.getParameter("pass");
	
	String gender = request.getParameter("gender");
	
	String foods[] = request.getParameterValues("like");
	
	String str = "";
	for(int i = 0; i < foods.length; i++){
		str += foods[i] + "&nbsp;&nbsp;&nbsp;"; /*&nbsp 공백*/
	}
	
	String file = request.getParameter("file");
	
	String age = request.getParameter("age");
	
%>

<table border="1">
 <tr>
 	<td>아이디</td>
 	<td><%=userId%></td>
 </tr>	
 	
 <tr>
 	<td>비밀번호</td>
 	<td><%=userPass%></td>
 </tr>	
 
 <tr>
 	<td>성별</td>
 	<td><%=gender%></td>
 </tr>	
 
 <tr>
 	<td>좋아하는것</td>
 	<td><%=str%></td>
 </tr>	
 
 <tr>
 	<td>첨부파일</td>
 	<td><%=file%></td>
 </tr>	
 
 <tr>
 	<td>나이</td>
 	<td><%=age%></td>
 </tr>	
 
 
</table>



</body>
</html>