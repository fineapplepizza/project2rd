<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="euc-kr">
<title>Insert title here</title>
</head>
<body>

<% 
	//클릭한 해당 마크의 정보를 get방식으로 받아 나타내어줌
	String C_Name = request.getParameter("C_Name");
	String C_Tel =request.getParameter("C_Tel");
%>
<h2>name : <%=C_Name %></h2>
<h2>tel : <%=C_Tel %></h2>


</body>
</html>