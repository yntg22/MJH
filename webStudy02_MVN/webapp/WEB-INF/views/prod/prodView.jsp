<%@page import="kr.or.ddit.vo.BuyerVO"%>
<%@page import="java.util.Set"%>
<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="prod" class="kr.or.ddit.vo.ProdVO" scope="request"/>
<table>
	<tr>
		<th>거래처 정보</th>
		<td>
			<table>
				<thead>
					<tr>
						<th>거래처 코드</th>
						<th>거래처명</th>
						<th>거래처 주소</th>
						<th>연락처</th>
						<th>거래품목수</th>
					</tr>
				</thead>
				<tbody>
				<%
					String viewURL = request.getContextPath()
									+"/buyer/buyerView.do?what="
									+prod.getBuyer().getBuyerId();
				%>
					<tr class="linkBtn" data-href="<%=viewURL%>">
						<td><%=prod.getBuyer().getBuyerId() %></td>
						<td><%=prod.getBuyer().getBuyerName() %></td>
						<td><%=prod.getBuyer().getBuyerAdd1()%></td>
						<td><%=prod.getBuyer().getBuyerComtel() %></td>
						<td><%=prod.getBuyer().getProdCnt() %></td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>
	<tr><th>상품코드</th><td><%=prod.getProdId()%></td><tr>
   <tr><th>상품명</th><td><%=prod.getProdName()%></td><tr>
   <tr><th>상품분류코드</th><td><%=prod.getProdLgu()%></td><tr>
   <tr><th>거래처코드</th><td><%=prod.getProdBuyer()%></td><tr>
   <tr><th>구매가</th><td><%=prod.getProdCost()%></td><tr>
   <tr><th>판매가</th><td><%=prod.getProdPrice()%></td><tr>
   <tr><th>할인가</th><td><%=prod.getProdSale()%></td><tr>
   <tr><th>아웃라인</th><td><%=prod.getProdOutline()%></td><tr>
   <tr><th>상품설명</th><td><%=prod.getProdDetail()%></td><tr>
   <tr><th>상품이미지</th><td><%=prod.getProdImg()%></td><tr>
   <tr><th>상품재고</th><td><%=prod.getProdTotalstock()%></td><tr>
   <tr><th>입고일자</th><td><%=prod.getProdInsdate()%></td><tr>
   <tr><th>재고</th><td><%=prod.getProdProperstock()%></td><tr>
   <tr><th>상품크기</th><td><%=prod.getProdSize()%></td><tr>
   <tr><th>상품색상</th><td><%=prod.getProdColor()%></td><tr>
   <tr><th>배송</th><td><%=prod.getProdDelivery()%></td><tr>
   <tr><th>유닛</th><td><%=prod.getProdUnit()%></td><tr>
   <tr><th>수량인</th><td><%=prod.getProdQtyin()%></td><tr>
   <tr><th>수량세일</th><td><%=prod.getProdQtysale()%></td><tr>
   <tr><th>마일리지</th><td><%=prod.getProdMileage()%></td><tr>
</table>
</body>
</html>