<%@page import="java.util.LinkedHashMap"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
<%
	String message = (String) session.getAttribute("message");
	if (StringUtils.isNotBlank(message)) {
%>
<script type="text/javascript">
	alert("${message}");
</script>
<%
	}
%>
</head>
<body>
<jsp:useBean id="member" class="kr.or.ddit.vo.MemberVO" scope="request"/>
<jsp:useBean id="errors" class="java.util.LinkedHashMap" scope="request"/>

	<form method="post">
		<table class="table table-bordered">
			<tr>
				<th>회원아이디</th>
				<td><input class="form-control" required type="text"
					name="memId" value="<%=member.getMemId()%>" /><span><%=errors.get("memId")%></span></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input class="form-control" required type="text"
					name="memPass" value="<%=member.getMemPass()%>" /><span><%=errors.get("memPass")%></span></td>
			</tr>
			<tr>
				<th>회원명</th>
				<td><input class="form-control" required type="text"
					name="memName" value="<%=member.getMemName()%>" /><span><%=errors.get("memName")%></span></td>
			</tr>
			<tr>
				<th>주민번호1</th>
				<td><input class="form-control" type="text" name="memRegno1"
					value="<%=member.getMemRegno1()%>" /><span><%=errors.get("memRegno1")%></span></td>
			</tr>
			<tr>
				<th>주민번호2</th>
				<td><input class="form-control" type="text" name="memRegno2"
					value="<%=member.getMemRegno2()%>" /><span><%=errors.get("memRegno2")%></span></td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input class="form-control" type="date" name="memBir"
					value="<%=member.getMemBir()%>" /><span><%=errors.get("memBir")%></span></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input class="form-control" required type="text"
					name="memZip" value="<%=member.getMemZip()%>" /><span><%=errors.get("memZip")%></span></td>
			</tr>
			<tr>
				<th>주소1</th>
				<td><input class="form-control" required type="text"
					name="memAdd1" value="<%=member.getMemAdd1()%>" /><span><%=errors.get("memAdd1")%></span></td>
			</tr>
			<tr>
				<th>주소2</th>
				<td><input class="form-control" type="text" name="memAdd2"
					value="<%=member.getMemAdd2()%>" /><span><%=errors.get("memAdd2")%></span></td>
			</tr>
			<tr>
				<th>집전번</th>
				<td><input class="form-control" type="text" name="memHometel"
					value="<%=member.getMemHometel()%>" /><span><%=errors.get("memHometel")%></span></td>
			</tr>
			<tr>
				<th>회사전번</th>
				<td><input class="form-control" type="text" name="memComtel"
					value="<%=member.getMemComtel()%>" /><span><%=errors.get("memComtel")%></span></td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td><input class="form-control" type="text" name="memHp"
					value="<%=member.getMemHp()%>" /><span><%=errors.get("memHp")%></span></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input class="form-control" type="text" name="memMail"
					value="<%=member.getMemMail()%>" /><span><%=errors.get("memMail")%></span></td>
			</tr>
			<tr>
				<th>직업</th>
				<td><input class="form-control" type="text" name="memJob"
					value="<%=member.getMemJob()%>" /><span><%=errors.get("memJob")%></span></td>
			</tr>
			<tr>
				<th>취미</th>
				<td><input class="form-control" type="text" name="memLike"
					value="<%=member.getMemLike()%>" /><span><%=errors.get("memLike")%></span></td>
			</tr>
			<tr>
				<th>기념일</th>
				<td><input class="form-control" type="text" name="memMemorial"
					value="<%=member.getMemMemorial()%>" /><span><%=errors.get("memMemorial")%></span></td>
			</tr>
			<tr>
				<th>기념일자</th>
				<td><input class="form-control" type="date"
					name="memMemorialday" value="<%=member.getMemMemorialday()%>" /><span><%=errors.get("memMemorialday")%></span></td>
			</tr>
			<tr>
				<th>마일리지</th>
				<td><input class="form-control" type="number" name="memMileage"
					value="<%=member.getMemMileage()%>" /><span><%=errors.get("memMileage")%></span></td>
			</tr>
			<tr>
				<th>탈퇴여부</th>
				<td><input class="form-control" type="text" name="memDelete"
					value="<%=member.getMemDelete()%>" /><span><%=errors.get("memDelete")%></span></td>
			</tr>
			 <tr>
            <td colspan="2"><input type="submit" value="저장" /> <input
               type="reset" value="취소" /></td>
        	 </tr>
			
		</table>
	</form>
	<jsp:include page="/includee/postScript.jsp" />
</body>
</html>