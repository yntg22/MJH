<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request연습 Form</title>
</head>
<body>


<!-- 
<form>태그의 속성
	1) action => 폼의 데이터를 받아서 처리할 문서명 또는 서블릿 URL
	2) method => 전송방식(get 또는 post) => (기본 : get )
	3) target => 응답이 나타날 프레임
	4) enctype => 서버로 파일을 전송할 때는 이 속성에 'multipart/form-data'로 지정해야 한다.
 -->
 

<%--
	이것은 JSP 주석을 나타낸다. 
--%> 

<%
	// 이영역은 JSP문서에서 Java명령을 사용할수 있는 영역을 '스트립트릿'이라고 한다.
	String name = "홍길동";
%>

<%--

<%=변수나 수식 %>	==> JSP에서 변수나 수식의 결과를 출력할 때 사용한다.

 --%>

<h2><%=name %>의 Request연습 Form <%=3+4 %></h2><hr>

<form action="/servletTest/requestTest01.do" method="post">
<table border="1">
<tr>
	<td>이름</td>
	<td><input type="text" size="10" name="username"></td>
</tr>
<tr>
	<td>직업</td>
	<td>
		<select name="job">
			<option value="무직">=무직=</option>
			<option value="회사원">=회사원=</option>
			<option value="전문직">=전문직=</option>
			<option value="학생">=학생=</option>
		</select>
	</td>
</tr>
<tr>
	<td>취미</td>
	<td>
		<input type="checkbox" name="hobby" value="여행">여행
		<input type="checkbox" name="hobby" value="독서">독서
		<input type="checkbox" name="hobby" value="게임">게임
		<input type="checkbox" name="hobby" value="배드민턴">배드민턴
	</td>
</tr>
<tr>
	<td colspan="2" style="text-align:center;">
		<input type="submit" value="전송">
		<input type="reset" value="취소">
	</td>
</tr>
	
</table>
</form>


</body>
</html>