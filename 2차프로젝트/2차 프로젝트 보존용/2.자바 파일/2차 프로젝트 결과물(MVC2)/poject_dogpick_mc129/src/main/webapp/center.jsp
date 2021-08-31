<%@page import="model.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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

		<!-- Banner -->
		<!-- Items -->
		<section class="searchlist">
			<article style="display: -webkit-flex">
				<div id="map"
					style="width: 600px; height: 600px; margin-bottom: 1em; margin-right: 7em;"></div>
				<div style="width: 250px; padding-top: 6em;">
					<h3 align="center">주소 검색</h3>
					<div style="display: -webkit-flex;">
						<select style="color: black; width: 6em; height: 50px;"
							name="address" class="input" id="addr_do" onchange="sel_do(this)">
							<option value="">선택</option>
							<option>서울</option>
							<option>울산</option>
							<option>대구</option>
							<option>부산</option>
							<option>인천</option>
							<option>광주</option>
							<option>대전</option>
							<option >제주</option>
							<option >세종</option>
							<option>경기도</option>
							<option>강원도</option>
							<option>경상남도</option>
							<option>경상북도</option>
							<option>전라북도</option>
							<option>전라남도</option>
							<option>충청북도</option>
							<option>충청남도</option>
						</select>
						<select style="color: black; width: 6em; height: 50px;"
							name="address" class="input" id="addr_siGoon" onchange="sel_sub">
							<option>--선택--</option>
						</select>
					</div>
					<input type="button" value="찾기" id="startsearch"
						style="height: 50px; text-align: center; width: 16.5em; margin: 1.5em 0;">
				</div>

			</article>
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
				<li><a href="#" class="icon fa-facebook"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span
						class="label">Instagram</span></a></li>
				<li><a href="#" class="icon fa-linkedin"><span
						class="label">LinkedIn</span></a></li>
				<li><a href="#" class="icon fa-envelope"><span
						class="label">Email</span></a></li>
			</ul>
			<p class="copyright">
				&copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>.
				Images: <a href="https://unsplash.com">Unsplash</a>.
			</p>
		</footer>

	</div>

	<!-- Scripts -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=36534f82a5794064b608d62e3617cb93&libraries=services,clusterer,drawing"></script>
 	<script src="style/js/jquery.min.js"></script> 
	<script src="style/js/skel.min.js"></script>
	<script src="style/js/util.js"></script>
	<script src="style/js/main.js"></script>
	<script src="style/js/classie.js"></script>
	<script src="style/js/clipboard.min.js"></script>
	
<!-- 	<script src="json-simple-1.1.1.jar"></script> -->
  	<script	src="style/js/jquery-3.6.0.min.js"></script>
	
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


	<!-- 지도 불러오기 -->
   
   

 	<script type="text/javascript">
	$.ajax({
		type : "post",
		dataType : "json", //서버에서 받을 데이터 형식을 지적한다.
		url : "center_d", //요청받을 서블릿 url 이름
		success : function(check){
				//alert("성공"); //통신에 성공했는지 확인하기위한 알림창
				console.log(check[0].C_Addr)
				
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		 	    mapOption = {
		 	        center: new kakao.maps.LatLng(37.56682, 126.97870), // 지도의 중심좌표
		 	        level: 2, // 지도의 확대 레벨
		 	        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
		 	    }; 
			
			 	// 지도를 생성한다 
			 	var map = new kakao.maps.Map(mapContainer, mapOption); 
			 	
			 	// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();
				
					function info(result, status, C_Name, C_Tel){	//좌표 검색과, 해당 좌표에 대한 데이터를 출력하기 위한 클로저 함수
						return function(result, status) {
					
					    // 정상적으로 검색이 완료됐으면 
					     if (status === kakao.maps.services.Status.OK) {
					    	 console.log("검색 성공");

					    	var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
							//console.log(result[0].y);
							//console.log(result[0].x);
							
					        // 결과값으로 받은 위치를 마커로 표시합니다
					        var marker = new kakao.maps.Marker({
					            map: map,
					            position: coords
					        });
					
					        // 인포윈도우로 장소에 대한 설명을 표시합니다
					        var infowindow = new kakao.maps.InfoWindow({
					            content: '센터명 :<div style="width:150px;text-align:left;padding:0px 0;">'+ C_Name +'</div><br>'+
					            		'전화번호 :<div style="width:150px;text-align:left;padding:0px 0;">'+ C_Tel +'</div>'
					        });
					        
					        
						        // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
						        // 이벤트 리스너로는 클로저를 만들어 등록합니다 
						        // ★★★★★for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
						        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
						        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
					        
					            
					     		// 마커에 클릭이벤트를 등록합니다
						        kakao.maps.event.addListener(marker, 'click', function() {
						        	//클릭한 해당 마크의 name 과 tell 을 쿼리스트링으로 get 방식으로 넘겨줌 
						        	location.href = "center_map.jsp?C_Name=" + C_Name + "&&C_Tel=" + C_Tel;
						        });
					    
						       
					    }//if끝
					    else{
					    	console.log("검색 실패")
					    	}//else끝
					    
					}
				
				}
				
				
				for (var i = 0; i < check.length; i ++) {
					// 주소로 좌표를 검색하여 map 에 마크로 나타낸다
					geocoder.addressSearch(check[i].C_Addr, info(null, null, check[i].C_Name, check[i].C_Tel));
				}
				// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
				function makeOverListener(map, marker, infowindow) {
				    return function() {
				        infowindow.open(map, marker);
				    };
				}
				// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
				function makeOutListener(infowindow) {
				    return function() {
				        infowindow.close();
				    };
				}
			
			
		}
		
	});
	</script>
<!-- 	<script>
// 	var input_click = document.getElementById("startsearch");
// 	input_click.addEventListener('click', function(){
// 		console.log(input_click);
// 		var cat_1 = document.getElementById("addr_do");
// 		var cat_2 = document.getElementById("addr_siGoon");
// 		var cat_addr = cat_1.val() + cat_2.val();
// 		console.log(cat_addr);
// 		geocoder.addressSearch(cat_addr, status);
		
// 		function setCenter() {            
// 		    // 이동할 위도 경도 위치를 생성합니다 
// 		    var moveLatLon = new kakao.maps.LatLng(33.452613, 126.570888);
// 		    // 지도 중심을 이동 시킵니다
// 		    map.setCenter(moveLatLon);
// 		}

// 		function panTo() {
// 		    // 이동할 위도 경도 위치를 생성합니다 
// 		    var moveLatLon = new kakao.maps.LatLng(33.450580, 126.574942);
// 		    // 지도 중심을 부드럽게 이동시킵니다
// 		    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
// 		    map.panTo(moveLatLon);            
// 		}
	})
	
	</script> -->
	<script>
		var sel_sub = {
			'강원도' : [{siGoon : "강릉시"},{siGoon : "고성군"},{siGoon : '동해시'},{siGoon : '삼척시'},{siGoon : '속초시'},{siGoon : '양구군'},{siGoon : '양양군'},{siGoon : '원주시'},{siGoon : '인제군'},{siGoon : '정선군'}, {siGoon : '철원군'},{siGoon : '춘천시'},{siGoon : '태백시'},{siGoon : '평창군'},{siGoon : '홍천군'},{siGoon : '화천군'}],
			'경기도': [{siGoon:'가평군'}, {siGoon:'고양시'}, {siGoon:'과천시'}, {siGoon:'광명시'}, {siGoon:'광주시'}, {siGoon:'군포시'}, {siGoon:'부천시'}, {siGoon:'성남시'}, {siGoon:'수원시'}, {siGoon:'시흥시'}, {siGoon:'안산시'}, {siGoon:'양주시'}, {siGoon:'양평군'}, {siGoon:'용인시'}, {siGoon:'의왕시'}, {siGoon:'파주시'}, {siGoon:'평택시'}, {siGoon:'포천시'}, {siGoon:'하남시'}],
			'경상남도': [{siGoon:'거제시'}, {siGoon:'고성군'}, {siGoon:'김해시'}, {siGoon:'밀양시'}, {siGoon:'사천시'}, {siGoon:'산청군'}, {siGoon:'양산시'}, {siGoon:'의령군'}, {siGoon:'진주시'}, {siGoon:'창녕군'}, {siGoon:'창원시'}, {siGoon:'하동군'}, {siGoon:'함양군'}],
			'경상북도': [{siGoon:'경주시'}, {siGoon:'구미시'}, {siGoon:'군위군'}, {siGoon:'김천시'}, {siGoon:'문경시'}, {siGoon:'봉화군'}, {siGoon:'상주시'}, {siGoon:'안동시'}, {siGoon:'영덕군'}, {siGoon:'영주시'}, {siGoon:'영천시'}, {siGoon:'예천군'}, {siGoon:'울릉군'}, {siGoon:'울진군'}, {siGoon:'청도군'}, {siGoon:'청송군'}, {siGoon:'포항시'}],
			'광주': [{siGoon:'광산구'}, {siGoon:'남구'}, {siGoon:'동구'}, {siGoon:'북구'}, {siGoon:'서구'}],
			'대구': [{siGoon:'달성군'}, {siGoon:'동구'}, {siGoon:'서구'}, {siGoon:'수성구'}, {siGoon:'중구'}],
			'대전': [{siGoon:'대덕구'}, {siGoon:'동구'}, {siGoon:'서구'}, {siGoon:'유성구'}, {siGoon:'중구'}],
			'부산': [{siGoon:'강서구'}, {siGoon:'금정구'}, {siGoon:'기장군'}, {siGoon:'동래구'}, {siGoon:'부산진구'}, {siGoon:'사하구'}, {siGoon:'수영구'}, {siGoon:'영도구'}],
			'서울': [{siGoon:'강남구'}, {siGoon:'강동구'}, {siGoon:'강북구'}, {siGoon:'강서구'}, {siGoon:'관악구'}, {siGoon:'광진구'}, {siGoon:'구로구'}, {siGoon:'금천구'}, {siGoon:'노원구'}, {siGoon:'도봉구'}, {siGoon:'동대문구'}, {siGoon:'마포구'}, {siGoon:'서대문구'}, {siGoon:'서초구'}, {siGoon:'성동구'}, {siGoon:'성북구'}, {siGoon:'양천구'}, {siGoon:'영등포구'}, {siGoon:'용산구'}, {siGoon:'은평구'}, {siGoon:'종로구'}, {siGoon:'중구'}, {siGoon:'중랑구'}],
			'세종': [{siGoon:'세종시'}],
			'울산': [{siGoon:'남구'}, {siGoon:'북구'}, {siGoon:'울주군'}, {siGoon:'중구'}],
			'인천': [{siGoon:'강화군'}, {siGoon:'동구'}, {siGoon:'미추홀구'}, {siGoon:'서구'}, {siGoon:'옹진군'}, {siGoon:'중구'}],
			'전라남도': [{siGoon:'강진군'}, {siGoon:'광양시'}, {siGoon:'나주시'}, {siGoon:'담양군'}, {siGoon:'무안군'}, {siGoon:'보성군'}, {siGoon:'순천시'}, {siGoon:'신안군'}, {siGoon:'여수시'}, {siGoon:'영광군'}, {siGoon:'완도군'}, {siGoon:'장성군'}, {siGoon:'장흥군'}, {siGoon:'진도군'}, {siGoon:'함평군'}, {siGoon:'화순군'}],
			'전라북도': [{siGoon:'고창군'}, {siGoon:'군산시'}, {siGoon:'김제시'}, {siGoon:'완주군'}, {siGoon:'익산시'}, {siGoon:'임실군'}, {siGoon:'장수군'}, {siGoon:'정읍시'}],
			'제주': [{siGoon:'서귀포시'}, {siGoon:'제주시'}],
			'충청남도': [{siGoon:'금산군'}, {siGoon:'논산시'}, {siGoon:'부여군'}, {siGoon:'서산시'}, {siGoon:'서천군'}, {siGoon:'아산시'}, {siGoon:'천안시'}, {siGoon:'청양군'}, {siGoon:'태안군'}],
			'충청북도': [{siGoon:'단양군'}, {siGoon:'보은군'}, {siGoon:'영동군'}, {siGoon:'옥천군'}, {siGoon:'제천시'}, {siGoon:'증평군'}, {siGoon:'청주시'}]
			};
  	</script>
	<script>
		function sel_do(str){
			 console.log(str.value);
			 var h = [];
			 h.push("<option>" + "--선택--" + "</option>");
			 // var subb = document.getElementById('addr_siGoon');
			 if(str.value != ""){
				  console.log(sel_sub[str.value]);
				  for(var siGoon of sel_sub[str.value]){
						var temp = "<option>" + siGoon.siGoon + "</option>";
						h.push(temp);
				  };
						document.getElementById("addr_siGoon").innerHTML = h.join("");
			 };
		};
	  </script>
	  
</body>
</html>