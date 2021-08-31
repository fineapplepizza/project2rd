
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
						<!-- 이메일 : admin -->
						<!-- admin(관리자 계정) : 회원삭제,로그아웃 -->
						<!-- 일반계정 : 개인정보, 로그아웃 -->
						
						<%if (member != null){%>
							<a style = "right: 0;" href="logout.jsp">로그아웃</a>
							<a style = "right: 0;" href="update.jsp">회원정보수정</a>
						<%}else{%>
							<a href="login.jsp">로그인</a>
						<%}%>
							<!-- 로그인 후 Logout.jsp로 이동할 수 있는'로그아웃'링크와 '개인정보수정'링크를 출력하시오. -->
						</nav>

						<br>
						
		<!-- Header -->
		<header id="header" class="alt">
			<div class="inner">
				<h1 class="title"><a href="introduce.jsp" style="text-decoration: none;">견생연분</a></h1>
			</div>
				<nav class="menu_nav">
					<ul class="menu_nav_list">
						<li class="menu__item"><a href="introduce.jsp" class="menu__link">서비스 소개</a></li>
						
						<li class="menu__item"><a href="vote.jsp" id="vote_link" class="menu__link">반려견 맞이하기</a></li>
						
						<li class="menu__item"><a href="dog.jsp" class="menu__link">견종백과</a></li>
						
						<li class="menu__item"><a href="foodindex.jsp" class="menu__link">사료추천</a></li>
							
						<li class="menu__item"><a href="center.jsp" class="menu__link">센터찾기</a></li>
						
					</ul>
					
				</nav>
		</header>
		
		<!-- Wrapper -->
		<div id="wrapper">
	
			<div class="title_service">
				<h1>서비스 소개</h1>
			</div>
			
			<div>
				<img src="dog_img/intro.jpg">
			</div>
				<div>
					<p>
					매년 실종·유기 되는 유기견의 수는 증가하고 있는 추세입니다.<br>
					 유기가 되는 주된 이유중에 처음 입양·분양 받을 때와 달리<br>
					 키우다 보니 맘에 들지 않는다는 이유로 버림받는 경우가 빈번합니다.
					</p>
				</div>
			<div>
				<img src="dog_img/intro2.jpg">
			</div>
				<div>
					<p>
						이렇게 주인에게 잊혀진 유기견들은 좁은철장에서 가족을 기다리다가<br>
						 15일이 지나면 안락사가 진행됩니다. 
					</p>
				</div>
					<div>
				<img src="dog_img/intro4.jpg">
			</div>
				<div>
					<p>
						유기견 매칭 서비스는 <br>
						파양되는 유기견들을 줄이기위해<br>
					</p>
				</div>	
				<div>
					<span>
						<img src="dog_img/result_img.jpg">
						<p>과거 견주들의 데이터를 기반으로 설문조사를 실시합니다.</p>
					</span>
					<span>
						<img src="dog_img/result_img2.jpg">
							<p>설문조사를 진행한 데이터 기반으로<br>
								본인의 성향과 가장 알맞는 견종을 추천해드리며<br>
								입양을 원할경우 유기견센터와의 연결을 도와드립니다. 
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