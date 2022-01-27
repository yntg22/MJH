<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.join.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
    
    	Gson gson = new Gson();
    	String slist = gson.toJson(list);
    	
    	out.print(slist);
    %>
    
    <%-- 
    [
    	<%
    		for(int i=0; i<list.size(); i++){
    			MemberVO vo = list.get(i);
    			if(i>0)out.print(",");
    	%>
    		{
    			"id" : "<%=vo.getMem_id() %>",
    			"name" : "<%=vo.getMem_name() %>",
    			"mail" : "<%=vo.getMem_mail() %>"
    		}
    	<%		
    		}
    	%>
    ] 
    --%>