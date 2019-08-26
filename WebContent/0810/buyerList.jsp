<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<Map> nameList = (List<Map>) request.getAttribute("list");
%>
[
<%
		for(int i = 0; i < nameList.size(); i++){
			
			if(i > 0) out.print(",");
%>
		{
			"id" : "<%=nameList.get(i).get("BUYER_ID") %>",
			"name" : "<%=nameList.get(i).get("BUYER_NAME")%>",
			"lgu" : "<%=nameList.get(i).get("BUYER_LGU")%>",
			"bank" : "<%=nameList.get(i).get("BUYER_BANK")%>",
			"bankNo" : "<%=nameList.get(i).get("BUYER_BANKNO")%>",
			"bankName" : "<%=nameList.get(i).get("BUYER_BANKNAME")%>",
			"zip" : "<%=nameList.get(i).get("BUYER_ZIP")%>",
			"addr" : "<%=nameList.get(i).get("BUYER_ADD1")%> + <%=nameList.get(i).get("BUYER_ADD2")%>",
			"comtel" : "<%=nameList.get(i).get("BUYER_COMTEL")%>",
			"fax" : "<%=nameList.get(i).get("BUYER_FAX")%>",
			"mail" : "<%=nameList.get(i).get("BUYER_MAIL")%>",
			"charger" : "<%=nameList.get(i).get("BUYER_CHARGER")%>",
			"telext" : "<%=nameList.get(i).get("BUYER_TELEXT")%>"
		}
<%} %>
]