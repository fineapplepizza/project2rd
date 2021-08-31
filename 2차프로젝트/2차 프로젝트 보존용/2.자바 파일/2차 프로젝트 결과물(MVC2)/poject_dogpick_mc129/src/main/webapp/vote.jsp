<%@page import="model.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE HTML>
<!--
   Epilogue by TEMPLATED
   templated.co @templatedco
   Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
   <head>
      <title>�ӽ� 129 (����߸�Ī)</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link rel="stylesheet" href="style/css/main2.css" />
      <link rel="stylesheet" href="style/css/add2.css" />
      
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
            <h1 class="title"><a href="introduce.jsp" style="text-decoration: none;">����߸�Ī�ý���</a></h1>
         </div>
            <nav class="menu_nav">
               <ul class="menu_nav_list">
                  <li class="menu__item"><a href="introduce.jsp" class="menu__link">���� �Ұ�</a></li>
                  
                  <li class="menu__item"><a href="dog.jsp" class="menu__link">��������</a></li>
                  
                  <li class="menu__item"><a href="foodindex.jsp" class="menu__link">�������</a></li>
                     
                  <li class="menu__item"><a href="center.jsp" class="menu__link">��������</a></li>
                  
                  <li class="menu__item"><a href="vote.jsp" id="vote_link" class="menu__link">��������</a></li>
               </ul>
               
            </nav>
      </header>

      <!-- Wrapper -->
      <div id="wrapper">
         <form action="http://127.0.0.1:5000/dogmc" method="get">
            <div>
               <fieldset>
                  <table  class="vote">
                     <tr>
                        <td colspan="2"><h2>��������</h2></td>
                     </tr>
                     <tr>
                        <td>
                           <!-- �������� ���� -->
                           1. ����ϴ� �ݷ����� ũ�⸦ �������ּ���.
                        </td>
                        <td class=input_td>
                           <input type="radio" value="S" name="v1" id="v1_1"><label for="v1_1">������</label>
                           <input type="radio" value="M" name="v1"  id="v1_2"><label for="v1_2">������</label>
                           <input type="radio" value="L" name="v1"  id="v1_3"><label for="v1_3">������</label>
                        </td>
                     </tr>
                     <tr>
                        <td>
                           <!-- �������� ���� -->
                           2. ���� �ݷ��߰� �Բ� ��Ȱ�ϴ� �ְ�ȯ���� �������ּ���.
                        </td>
                        <td class=input_td>
                           <!-- �� �ƴϿ� üũ *name�� value�� �־���� -->
                           <input type="radio" value="A" name="v2" id="v2_1"><label for="v2_1">����Ʈ,����,���ǽ���</label>
                           <input type="radio"   value="J" name="v2" id="v2_2"><label for="v2_2">�ܵ�����</label>
                        </td>
                     </tr>
                     <tr>
                        <td>
                           <!-- �������� ���� -->
                           3. �ݷ����� �ǳ�,�ǿ� ��� Ű��ó���?
                        </td>
                        <td class=input_td>
                           <!-- �� �ƴϿ� üũ *name�� value�� �־���� -->
                           <input type="radio" value="I" name="v3" id="v3_1"><label for="v3_1">�ǳ�</label>
                           <input type="radio" value="O" name="v3" id="v3_2"><label for="v3_2">�ǿ�</label>
                           <input type="radio" value="IO" name="v3" id="v3_3"><label for="v3_3">�ǳ���</label>
                        </td>
                     </tr>
                     <tr>
                         <td>
                           4.�ݷ����� ȥ�� ������ �ܷο��� �����ٰ� �����ϳ���?
                        </td>
                        <td class=input_td>
                           <input type="radio" value="1" name="v4"  id="v4_1"><label for="v4_1">1</label>
                           <input type="radio" value="2" name="v4"  id="v4_2"><label for="v4_2">2</label>
                           <input type="radio" value="3" name="v4"  id="v4_3"><label for="v4_3">3</label>
                           <input type="radio" value="4" name="v4"  id="v4_4"><label for="v4_4">4</label>
                           <input type="radio" value="5" name="v4"  id="v4_5"><label for="v4_5">5</label>
                        </td> 
                     </tr>
                     <tr>
                        <td>
                           <!-- �������� ���� -->
                           5. �ݷ����� Ȱ�����̰� ��°� �����ϳ���?
                        </td>
                        <td class=input_td>
                           <input type="radio" value="1" name="v5" id="v5_1"><label for="v5_1">1</label>
                           <input type="radio" value="2" name="v5"  id="v5_2"><label for="v5_2">2</label>
                           <input type="radio" value="3" name="v5"  id="v5_3"><label for="v5_3">3</label>
                           <input type="radio" value="4" name="v5"  id="v5_4"><label for="v5_4">4</label>
                           <input type="radio" value="5" name="v5"  id="v5_5"><label for="v5_5">5</label>
                        </td>
                     </tr>
                     <tr>
                        <td>
                           <!-- �������� ���� -->
                           6. �ݷ����� �к����� ��������ΰ���?
                        </td>
                        <td class=input_td>
                           <input type="radio" value="1" name="v6" id="v6_1"><label for="v6_1">1</label>
                           <input type="radio" value="2" name="v6"  id="v6_2"><label for="v6_2">2</label>
                           <input type="radio" value="3" name="v6"  id="v6_3"><label for="v6_3">3</label>
                           <input type="radio" value="4" name="v6"  id="v6_4"><label for="v6_4">4</label>
                           <input type="radio" value="5" name="v6"  id="v6_5"><label for="v6_5">5</label>
                        </td>
                     </tr>
                     <tr>
                        <td>
                           <!-- �������� ���� -->
                           7. �ݷ����� ����� ���������� ǥ���ϳ���?
                        </td>
                        <td class=input_td>
                           <input type="radio" value="1" name="v7" id="v7_1"><label for="v7_1">1</label>
                           <input type="radio" value="2" name="v7"  id="v7_2"><label for="v7_2">2</label>
                           <input type="radio" value="3" name="v7"  id="v7_3"><label for="v7_3">3</label>
                           <input type="radio" value="4" name="v7"  id="v7_4"><label for="v7_4">4</label>
                           <input type="radio" value="5" name="v7"  id="v7_5"><label for="v7_5">5</label>
                        </td>
                     </tr><tr>
                        <td>
                           <!-- �������� ���� -->
                           8. �� �� �ݷ����� �Ƿ����� �󸶳� �����Ͻó���?
                        </td>
                        <td class=input_td>
                           <input type="radio" value="10u" name="v8" id="v8_1"><label for="v8_1">�� 10���� �̸�</label>
                           <input type="radio" value="30u" name="v8"  id="v8_2"><label for="v8_2">�� 30���� �̸�</label>
                           <input type="radio" value="30o" name="v8"  id="v8_3"><label for="v8_3">�� 10���� �̻�</label>

                        </td>
                     </tr>
                     <tr>
                        <td>
                           <!-- �������� ���� -->
                           9. �ݷ��߰� �Բ� ��Ȱ�ϴ� ���������� �� 7�� ������ ���̰� �ֳ���?
                        </td>
                        <td class=input_td>
                           <input type="radio" value="1" name="v9" id="v9_1"><label for="v9_1">��</label>
                           <input type="radio" value="2" name="v9"  id="v9_2"><label for="v9_2">�ƴϿ�</label>
                        
                        </td>
                     </tr>
                     <tr>
                        <td>
                           <!-- �������� ���� -->
                           10. �ݷ����� ¢�� �󵵴� ��� ���� �ΰ���?
                        </td>
                        <td class=input_td>
                           <input type="radio" value="1" name="v10" id="v10_1"><label for="v10_1">1</label>
                           <input type="radio" value="2" name="v10"  id="v10_2"><label for="v10_2">2</label>
                           <input type="radio" value="3" name="v10"  id="v10_3"><label for="v10_3">3</label>
                           <input type="radio" value="4" name="v10"  id="v10_4"><label for="v10_4">4</label>
                           <input type="radio" value="5" name="v10"  id="v10_5"><label for="v10_5">5</label>
                        </td>
                     </tr>
                     <tr>
                        <td>
                           <!-- �������� ���� -->
                           11. �ݷ����� ����Ű�� �ɷ��� ������� �ΰ���?
                        </td>
                        <td class=input_td>
                           <input type="radio" value="1" name="v11" id="v11_1"><label for="v11_1">1</label>
                           <input type="radio" value="2" name="v11"  id="v11_2"><label for="v11_2">2</label>
                           <input type="radio" value="3" name="v11"  id="v11_3"><label for="v11_3">3</label>
                           <input type="radio" value="4" name="v11"  id="v11_4"><label for="v11_4">4</label>
                           <input type="radio" value="5" name="v11"  id="v11_5"><label for="v11_5">5</label>
                        </td>
                     </tr>
                     <tr>
                           
                              <td colspan="2" style="text-align: center;padding-top: 70px;">
                                 <input type="submit" value="�����Ϸ�" class="submit">
                              </td>
                           
                     </tr>
                  </table>
               </fieldset>
            </div>
         </form>


      <!-- Banner -->
            <!-- CTA -->
               <section id="cta" class="main special">
                  <h2>���������� �Ծ��ϼ���</h2>
                  <p>���Ѿְ���ȸ.</p>
                  <ul class="actions">
                     <li><a href="#" class="button big">Get Started</a></li>
                  </ul>
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