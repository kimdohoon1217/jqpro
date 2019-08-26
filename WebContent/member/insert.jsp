<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String id = (String) request.getAttribute("mem");
	if(id != null){ //저장성공
%>		

	{
		"res" : "<%=id %>님 저장성공"
	}

<%	} else{ // 저장실패%>
		{
			"res" : "저장실패"
		}
<%
	}

%>
