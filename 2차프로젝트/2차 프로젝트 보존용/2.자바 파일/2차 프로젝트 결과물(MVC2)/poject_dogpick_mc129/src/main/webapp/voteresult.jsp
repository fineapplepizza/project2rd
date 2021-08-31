<%@page import="model.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>설문조사 결과</title>
<link rel="stylesheet" href="style/css/voteresult.css" />


</head>
	<body>
		


    <h1>내 설문조사 결과</h1>
    <form>
      <div class="main">
          <ul class="best_dog_list">
              <li data-sipu-result="">
                  <span class="thumb_detail">자세히보기</span>
                  <span class="d_thumb">
                      <img data-sipu-resultimage="" src="dog_img/pome_img.jpg" alt="" title="" /><!-- 강아지 1순위 사진 -->
                  </span>
                  <h3>포메라니안</h3><!-- 강아지이름 나오는곳 -->
                  <span data-sipu-resultpoint="" class="point"><span>89%</span></span> <!-- 매칭시 퍼센트  -->
                  <span data-sipu-resultname="" class="name"></span>
              </li>
          </ul>
         
          <ul class="best_dog_list">
              <li data-sipu-result="">
                  <span class="thumb_detail">자세히보기</span>
                  <span class="d_thumb">
                      <img data-sipu-resultimage="" src="dog_img/kogi_img.jpg" alt="" title="" /><!-- 강아지 2순위 사진 -->
            		</span> 
            		<h3>웰시코기</h3><!-- 강아지이름 나오는곳 -->
                  <span data-sipu-resultpoint="" class="point"><span>67%</span></span><!-- 매칭시 퍼센트  -->
                  <span data-sipu-resultname="" class="name"></span>
              </li>
              <li data-sipu-result="">
                  <span class="thumb_detail">자세히보기</span>
                  <span class="d_thumb">
                      <img data-sipu-resultimage="" src="dog_img/test_dog_picture.jpg" alt="" title="" /><!-- 강아지 3순위 사진 -->
                  </span>
                  <h3>요크셔테리어</h3><!-- 강아지이름 나오는곳 -->
                  <span data-sipu-resultpoint="" class="point"><span>53%</span></span><!-- 매칭시 퍼센트  -->
                  <span data-sipu-resultname="" class="name"></span>
              </li>
          </ul>
      </div>
      <div class="footer">
        <a href="vote.jsp">
          <h2 class="result_restart" style="margin-top:13px;padding-top:12px">다시하기</h2>
          <!-- <img alt="다시하기" src="https://interactive.hankookilbo.com/v/e4fe0c1ef9294bdbb8e34c3b326ec2ed/images/result/bt_re_game.png"> -->
        </a>
        <a href="introduce.jsp"><h2 class="result_restart" style="margin-top:13px;padding-top:12px">홈으로</h2></a>
       </div>
   
      </form>
    

</body>
</html>