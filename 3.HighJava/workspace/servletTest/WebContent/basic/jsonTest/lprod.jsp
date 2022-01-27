<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.basic.json.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
    	List<LprodVO> list = (List<LprodVO>)request.getAttribute("lvo");
    
    	Gson gson = new Gson();
    	String slist = gson.toJson(list);
    	
    	out.print(slist);
    %>