<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProdVO prod = (ProdVO)request.getAttribute("prod_id");
%>
{
	"id" : "<%=prod.getProd_id() %>",
	"name" : "<%=prod.getProd_name() %>",
	"lgu" : "<%=prod.getProd_lgu() %>",
	"sale" : "<%=prod.getProd_sale() %>",
	"price" : "<%=prod.getProd_price() %>",
	"outline" : "<%=prod.getProd_outline() %>",
	"detail" : "<%=prod.getProd_detail() %>"
}