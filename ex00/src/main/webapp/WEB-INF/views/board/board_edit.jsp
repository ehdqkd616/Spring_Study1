<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 스프링 게시판 수정 </title>
<script type="text/javascript" src="../resources/js/jquery.js"></script>
<%-- jsp 주석문기호. jsp주석문은 브라우저 출력창 소스보기에서 보안상 보이지 않는다. 자바스크립트
포함파일 불러오기.  ../는 한단계 (상위 폴더로 이동하라는 상대경로이다) -> 최상위 폴더로 이동하라는 경로이다. --%>
<script src="../resources/js/b.js"></script>
<%-- type속성을 생략하면 웹브라우저가 기본값으로 자바스크립트로 인식한다. --%>
</head>
<body>
<form method="post" action="board_edit_ok" onsubmit="return w_check()">
<%--
 1.method=post방식은 브라우저 주소창에 자료가 노출되지 않고 보안에도 좋다. 보내는 자료 길이 제한도 없다.
 method속성을 생략하면 기본값은 get 방식이다.
 2.action속성에 게시판 저장 서버 매핑주소가 들어간다.
 --%>
<input type="hidden" name="bno" value="${b.bno}" />
<%-- hidden은 웹브라우저 주소창에 만들어 지지 않는다. 하지만 bno 네임파라미터 이름에 번호값을
담아서 서버로 전달할 수 있다. 웹브라우저 출력창 소스보기에서는 보이기 때문에 보안상 중요한 비번같은
경우는 히든으로 전달하면 안된다. --%>
<input type="hidden" name="page" value="${page}" />
<%-- 페이징 책갈피 기능때문에 page네임 파라미터 이름에 쪽번호를 담아서 전달. --%>

<table border="1"><%-- table태그는 표를 만든다. border속성은 테두리 두께를 지정한다.
숫자가 커질수록 두께가 굵어진다. --%>
 <tr><%-- tr태그는 행을 만든다. --%>
  <th colspan="2">스프링 게시판 수정</th>
  <%-- th태그는 열을 만들고 글자를 중앙정렬하고 진하게 한다.colspan="2"는 2개열을 합침. --%>
 </tr>
 <tr>
  <th>글쓴이</th>
  <td><%-- td태그는 열을 만들고 글자를 왼쪽 정렬한다. --%>
   <input type="text" name="writer" id="writer" size="14" 
   value="${b.writer}"/>
   <%-- text는 한줄 입력박스를 만든다. 입력한 글쓴이는 writer 네임파라미터 이름에 저장되어
   서버로 전송된다. size속성에는 입력박스 길이를 지정한다. 물론 숫자가 커질수록 길이는 늘어난다. --%>
  </td>
 </tr>
 
 <tr>
  <th>제목</th>
  <td><input name="title" id="title" size="36" 
  value="${b.title}" /></td>
  <%-- type속성을 생략하면 기본값이 text이다. --%>
 </tr>
 
 <tr>
  <th>글내용</th>
  <td><textarea name="content" id="content" rows="10" cols="38">${b.content}</textarea></td>
  <%-- textarea는 한줄이상 입력할 수 있는 입력박스를 만든다. rows속성은 행, cols속성은 열
  textarea에는 value속성이 없다. --%>
 </tr>

 <tr>
  <th colspan="2">
  <input type="submit" value="수정" />
  <%-- submit은 버튼을 만들고 자료를 서버로 전송한다. --%>
  <input type="reset" value="취소" />
  <%-- reset은 버튼을 만들고 입력박스 값을 초기화 --%>
  <input type="button" value="목록"
  onclick="location='/controller/board/board_list?page=${page}';" />
  </th>
 </tr>
</table>
</form>
</body>
</html>



