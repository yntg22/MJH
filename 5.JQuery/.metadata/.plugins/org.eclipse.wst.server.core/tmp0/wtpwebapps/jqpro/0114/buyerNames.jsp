<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.config.SqlMapClientFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
//1.클라이언트 요청시 전송데이터를 받는다. json, text, 배열
//{"id" : "a001", "pass" : "12345678"} json
//id=a001&pass=12345678 text

//DB와 연결하여 CRUD처리한다 - ibatis
//결과값으로 응답데이터를 생성한다. text, json, 배열, xml, html

//2. SqlMapClient객체를 얻어온다
SqlMapClient client = SqlMapClientFactory.getSqlMapClient();

//3. 실행
List<BuyerVO> list = client.queryForList("buyer.getAllBuyer");


%>

[
	<%
		for(int i=0; i<list.size(); i++){
			BuyerVO vo = list.get(i);
			if(i > 0) out.print(",");
	%>
		{
			"id" : "<%=vo.getBuyer_id()%>",
			"name" : "<%=vo.getBuyer_name()%>"
		}
		<%
		}
		%>
]