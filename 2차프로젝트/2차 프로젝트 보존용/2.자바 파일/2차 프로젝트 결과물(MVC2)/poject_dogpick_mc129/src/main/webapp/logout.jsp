<%@page import="model.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
	
		//���ǹ��
		session.invalidate();
		memberDTO member = null;
		response.sendRedirect("introduce.jsp");
		
		
	%>



</body>
</html>