<%@page import="model.memberDTO"%>
<% memberDTO member = (memberDTO)session.getAttribute("member"); %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/css/main.css" />
<link rel="stylesheet" type="text/css" href="style/css/add.css" />
</head>
<body style="text-align: center;">

		<!-- Wrapper -->
			<header style = "height:900px;"id="header" class="alt_join">
				<div class="inner">
			<h1 class="title_login"><a href="homePage.jsp">회원정보수정</a></h1>
		</div>
		<div class="inner">
				<form action="Updatecon" method="post">
				
				<table class="join">
					<tr >
						<td colspan="2" align="center">현재 ID : <%= member.getId() %></td>
						
					</tr>
					<tr>
						<td align="right">비밀번호</td>
						<td><input type="password" id="input_id" name="newpw" placeholder="새로운 비밀번호를 입력하세요" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">전화번호</td>
						<td><input type="text" id="input_id" name="newtel" placeholder="새로운 전화번호를 입력하세요" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">이메일</td>
						<td><input type="text" id="input_id" name="newemail" placeholder="새로운 이메일을 입력하세요" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">주소</td>
						<td  align="center">
							<select style = "color:#b5b5b5;"  name="newaddress" class="input"
					style="width: 360px; height: 35px">
					<option value="gg">경기도</option>
					<option value="gw">강원도</option>
					<option value="gss">경상남도</option>
					<option value="gsn">경상북도</option>
					<option value="jrn">전라북도</option>
					<option value="jrs">전라남도</option>
					<option value="ccn">충청북도</option>
					<option value="ccs">충청남도</option>
				</select>
						</td>
					</tr>
					<tr>
						<td colspan=2><input type="submit" value="변경하기" class="join_btn"></td>
					</tr>
					
				</table>
			</form>
		</div>
			</header>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>