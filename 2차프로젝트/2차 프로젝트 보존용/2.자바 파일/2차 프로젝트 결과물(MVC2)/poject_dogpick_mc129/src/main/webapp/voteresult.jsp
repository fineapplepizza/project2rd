<%@page import="model.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�������� ���</title>
<link rel="stylesheet" href="style/css/voteresult.css" />


</head>
	<body>
		


    <h1>�� �������� ���</h1>
    <form>
      <div class="main">
          <ul class="best_dog_list">
              <li data-sipu-result="">
                  <span class="thumb_detail">�ڼ�������</span>
                  <span class="d_thumb">
                      <img data-sipu-resultimage="" src="dog_img/pome_img.jpg" alt="" title="" /><!-- ������ 1���� ���� -->
                  </span>
                  <h3>���޶�Ͼ�</h3><!-- �������̸� �����°� -->
                  <span data-sipu-resultpoint="" class="point"><span>89%</span></span> <!-- ��Ī�� �ۼ�Ʈ  -->
                  <span data-sipu-resultname="" class="name"></span>
              </li>
          </ul>
         
          <ul class="best_dog_list">
              <li data-sipu-result="">
                  <span class="thumb_detail">�ڼ�������</span>
                  <span class="d_thumb">
                      <img data-sipu-resultimage="" src="dog_img/kogi_img.jpg" alt="" title="" /><!-- ������ 2���� ���� -->
            		</span> 
            		<h3>�����ڱ�</h3><!-- �������̸� �����°� -->
                  <span data-sipu-resultpoint="" class="point"><span>67%</span></span><!-- ��Ī�� �ۼ�Ʈ  -->
                  <span data-sipu-resultname="" class="name"></span>
              </li>
              <li data-sipu-result="">
                  <span class="thumb_detail">�ڼ�������</span>
                  <span class="d_thumb">
                      <img data-sipu-resultimage="" src="dog_img/test_dog_picture.jpg" alt="" title="" /><!-- ������ 3���� ���� -->
                  </span>
                  <h3>��ũ���׸���</h3><!-- �������̸� �����°� -->
                  <span data-sipu-resultpoint="" class="point"><span>53%</span></span><!-- ��Ī�� �ۼ�Ʈ  -->
                  <span data-sipu-resultname="" class="name"></span>
              </li>
          </ul>
      </div>
      <div class="footer">
        <a href="vote.jsp">
          <h2 class="result_restart" style="margin-top:13px;padding-top:12px">�ٽ��ϱ�</h2>
          <!-- <img alt="�ٽ��ϱ�" src="https://interactive.hankookilbo.com/v/e4fe0c1ef9294bdbb8e34c3b326ec2ed/images/result/bt_re_game.png"> -->
        </a>
        <a href="introduce.jsp"><h2 class="result_restart" style="margin-top:13px;padding-top:12px">Ȩ����</h2></a>
       </div>
   
      </form>
    

</body>
</html>