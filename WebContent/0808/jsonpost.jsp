<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//post할땐 별도로 jsp에서 인코딩을 설정해줘야한다.
		request.setCharacterEncoding("UTF-8");
	
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
	
	%>


	<%=name %>님의 전화번호는  <%=tel %>입니다.
	<h4>지옥의하루</h4>
</body>
</html>