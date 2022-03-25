<%@page import="kr.or.ddit.vo.PagingVO"%>
<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
</head>
<body>
<!-- model name : prodList -->
<!-- 상품 분류별로 정렬하되, 최근 등록 상품이 먼저 조회됨. -->
<table class="table table-bordered">
   <thead>
      <tr>
         <th>일련번호</th>
         <th>상품코드</th>
         <th>상품명</th>
         <th>분류명</th>
         <th>거래처명</th>
         <th>총구매자수</th>
      </tr>
   </thead>
   <tbody>
      <%
      	PagingVO<ProdVO> paging = (PagingVO)request.getAttribute("paging");  
      	List<ProdVO> prodList = paging.getDataList();

         if(prodList.isEmpty()){
            %>
            <tr>
               <td colspan="5">조건에 맞는 상품이 없음</td>
            </tr>
            <%
         }else{
            for(ProdVO prod:prodList){
            	String viewURL = request.getContextPath()
						+"/prod/prodView.do?what="
						+prod.getProdId();
               %>
               <tr class="linkBtn" data-href="<%=viewURL%>">
                  <td><%=prod.getRnum() %></td>
                  <td><%=prod.getProdId() %></td>
                  <td><%=prod.getProdName() %></td>
                  <td><%=prod.getLprodNm() %></td>
                  <td><%=prod.getBuyer().getBuyerName() %></td>
                  <td><%=prod.getMemCnt() %></td>
               </tr>
               <%
            }
         }
      %>
   </tbody>
   <tfoot>
   		<tr>
   			<td colspan="6">
   				
                  <%=paging.getPagingHTMLBS()%>
                  <div id="searchDIV">
                  <select name="searchType">
                 	<option value>전체</option> 
                  	<option value="LGU">상품분류코드</option> 
                  	<option value="BUYER">거래처코드</option> 
                  	<option value="NAME">상품명</option> 
                  </select>
                  <input type="text" name="searchWord" />
                  <input type="button" value="검색" id="searchBtn"/>
                  </div>
               </td>
   		</tr>
   </tfoot>
</table>
<form id="searchForm">
	<input type="text" name="page"/>
	<input type="text" name="searchType"/>
	<input type="text" name="searchWord"/>
</form>
<script type="text/javascript">
	let searchForm = $("#searchForm");
	let searchDIV = $("#searchDIV");
	
	$("[name=searchType]").val("${paging.simpleCondition.searchType}");
	$("[name=searchWord]").val("${paging.simpleCondition.searchWord}");
	$(".pagination").on("click", "a", function(){
		let page = $(this).data("page");
		searchForm.find("[name=page]").val(page);
		searchForm.submit();
	});
	$("#searchBtn").on("click", function(){
		let inputs = searchDIV.find("[name]");
		$(inputs).each(function(index, ipt){
// 			console.log(this.name)
			let name = this.name;
			let value = $(this).val();
			searchForm.find("[name="+name+"]").val(value);
		});
		searchForm.submit();
	});
</script>
<jsp:include page="/includee/postScript.jsp" />
</body>
</html>