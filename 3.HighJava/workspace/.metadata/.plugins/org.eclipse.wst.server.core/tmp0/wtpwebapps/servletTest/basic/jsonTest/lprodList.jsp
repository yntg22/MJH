<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- rqeust.getContextPath() ==> /WebContent -->
<script src="<%=request.getContextPath()%>/basic/js/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$('#btn1').on('click',function(){
		$.ajax({
			url : '/servletTest/lprodListServlet.do',
			method : 'get',
			dataType : 'json',
			success : function(res){
				code = "<table>";
				code += "<tr><td>LPROD_ID</td>  ";
				code += "<td>LPROD_GU</td>        ";
				code += "<td>LPROD_NM</td></tr>";
				$.each(res, function(i,v){
					code +="<tr><td>"+ v.lprod_id+"</td>";
					code +="<td>" +v.lprod_gu+"</td>";
					code +="<td>"+v.lprod_nm+"</tr>";
				})
				code += "</table>";
				$('#result1').html(code);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
				
			}
		})
	})
	
	$('#btn2').on('click', function(){
		location.href = "<%=request.getContextPath()%>/lprodListNonAjaxServlet.do";
	})
})
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
	
</head>
<body>
	<input type="button" id="btn1" value="Lprod자료 비동기 가져오기 ajax">
	<input type="button" id="btn2" value="Lprod자료 동기 가져오기 nonajax" >
	<h2>Lprod 자료 목록 <%=request.getContextPath() %></h2>
	<div id="result1"></div>
</body>
</html>