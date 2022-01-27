<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//서블릿에서 저장된 id값을 꺼낸다.
	String id = (String)request.getAttribute("keyid");
	if(id != null){
%>
	{
	 "sw" : "사용불가능한 아이디 입니다."
	}
	
<%	}else{ %>
		
		{
		 "sw" : "사용가능한 아이디 입니다."
		}
	<%
	}
	%>