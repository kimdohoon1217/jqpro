<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map> list = (List<Map>) request.getAttribute("gugun");

	if(list != null && list.size() > 0){
		//데이터 있는 경우 JSONObj배열
%>
	{
		"sw" : "OK",
		"data" : [ 
		<%
			for(int i = 0; i < list.size(); i++){
				if(i > 0) out.print(",");
		%>
			{
				"gugun" : "<%=list.get(i).get("GUGUN") %>"
			}
		<%		
			}
		%>
		]
	}		
	
<% 	
	}else{
%>
	{
		"sw" : "NO"
	}
	
<%
	}
%>