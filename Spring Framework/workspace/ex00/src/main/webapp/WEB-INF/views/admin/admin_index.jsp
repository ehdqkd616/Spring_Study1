<%@ page  contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 관리자 로그인 </title>
<script src="./resources/js/jquery.js"></script><%-- jQuery 외부라이브러리
읽어오기 --%>
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css" />
<%-- css 파일 읽어오기 --%>
<script>
  function admin_check(){//자바스크립트 function 키워드로 admin_check()함수 정의
	  if($.trim($('#admin_id').val()) == ""){
		  //$는 jQuery란 뜻, trim() jQuery함수는 양쪽공백을 제거, val() jQuery함수
		  //는 입력필드 값을 가져옴.
		  alert('관리자 아이디를 입력하세요!');//alert()는 자바스크립트 내장함수로서 경고창
		  //을 만듬.
		  $('#admin_id').val('').focus();//val('')은 입력박스를 초기화,
		  //focus()는 자바스크립트 메서드로 입력필드로 포커스를 이동시킴.
		  return false;
	  }
  
     $admin_pwd = $.trim($('#admin_pwd').val());
    if($admin_pwd.length == 0){//length속성은 문자열 길이를 반환하고 첫문자를 1부터 시작
         alert('관리자 비번을 입력하세요!');
         /* 문제) 2개의 코드라인을 완성하세요.
             1.비번입력박스를 초기화
             2.비번 입력필드로 포커스 이동
                      문제)개발자 테스트를 통해서 디버깅을 통한 에러를 점검해서 잡고 정상프로그램으로 완성
                      하세요.
         */
         $('#admin_pwd').val('');
         $('#admin_pwd').focus();             
         return false;
     }
  }
</script>
</head>
<body>
 <div id="aLogin_wrap">
  <%-- div는 사각형 박스모델 레이아웃을 그릴때 사용하는 태그이다. 이 태그는 가로 줄 전체를 차지하는
  블록요소 태그이다. --%>
  <h2 class="aLogin_title">관리자 로그인</h2>
  <form method="post" action="admin_login_ok" 
  onsubmit="return admin_check()">
  <%-- method속성을 생략하면 기본값은 get방식이다. --%>
   <table id="aLogin_t">
    <tr>
     <th>관리자 아이디</th>
     <td><input name="admin_id" id="admin_id" size="14"
     tabindex="1" /></td>
<%-- type속성을 생략하면 기본값은 text이다. tabindex="1"로 지정하면 탭키를 눌렀을때 첫번째
로 포커스(입력대기)를 가진다.
 --%>
     <th rowspan="2"><%-- rowspan="2"로 설정하면 1행3열과 2행3열 2개행이 한개행으로 
     합침. --%>
     <input type="submit" value="로그인" />
     </th>     
    </tr>
    
    <tr>
     <th>관리자 비밀번호</th>
     <td><input type="password" name="admin_pwd" id="admin_pwd"
     size="14" tabindex="2" /><%-- tabindex="2"로 설정하면 탭키를 눌렀을때 
     2번째로 포커스를 가짐 --%>
    </tr>
   </table>
  </form>  
 </div>
</body>
</html>




