<%@page import="model.dogDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dogDTO"%>
<%@page import="model.memberDTO"%>
<%@page import="model.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

	<!-- dogDTO������������ -->
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
		<%
		  //dogDAO�� �ִ� ��� ȣ��
		  dogDAO dao = new dogDAO();
		  ArrayList<dogDTO> list = dao.dogSelect();
		
		
		
		  
		  pageContext.setAttribute("dog_list", list);
		%>

			<!-- Banner -->
			<form action="search" method="post">
			<section class="searchbox">
			
				<div>
					<select class="dogsize" name= "dogSize" onchange="myFunction(this.value)">
						
						<option value="all">��ü</option>
						<option value="small" >������</option>
						<option value="medium">������</option>
						<option value="large">������</option>
						
					</select>
				</div>
				<input name = "dogName" type="search" id="search">
				<input type="submit" id="btn_search" value="�˻�">
				
				<br>
			</section>
			</form>
			
			<!-- Items -->
			<section class="searchlist">
			<%for (int i = 0; i < list.size(); i++) {%>
				<%if (list.get(i).getSize().equals("������")) {%>
				<article style="display: flex;" class="small">
					<div class="img_dog">
						<img src="dog_img/<%=list.get(i).getDogName()%>.jpg">
					</div>
					<table class="searchlist_table">
	
	
						<tr style="visibility: visible" >
							<td class="td1">����:</td>
							<td class="td2"><%=list.get(i).getDogName()%></td>
						</tr>
						<tr>
							<td class="td1">ũ��:</td>
							<td class="td2"><%=list.get(i).getSize()%></td>
						</tr>
						<tr>
							<td class="td1"> ü��:</td>
							<td class="td2"><%=list.get(i).getWeight()%></td>
						</tr>
						<tr>
							<td class="td1">�ֿ�����:</td>
							<td class="td2"><%=list.get(i).getSick()%></td>
						</tr>
						<tr>
							<td class="td1">Ư¡:</td>
							<td class="td2"><%=list.get(i).getChr()%></td>
						</tr>
	
					</table>
				</article>
				<%} else if (list.get(i).getSize().equals("������")) {%>
				<article style="display: flex;" class="medium">
					<div class="img_dog">
						<img src="dog_img/<%=list.get(i).getDogName()%>.jpg">
					</div>
					<table class="searchlist_table">
						<tr style="visibility: visible" >
							<td class="td1">����:</td>
							<td class="td2"><%=list.get(i).getDogName()%></td>
						</tr>
						<tr>
							<td class="td1">ũ��:</td>
							<td class="td2"><%=list.get(i).getSize()%></td>
						</tr>
						<tr>
							<td class="td1">ü��:</td>
							<td class="td2"><%=list.get(i).getWeight()%></td>
						</tr>
						<tr>
							<td class="td1">�ֿ�����:</td>
							<td class="td2"><%=list.get(i).getSick()%></td>
						</tr>
						<tr>
							<td class="td1">Ư¡:</td>
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
							<td class="td1">����:</td>
							<td class="td2"><%=list.get(i).getDogName()%></td>
						</tr>
						<tr>
							<td class="td1">ũ��:</td>
							<td class="td2"><%=list.get(i).getSize()%></td>
						</tr>
						<tr>
							<td class="td1">ü��:</td>
							<td class="td2"><%=list.get(i).getWeight()%></td>
						</tr>
						<tr>
							<td class="td1">�ֿ�����:</td>
							<td class="td2"><%=list.get(i).getSick()%></td>
						</tr>
						<tr>
							<td class="td1">Ư¡:</td>
							<td class="td2"><%=list.get(i).getChr()%></td>
						</tr>
					</table>
				</article>
				<%}%>
			<%} %>

			<!-- <tr>
							<td>����</td>
							<td>�����ڱ�</td>
						</tr>
						<tr>
							<td>Ư��1</td>
							<td>10</td>
						</tr>
						<tr>
							<td>Ư��2</td>
							<td>10</td>
						</tr>
						<tr>
							<td>Ư��3</td>
							<td>10</td>
						</tr>
						<tr>
							<td>Ư��4</td>
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
 			
/* 		    $(document).ready(function(){
		    	$("#search").keyup(function(){
		    		var k = $(this).val();
		    		 $("article>table>tbody>tr").hide(); 
		   		var temp = $("article>table>tbody>tr:first-child>td:nth-child(2):contains('"+k+"')");
		    		$(temp).parent().show();
		    	})
		    })  
			  */
			
	


			    
			</script>
	</body>
</html>