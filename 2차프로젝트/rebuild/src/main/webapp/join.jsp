<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="style/css/main.css" />
<link rel="stylesheet" type="text/css" href="style/css/add.css" />
</head>
<body>
	<header id="header" class="alt_join">
		<div class="inner">
			<h1 class="title_login"><a href="homePage.jsp">ȸ������</a></h1>
		</div>
		<div class="inner">
			<form action="#">
				<table class="join">
					<tr>
						<td align="right">���̵�</td>
						<td><input type="text" name="id" placeholder="���̵�" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">��й�ȣ</td>
						<td><input type="password" name="pw" placeholder="��й�ȣ" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">�̸�</td>
						<td><input type="text" name="name" placeholder="�̸�" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">��ȭ��ȣ</td>
						<td><input type="text" name="tel" placeholder="��ȭ��ȣ" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">����</td>
						<td align="center">
							<input type="radio" name="male" value="M" class="jointable"><label>����</label>
							<input type="radio" name="female" value="F" class="jointable"><label>����</label>
						</td>
					</tr>
					<tr>
						<td colspan=2><input type="submit" value="�����ϱ�" class="join_btn"></td>
					</tr>
				</table>
			</form>
		</div>
	</header>
	<div>
		<input class="testradio" type="radio" name="1" value="1"><label>test</label>
	</div>
</body>
</html>