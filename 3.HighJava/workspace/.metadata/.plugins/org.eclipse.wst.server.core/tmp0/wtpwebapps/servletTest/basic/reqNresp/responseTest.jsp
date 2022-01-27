<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward, redirect 연습</title>
</head>
<body>
	<h2>문서이동(forward, sendRedirect) 연습</h2><hr>
	
	<form method="post" action="/servletTest/responseTest01.do">
		forward 연습 : <input type="text" name="username">
		<input type="submit" value="확인 ">
	</form>
	
	<br><hr><br>
	<form method="post" action="/servletTest/responseTest02.do">
		sendRedirect 연습 : <input type="text" name="username">
		<input type="submit" value="확 인">
	</form>
	
	
</body>
</html>