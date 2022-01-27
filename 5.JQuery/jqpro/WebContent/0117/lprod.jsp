<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
<%
	
	SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
	
	List<LprodVO> list = client.queryForList("lprod.selectLprod");
	
	

%>
[
	<%
		for(int i=0; i<list.size(); i++){
			LprodVO vo = list.get(i);
			if(i > 0) out.print(",");
	%>
		{
			"gu" : "<%= vo.getLprod_gu() %>",
			"nm" : "<%= vo.getLprod_nm() %>"
		}
	
	<% 		
		}
	%>
]