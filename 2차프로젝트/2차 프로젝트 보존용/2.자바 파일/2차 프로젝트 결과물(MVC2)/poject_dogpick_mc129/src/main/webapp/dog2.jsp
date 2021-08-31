<%@page import="model.dogDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dogDTO"%>
<%@page import="model.memberDTO"%>
<%@page import="model.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

	<!-- dogDTO정보가져오기 -->
<%dogDTO dog = (dogDTO)session.getAttribute("dog"); %>
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
		<link rel="stylesheet" href="style/css/mainDae.css" />
		<link rel="stylesheet" href="style/css/addDae.css" />
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
		<%
		  //dogDAO에 있는 기능 호출
		  dogDAO dao = new dogDAO();
		  ArrayList<dogDTO> list = (ArrayList<dogDTO>)session.getAttribute("list");
		  /* pageContext.setAttribute("dog_list", list); */
		%>

			<!-- Banner -->
			<form action=  "search" method="post">
			<section class="searchbox">
			
				<div>
					<select name = "dogSize" onchange="myFunction(this.value)">
						
						<option value="all">전체</option>
						<option value="small" >소형견</option>
						<option value="medium">중형견</option>
						<option value="large">대형견</option>
						
					</select>
				</div>
				<input name = "dogName" type="search">
				<input type="submit" id="btn_search" value="검색">
				
				<br>
			</section>
			</form>
		
			<!-- Items -->
			<section class="searchlist">
			<%for (int i = 0; i < list.size(); i++) {%>
				<%if (list.get(i).getSize().equals("소형견")) {%>
				<article style="display: flex;" class="small">
					<div class="img_dog">
						<img src="dog_img/<%=list.get(i).getDogName()%>.jpg">
					</div>
					<table class="searchlist_table">
	
	
						<tr style="visibility: visible" >
							<td class="td1">견종</td>
							<td class="td2"><%=list.get(i).getDogName()%></td>
						</tr>
						<tr>
							<td class="td1">크기:</td>
							<td class="td2"><%=list.get(i).getSize()%></td>
						</tr>
						<tr>
							<td class="td1">체중:</td>
							<td class="td2"><%=list.get(i).getWeight()%></td>
						</tr>
						<tr>
							<td class="td1">주요질병:</td>
							<td class="td2"><%=list.get(i).getSick()%></td>
						</tr>
						<tr>
							<td class="td1">특징:</td>
							<td class="td2"><%=list.get(i).getChr()%></td>
						</tr>
	
					</table>
				</article>
				<%} else if (list.get(i).getSize().equals("중형견")) {%>
				<article style="display: flex;" class="medium">
					<div class="img_dog">
						<img src="dog_img/<%=list.get(i).getDogName()%>.jpg">
					</div>
					<table class="searchlist_table">
						<tr style="visibility: visible" >
							<td class="td1">견종</td>
							<td class="td2"><%=list.get(i).getDogName()%></td>
						</tr>
						<tr>
							<td class="td1">크기:</td>
							<td class="td2"> <%=list.get(i).getSize()%></td>
						</tr>
						<tr>
							<td class="td1">체중:</td>
							<td class="td2"><%=list.get(i).getWeight()%></td>
						</tr>
						<tr>
							<td class="td1">주요질병:</td>
							<td class="td2"><%=list.get(i).getSick()%></td>
						</tr>
						<tr>
							<td class="td1">특징:</td>
							<td class="td2"><%=list.get(i).getChr()%></td>
						</tr>
					</table>
				</article>
				<%} else {%>
				<article style="display: flex;" class="large">
					<div class="img_dog">
						<img src="dog_img/<%=list.get(i).getDogName()%>.jpg">
					</div>
					<table class="searchlist_table">
						<tr style="visibility: visible">
							<td class="td1">견종</td>
							<td class="td2"><%=list.get(i).getDogName()%></td>
						</tr>
						<tr>
							<td class="td1">크기:</td>
							<td class="td2"><%=list.get(i).getSize()%></td>
						</tr>
						<tr>
							<td class="td1">체중:</td>
							<td class="td2"><%=list.get(i).getWeight()%></td>
						</tr>
						<tr>
							<td class="td1">주요질병:</td>
							<td class="td2"><%=list.get(i).getSick()%></td>
						</tr>
						<tr>
							<td class="td1">특징:</td>
							<td class="td2"><%=list.get(i).getChr()%></td>
						</tr>
					</table>
				</article>
				<%}%>
			<%} %>

			<!-- <tr>
							<td>견종</td>
							<td>웰시코기</td>
						</tr>
						<tr>
							<td>특성1</td>
							<td>10</td>
						</tr>
						<tr>
							<td>특성2</td>
							<td>10</td>
						</tr>
						<tr>
							<td>특성3</td>
							<td>10</td>
						</tr>
						<tr>
							<td>특성4</td>
							<td>10</td>
						</tr> -->
				
				
			</section>
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
			<script src="style/js/jquery.min.js"></script>
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
			<script>
			function myFunction(str) {
				
				let trArray = document.querySelectorAll('.searchlist article');
				
				for(let i=0; i<trArray.length; i++){
					//console.log(trArray[i].getAttribute('class'));
					
					let classNm = trArray[i].getAttribute('class');
					
					if(str === "all"){
						trArray[i].style.display = 'flex';
					}else{
						if(classNm === str){
							trArray[i].style.display = 'flex';
						}else{
							trArray[i].style.display = 'none';
						}
						
					}
					
				
				}
				
				
				/* let searchlist_table_tbody = document.querySelector('.searchlist_table > tbody');
				let dog_list = '<c:out value="${dog_list}"/>';
				let dog_array = [];				
				
				<c:forEach items="${dog_list}" var="dog">
					dog_array.push({
						dogName:"${dog.dogName}",
						size:"${dog.size}",
						weight:"${dog.weight}",
						sick:"${dog.sick}",
						chr:"${dog.chr}"
					});
				</c:forEach>
				
				console.log(dog_array);
			
				
				for(let i=0; i<dog_array.length; i++){
					if(dog_array[i].size === str){
						console.log(dog_array[i].size);
					}
				} */
				
				/* alert(str);
				alert($(".size").text());
				if(str == $("span").attr('class')){
					
					$("tr").css("visibility","visible");
				}
 */				//for(int i)

				//if(str == $(".size").text()){
					
					//$(this).html("find");
					//$("tr").css("visibility","visible");
				//}else{
					//$("tr").css("visibility","hidden");
					//alert("not find");
				//}

			}
			

			    
			</script>
	</body>
</html>