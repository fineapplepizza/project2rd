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
			<h1 class="title_login"><a href="homePage.jsp">ȸ����������</a></h1>
		</div>
		<div class="inner">
				<form action="Updatecon" method="post">
				
				<table class="join">
					<tr >
						<td colspan="2" align="center">���� ID : <%= member.getId() %></td>
						
					</tr>
					<tr>
						<td align="right">��й�ȣ</td>
						<td><input type="password" id="input_id" name="newpw" placeholder="���ο� ��й�ȣ�� �Է��ϼ���" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">��ȭ��ȣ</td>
						<td><input type="text" id="input_id" name="newtel" placeholder="���ο� ��ȭ��ȣ�� �Է��ϼ���" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">�̸���</td>
						<td><input type="text" id="input_id" name="newemail" placeholder="���ο� �̸����� �Է��ϼ���" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">�ּ�</td>
						<td  align="center">
							<select style = "color:#b5b5b5;"  name="newaddress" class="input"
					style="width: 360px; height: 35px">
					<option value="gg">��⵵</option>
					<option value="gw">������</option>
					<option value="gss">��󳲵�</option>
					<option value="gsn">���ϵ�</option>
					<option value="jrn">����ϵ�</option>
					<option value="jrs">���󳲵�</option>
					<option value="ccn">��û�ϵ�</option>
					<option value="ccs">��û����</option>
				</select>
						</td>
					</tr>
					<tr>
						<td colspan=2><input type="submit" value="�����ϱ�" class="join_btn"></td>
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