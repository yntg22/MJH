<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//요청시 전송 데이터 - id, name, addr
	String userId = request.getParameter("id");
	String userName = request.getParameter("name");
	String userAddr = request.getParameter("addr");
	
	//db연결 CRUD처리 - DB에 저장
	
	//결과를 가지고 응답데이터 생성 
	

%>
{

	"msg" : "<%= userName %>님 행복한 하루 되세요"

}