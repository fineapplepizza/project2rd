
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@page import="model.memberDTO"%>
<!DOCTYPE HTML>
<!--
	Epilogue by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Epilogue by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="style/css/main.css" />
		<link rel="stylesheet" href="style/css/add.css" />
		<link rel="stylesheet" href="style/css/introduce.css" />
	</head>
	
	<body>
			<%memberDTO member = (memberDTO)session.getAttribute("member");%>

	<nav style = "float:right;">
						<!-- �̸��� : admin -->
						<!-- admin(������ ����) : ȸ������,�α׾ƿ� -->
						<!-- �Ϲݰ��� : ��������, �α׾ƿ� -->
						
						<%if (member != null){%>
							<a style = "right: 0;" href="logout.jsp">�α׾ƿ�</a>
							<a style = "right: 0;" href="update.jsp">ȸ����������</a>
						<%}else{%>
							<a href="login.jsp">�α���</a>
						<%}%>
							<!-- �α��� �� Logout.jsp�� �̵��� �� �ִ�'�α׾ƿ�'��ũ�� '������������'��ũ�� ����Ͻÿ�. -->
						</nav>

						<br>
						
		<!-- Header -->
		<header id="header" class="alt">
			<div class="inner">
				<h1 class="title"><a href="introduce.jsp" style="text-decoration: none;">�߻�����</a></h1>
			</div>
				<nav class="menu_nav">
					<ul class="menu_nav_list">
						<li class="menu__item"><a href="introduce.jsp" class="menu__link">���� �Ұ�</a></li>
						
						<li class="menu__item"><a href="vote.jsp" id="vote_link" class="menu__link">�ݷ��� �����ϱ�</a></li>
						
						<li class="menu__item"><a href="dog.jsp" class="menu__link">�������</a></li>
						
						<li class="menu__item"><a href="foodindex.jsp" class="menu__link">�����õ</a></li>
							
						<li class="menu__item"><a href="center.jsp" class="menu__link">����ã��</a></li>
						
					</ul>
					
				</nav>
		</header>
		
		<!-- Wrapper -->
		<div id="wrapper">
	
			<div class="title_service">
				<h1>���� �Ұ�</h1>
			</div>
			
			<div>
				<img src="dog_img/intro.jpg">
			</div>
				<div>
					<p>
					�ų� ���������� �Ǵ� ������� ���� �����ϰ� �ִ� �߼��Դϴ�.<br>
					 ���Ⱑ �Ǵ� �ֵ� �����߿� ó�� �Ծ硤�о� ���� ���� �޸�<br>
					 Ű��� ���� ���� ���� �ʴ´ٴ� ������ �����޴� ��찡 ����մϴ�.
					</p>
				</div>
			<div>
				<img src="dog_img/intro2.jpg">
			</div>
				<div>
					<p>
						�̷��� ���ο��� ������ ����ߵ��� ����ö�忡�� ������ ��ٸ��ٰ�<br>
						 15���� ������ �ȶ��簡 ����˴ϴ�. 
					</p>
				</div>
					<div>
				<img src="dog_img/intro4.jpg">
			</div>
				<div>
					<p>
						����� ��Ī ���񽺴� <br>
						�ľ�Ǵ� ����ߵ��� ���̱�����<br>
					</p>
				</div>	
				<div>
					<span>
						<img src="dog_img/result_img.jpg">
						<p>���� ���ֵ��� �����͸� ������� �������縦 �ǽ��մϴ�.</p>
					</span>
					<span>
						<img src="dog_img/result_img2.jpg">
							<p>�������縦 ������ ������ �������<br>
								������ ����� ���� �˸´� ������ ��õ�ص帮��<br>
								�Ծ��� ���Ұ�� ����߼��Ϳ��� ������ ���͵帳�ϴ�. 
							</p>
					</span>
				</div>
			<!-- Banner -->
			
			<!-- Main -->
			<!--
				<section id="main" class="main">
					<header>
						<h2>Lorem ipsum dolor</h2>
					</header>
					<p>Fusce malesuada efficitur venenatis. Pellentesque tempor leo sed massa hendrerit hendrerit. In sed feugiat est, eu congue elit. Ut porta magna vel felis sodales vulputate. Donec faucibus dapibus lacus non ornare. Etiam eget neque id metus gravida tristique ac quis erat. Aenean quis aliquet sem. Ut ut elementum sem. Suspendisse eleifend ut est non dapibus. Nulla porta, neque quis pretium sagittis, tortor lacus elementum metus, in imperdiet ante lorem vitae ipsum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam eget neque id metus gravida tristique ac quis erat. Aenean quis aliquet sem. Ut ut elementum sem. Suspendisse eleifend ut est non dapibus. Nulla porta, neque quis pretium sagittis, tortor lacus elementum metus, in imperdiet ante lorem vitae ipsum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
				</section>
			-->

			<!-- Footer -->
				<footer id="footer">
					<ul class="icons">
						<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
						<li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
					</ul>
					<p class="copyright">&copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>. Images: <a href="https://unsplash.com">Unsplash</a>.</p>
				</footer>

		</div>

		<!-- Scripts -->
			<script src="js/jquery.min.js"></script>
			<script src="js/skel.min.js"></script>
			<script src="js/util.js"></script>
			<script src="js/main.js"></script>
			
			<script src="js/classie.js"></script>
			<script src="js/clipboard.min.js"></script>
			<script>
				(function() {
					[].slice.call(document.querySelectorAll('.menu')).forEach(
							function(menu) {
								var menuItems = menu.querySelectorAll('.menu__link'), setCurrent = function(ev) {
									ev.preventDefault();

									var item = ev.target.parentNode; // li

									// return if already current
									if (classie.has(item, 'menu__item--current')) {
										return false;
									}
									// remove current
									classie.remove(menu.querySelector('.menu__item--current'),'menu__item--current');
									// set current
									classie.add(item, 'menu__item--current');
								};

								[].slice.call(menuItems).forEach(function(el) {
									el.addEventListener('click', setCurrent);
								});
							});
		
					[].slice.call(document.querySelectorAll('.link-copy')).forEach(
							function(link) {
								link.setAttribute('data-clipboard-text',location.protocol + '//' + location.host
												+ location.pathname + '#'+ link.parentNode.id);
								new Clipboard(link);
								link.addEventListener('click', function() {
									classie.add(link, 'link-copy--animate');
									setTimeout(function() {
										classie.remove(link, 'link-copy--animate');
									}, 300);
								});
							});
				})(window);
			</script>
	</body>
</html>