<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- JSTL 코어 태그립 추가 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 스프링 게시판 목록 </title>
</head>
<body>
 <table border="1">
  <tr>
   <th colspan="5">스프링 게시판 목록보기</th>
  </tr>
  <tr>
   <td colspan="5" align="right">총 게시물수 : <b>${totalCount}</b> 개</td>
   <%-- ${totalCount}는 표현언어 즉 EL(Expressipon Language)로서 컨트롤 클래스의
   키이름을 참조해서 총 게시물 수 값을 출력한다. --%>
  </tr>
  <tr>
   <th>번호</th> <th>글제목</th> <th>글쓴이</th> <th>조회수</th>
   <th>등록날짜</th>
  </tr>
   <c:if test="${!empty blist}">
   <c:forEach var="b" items="${blist}">
   <tr>
    <th>${b.bno}</th>
    <th>
      <a href="/controller/board/board_cont?bno=${b.bno}&page=${page}">
      ${b.title}&nbsp;&nbsp;<%-- &nbsp;을 두번 사용하여 두칸의 빈공백을 처리 --%>
      <c:if test="${b.replycnt != 0}">
      <strong>[댓글개수 : ${b.replycnt} 개]</strong></c:if></a>
      <%-- 매핑주소?bno=번호값 형태의 웹주소창에 노출되는 get방식으로 bno피라미터 이름에
      번호값을 담아서 내용보기로 전달. 하이퍼링크가 걸리면 브라우저 출력창에 밑줄선이 생김. \
      get방식으로 복수개의 파라미터값을 전달할때는 &으로 구분해서 다음과 같이 보낸다.
      board_cont?bno=번호값&page=쪽번호 --%>
    </th>
    <th>${b.writer}</th>
    <th>${b.viewcnt}</th>
    <th>${b.regdate}</th>
   </tr>
   </c:forEach>
  </c:if>  
  <c:if test="${empty blist}">
   <tr>
    <th colspan="5">게시물 목록이 없습니다!</th>
   </tr>  
  </c:if>
  
  <%-- 페이징 쪽나누기 추가 --%>
  <tr>
   <th colspan="5">
   <c:if test="${page <= 1}">>
   [이전]&nbsp;<%-- &nbsp;은 특수문자로 한칸 빈공백을 만듬. 2번 사용하면 2칸 빈공백. --%>
   </c:if>
   
   <c:if test="${page > 1}">
   <a href="/controller/board/board_list?page=${page-1}">[이전]</a>
   </c:if>
   
   <%-- 현재 쪽번호 출력 --%>
   <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
   <%-- 시작페이지 부터 끝페이지까지 1씩 증가하는 반복문 --%>
    <c:if test="${a == page}"><%-- 현재 선택된 쪽번호 --%>
     <${a}>
    </c:if>
    
    <c:if test="${a != page}"><%-- 현재 선택된 쪽번호가 아닌 경우 --%>
    <a href="/controller/board/board_list?page=${a}">[${a}]</a>
    </c:if>
   </c:forEach>
   
   <c:if test="${page >= maxpage}">
   [다음]
   </c:if>
   <c:if test="${page < maxpage}">
   <a href="/controller/board/board_list?page=${page+1}">[다음]</a>
   </c:if>
   </th>
  </tr>
  
  <tr>
   <td colspan="5" align="right">
    <input type="button" value="글입력" onclick="location=
    '/controller/board/board_write?page=${page}';" />
    <%-- onclick은 클릭 사건을 처리하는 이벤트핸들러 즉 사건처리기이다. 자바스크립트에서
     location객체는 지정된 url매핑주소로 이동시킨다.--%>   
   </th>
  </tr>
 </table>
 <script type="text/javascript">
  $msg='${msg}';
  /* 1.$msg는 jQuery변수명, ${msg}는 EL즉 표현언어로 컨트롤러 클래스의 msg키이름을 참조해서
  'success'문자열을 가져와 jQuery 변수에 저장
     2.자바스크립트에서 EL을 사용할 수 있다.
  */
  if($msg == 'success'){
	  window.alert('게시물 처리에 성공했습니다!'); //경고메세지를 띄움. window.은 생략가능
  }
  
 </script>
</body>
</html>

