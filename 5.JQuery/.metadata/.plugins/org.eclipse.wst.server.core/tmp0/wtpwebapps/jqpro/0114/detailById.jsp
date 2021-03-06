<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="kr.or.ddit.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//클라이언트 요청시 전송데이터를 받는다. json, text, 배열
//{"id" : "a001", "pass" : "12345678"} json
//id=a001&pass=12345678 text

//DB와 연결하여 CRUD처리한다
//결과값으로 응답데이터를 생성한다. text, json, 배열, xml, html
%>
<%
	String buyerId = request.getParameter("id");
	
	SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
	
	BuyerVO vo = (BuyerVO)client.queryForObject("buyer.getBuyerId", buyerId);

%>
{
	"id" : "<%=vo.getBuyer_id()%>",
	"name" : "<%=vo.getBuyer_name() %>",
	"add1" : "<%=vo.getBuyer_add1() %>",
	"add2" : "<%=vo.getBuyer_add2() %>",
	"bank" : "<%=vo.getBuyer_bank() %>",
	"bankname" : "<%=vo.getBuyer_bankname() %>",
	"bankno" : "<%=vo.getBuyer_bankno() %>",
	"lgu" : "<%=vo.getBuyer_lgu() %>",
	"mail" : "<%=vo.getBuyer_mail() %>",
	"zip" : "<%=vo.getBuyer_zip() %>"
	
}