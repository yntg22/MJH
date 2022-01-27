<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- test.jsp<br><br>

<a href = "../tttt/mypage.jsp">mypage로 가기(상대주소)</a>
<a href = "/servletTest/tttt/mypage.jsp">mypage로 가기(절대주소)</a>
<a href = "<%=request.getContextPath()%>/tttt/mypage.jsp">mypage로 가기(절대주소)</a>
 --%>
 
 <h1>Servlet 요청 연습</h1><hr>
 
 <h2>GET방식 요청1 ==> 링크 방식</h2>
 <a href="http://localhost/servletTest/servletTest03.do">GET방식 요청1</a>
 <hr>
 
 <h2>GET방식 요청2 ==> Form태그의 submit방식</h2>
 	 ==> form태그의 method속성을 생략하거나 'GET'으로 설정한 경우</h2>
 	 <form action="http://localhost/servletTest/servletTest03.do" method="get">
 	 	<input type="submit" value="GET방식 요청2"> 	 
 	 </form>
 	 <br><br><br>
 	 
 	 <h2>POST방식 요청 ==> Form태그의 submit방식<br>
      ==> form태그의 method속성값을 'POST'로 설정한 경우</h2>
   <form action="http://localhost/servletTest/servletTest03.do" method="post">
      <input type="submit" value="POST방식 요청">
   </form>
   <br><hr><br>
</body>
</html>