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
				<form action="Joincon" method="post">
				<table class="join">
					<tr>
						<td align="right">���̵�</td>
						<td><input type="text" id="input_id" name="id" placeholder="���̵�" class="jointable">
										<br>
				 <input type="button" value="ID�ߺ�üũ"
              						 onclick="idCheck()" > <span id="sp"></span></td>
					</tr>
					<tr>
						<td align="right">�̸�</td>
						<td><input type="text" name="name" placeholder="�̸�" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">��й�ȣ</td>
						<td><input type="password" name="pw" placeholder="��й�ȣ" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">�̸���</td>
						<td><input type="text" name="email" placeholder="��ȭ��ȣ" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">��ȭ��ȣ</td>
						<td><input type="text" name="tel" placeholder="��ȭ��ȣ" class="jointable"></td>
					</tr>
					<tr>
						<td align="right">�ּ�</td>
						<td align="center">
							<select style="color:black;" name="address" class="input"
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
		
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>


			
	
	
	<script>
			function idCheck(){
				var input_id = document.getElementById("input_id");
				$.ajax({
					type : "post", //������ ���� ���
					data : {'id' : input_id.value}, //������ ���� ������
					url : "Idcheckcon", //������ ���� ���� ������
					dataType : "text", //������ Ÿ��
					//��û������ ������ �Լ� ���� ture / false
					success : function(data){
						var sp = document.getElementById("sp");
						if (data == "true"){
							sp.innerHTML = "�Ұ����� ID�Դϴ�.";
						}else{
							sp.innerHTML = "������ ID�Դϴ�.";
						}
						
					},
					error : function(){
						alert("���۽���");
						
					}	
				});
			}//��ǳ�
			</script>
</body>
</html>