<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//클라이언트 요청시 전송되는 데이터를 받아온다
	//DB 를  이용하는 CRUD 처리를 한다.
	//처리한 결과를 클라이언트로 응답한다.
	//응답타입은 json object 배열 로 한다

%>   
 
[
	{
		"name" : "홍길동",
		"addr" : "대전 중구",
		"tel" : "010-1234-5678"
	},
	
	{
		"name" : "일지매",
		"addr" : "대전 동구",
		"tel" : "010-5678-9012"
	},
	
	{
		"name" : "이순신",
		"addr" : "대전 서구",
		"tel" : "010-3456-7891"
	},
	
	{
		"name" : "무궁화",
		"addr" : "대전 유성구",
		"tel" : "010-7777-8888"
	}


]