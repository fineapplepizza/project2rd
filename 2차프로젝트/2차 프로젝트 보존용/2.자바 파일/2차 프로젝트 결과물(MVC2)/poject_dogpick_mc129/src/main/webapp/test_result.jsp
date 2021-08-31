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
String rank1 = request.getParameter("rank1");
String rank2 = request.getParameter("rank2");
String rank3 = request.getParameter("rank3");

%>

<%= rank1+rank2+rank3%>

</body>
</html>