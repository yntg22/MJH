<%@page import="kr.or.ddit.join.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//서블릿에서 저장한 값을 꺼낸다.
	List<ZipVO> dong = (List<ZipVO>)request.getAttribute("list");	
%>

[
	<% for(int i=0; i<dong.size(); i++){
		ZipVO vo = dong.get(i);	
		
		String bunji = vo.getBunji();
		if(bunji == null) bunji = "";
		
		if(i > 0) out.print(",");
	%>
		{
			"zip" : "<%=vo.getZipcode()%>",
			"addr" : "<%=vo.getSido() %><%=vo.getGugun() %><%=vo.getDong() %>",
			"bunji" : "<%=bunji %>"
		}
	<%	
	}
	%>
]