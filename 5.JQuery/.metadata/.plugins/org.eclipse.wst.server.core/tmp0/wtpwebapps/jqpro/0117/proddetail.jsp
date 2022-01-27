<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<% 
   String prodId = request.getParameter("prodID");

   SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
   
   ProdVO vo = (ProdVO)client.queryForObject("prod.getDetailProd", prodId);

%>

   {
      "id" : "<%= vo.getProd_id() %>",
      "name" : "<%= vo.getProd_name() %>",
      "lgu" : "<%= vo.getProd_lgu() %>",
      "buyer" : "<%= vo.getProd_buyer() %>",
      "cost" : "<%= vo.getProd_cost() %>",
      "price" : "<%= vo.getProd_price() %>",
      "sale" : "<%= vo.getProd_sale() %>",
      "outline" : "<%= vo.getProd_outline() %>",
      "detail" : "<%= vo.getProd_detail() %>"
   }