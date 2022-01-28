<%@page import="kr.or.ddit.basic.fileupload.FileInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	// 서블릿에서 보내온 자료 받기
	String userId = (String)request.getAttribute("userID");
	List<FileInfoVO> fileList = 
			(List<FileInfoVO>)request.getAttribute("fileList");
%>

</head>
<body>
<%
	if(userId!=null){
%>
	<h2><%=userId %>님이 방금 업로드한 파일 목록</h2>
<%
}else{
%>
	<h2>업로드한 전체 파일 목록</h2>
<%
}
%>
<br><hr><br>
<table border="1">
<thead>
	<tr><th>파일 이름</th><th>파일 크기</th><th>업로드상태</th><th>비 고</th></tr>
</thead>
<tbody>
<%
	if(fileList!=null){
		for(FileInfoVO fvo : fileList){
%>
	<tr>
		<td><%=fvo.getFileName() %></td>
		<td><%=fvo.getFileSize() %>KB</td>
		<td><%=fvo.getUploadStatus() %></td>
		<td><a href="<%=request.getContextPath()%>/fileDownload.do?filename=<%=fvo.getFileName()%>">DownLoad</a></td>
	</tr>
<%
		}
	}
%>
</tbody>
</table>
<br><hr><br>
<a href="<%=request.getContextPath()%>/basic/fileupload/fileupload.jsp"></a>




</body>
</html>