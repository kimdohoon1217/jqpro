<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
	List<Map> list = (List<Map>) request.getAttribute("list");

	for(int i = 0; i < list.size(); i++){
		if(i > 0) out.print(",");
%>
	{
		"dong" : "<%=list.get(i).get("DONG") %>"
	}

<% }%>	
]