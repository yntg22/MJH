<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p{
	font-size: 2.0em;
}
h1{
	color : red;
}

</style>

</head>
<body>
<h1>JSP : Java Server Page</h1>
서버프로그램 : 서버내에서 실행되는 프로그램이다 <br>
html을 기본으로 하여 java언어를 사용할 수 있다 <br>

&lt;%  %> 기호 사이에 자바코드를 기술한다 <br>
&lt;%= %> 자바 변수를 출력 할때 사용 <br>

클라이언트가 전송시 입력데이터를 가져온다<br>
request객체를 이용하여 전달받는다<br>
<%
	request.setCharacterEncoding("UTF-8"); //post방식일때 이문장이있어야함
	String userId = request.getParameter("id");
	String userName = request.getParameter("name");
	int userNum = Integer.parseInt(request.getParameter("num"));
%>

<p>아이디 <%= userId %></p>
<p>이름 <%= userName %></p>
<p>번호 <%= userNum %></p>

</body>
</html>