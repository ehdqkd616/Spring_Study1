<%@ page  contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 관리자 메인화면</title>
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css" />
<link rel="stylesheet" type="text/css" 
href="./resources/css/admin_gongji.css" />

<script src="./resources/js/jquery.js"></script>
<script src="./resources/js/admin_gongji.js"></script>
<%--
 문제)admin_gongji.js파일을 만들고 관리자 공지사항 유효성 검증 처리를 한다.
 --%>

</head>
<body>
 <div id="aMain_wrap">
  <%--관리자 메인 상단--%>
  <div id="aMain_header">
   <%--관리자 로고 --%>
   <div id="aMain_logo">
    <a href="admin_main">
     <img src="./resources/images/admin/admin_logo.png" />
     <%-- img src="그림파일경로" 그림삽입태그 --%>
    </a>
   </div>
   
   <%--관리자 상단메뉴 --%>
   <div id="aMain_menu">
    <ul><%-- ul li는 순서없는 목록태그이다. 이 태그를 사용해서 메뉴구성을 한다. --%>
     <li><a href="admin_gongji_write">공지사항</a></li><%-- 하이퍼링크 걸래 href="#"로 준것은
     이동통로를 막았다는 뜻 --%>
     <li><a href="#">게시판</a></li>
     <li><a href="#">댓글</a></li>
     <li><a href="#">자료실</a></li>
     <li><a href="#">회원관리</a></li>
    </ul>
   </div>   
   
   <%--관리자 상단 우측메뉴 --%>
   <div id="aMain_right">
    <form method="post" action="admin_logout">
     <h3 class="aRight_title">
       ${admin_name}님 로그인을 환영합니다.
       <input type="submit" value="로그아웃" />   
     </h3>
    </form>
   </div>
  </div>
  
  <div class="clear"></div>
  