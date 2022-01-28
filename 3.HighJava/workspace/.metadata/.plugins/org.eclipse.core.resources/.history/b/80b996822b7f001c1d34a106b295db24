<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet File Upload</title>

</head>
<body>
<h2>File Upload 연습</h2>
<!-- method와 enctype 필수 -->
<form method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/fileUploadServlet.do">
	ID : <input type="text" name="userid"><br><br>
	한 개 파일 선택 : <input type="file" name="upFile1"><br><br>
<!-- 	multiple에 따라서 한개또는 여러개 선택가능 -->
	여러 개 파일 선택 : <input type="file" name="upFile2" multiple><br><br>
	<button type="submit">전송</button>
</form>
<br><hr><br>
<a href="<%=request.getContextPath()%>/uploadedFileList.do">Upload된 전체 파일 목록 보기</a>
</body>
</html>