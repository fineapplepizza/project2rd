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
	<!-- Header -->
	<header id="header" class="alt_login">
		<div class="inner">
			<h1 class="title_login"><a href="homePage.jsp" style="text-decoration: none;">�α���</a></h1>
		</div><br>
		<div class="inner">
			<form action="Logincon">
			<fieldset>
				<input type="text" placeholder="���̵�" name="id" class="input"><br>
				<input type="password" placeholder="��й�ȣ" name="pw" class="input">	<br>
				<div class="btn_login">
					<input type="submit" class="input_btn" value="�α���">
					<a href="join.jsp"><input type="button" class="input_btn" value="ȸ������"></a>
				</div>
			</fieldset>
		</form>
		</div>
	</header>

	
</body>
</html>