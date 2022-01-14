<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//클라이언트 요청시 전송데이터를 받는다. json, text, 배열
//	{"id" : "a001", "pass" : "12345678"} json
//	id=a001&pass=12345678 text

//DB와 연결하여 CRUD처리한다
//결과값으로 응답데이터를 생성한다. text, json, 배열, xml, html
%>

	<%-- res[i].id, res[i].name, res[i]addr, res[i].tel --%>
[
	{
	"id" : "a001",
	"name" : "고성식",
	"addr" : "대전 중구 오류동",
	"tel" : "010-1245-5478"
	},
	{
	"id" : "b001",
	"name" : "이유정",
	"addr" : "대전 서구 탄방동",
	"tel" : "010-1358-7854"
	},
	{
	"id" : "c001",
	"name" : "주창규",
	"addr" : "대전 대덕구 오정동",
	"tel" : "010-4567-8988"
	},
	{
	"id" : "d001",
	"name" : "민진홍",
	"addr" : "대전 동구 용전동",
	"tel" : "010-4575-3333"
	},
	{
	"id" : "e001",
	"name" : "김재웅",
	"addr" : "대전 유성구 유성동",
	"tel" : "010-0000-1111"
	}
]