<%@page import="kr.or.ddit.member.vo.ZIpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
	List<ZIpVO> list = (List<ZIpVO>) request.getAttribute("list");
	
	for(int i = 0; i < list.size(); i++){
		ZIpVO zip = list.get(i);
		String bunji = zip.getBunji();
		if(bunji == null){
			bunji = "";
		}
		if(i > 0) out.print(",");
%>
	{
		"zipcode" : "<%=zip.getZipcode() %>",
		"addr" : "<%=zip.getSido() %><%=zip.getGugun() %><%=zip.getDong() %>",
		"bunji" : "<%=bunji%>"
	}
<%	
	}
%>
]