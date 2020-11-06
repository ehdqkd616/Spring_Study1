<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 아작스 댓글연습 </title>
<style>
 #modDiv{
  width:300px; /* div 폭을 지정 */
  height:100px; /* div 높이를 지정 */
  background-color:gray;/*배경색*/
  position:absolute; top:50%; left:50%;
  margin-top:-50px; /* css 주석문 기호, 바깥 위쪽 여백 */
  margin-left:-150px; /* 바깥 왼쪽 여백 */
  padding:10px; /* 상하좌우 안여백 */
  z-index:1000; /* position 속성이 absolute나 fixed로 설정된 곳에서 사용함.
  이 속성은 요소가 겹쳐지는 순서를 제어할 수 있다. 값이 큰 것이 먼저 나온다. */
 }
</style>
</head>
<body>
 <%-- 댓글 수정화면 --%>
 <div id="modDiv" style="display:none;">
  <%-- display:none; css속성값은 해당 화면을 안보이게 함. --%>
  <div class="modal-title"></div>
  <div>
   <textarea rows="3" cols="30" id="replytext"></textarea>
  </div>
  <div>
   <button type="button" id="replyModBtn">댓글수정</button>
   <button type="button" id="replyDelBtn">댓글삭제</button>
   <button type="button" id="closeBtn" onclick="modDivClose();">
      닫기</button>
  </div>
 </div>
 
<h2>아작스 연습 페이지</h2>
<div>
 <div>
   댓글 작성자 : <input type="text" name="replyer" id="newReplyWriter" />
 </div>
 <br/>
 <div>
   댓글 내용 : <textarea rows="5" cols="30" name="replytext"
  id="newReplyText"></textarea>
 </div>
 <br/>
 <button id="replyAddBtn">댓글등록</button>
</div>

<br/>
<hr/>
<br/>

<%-- 댓글 목록 --%>
<ul id="replies"></ul>

<%-- jQuery 라이브러리 읽어옴. --%>
<script src="./resources/js/jquery.js"></script>
<script>
 var bno=13; //게시판 번호
 
 getAllList(); //댓글목록 함수를 호출
 function getAllList(){
	 $.getJSON("/controller/replies/all/"+bno, function(data){
		 //get방식으로 비동기식 아작스 방법으로 json데이터를 가져와 data매개변수에 저장시킴
		var str="";//var은 변수정의 예약어이다. 
		$(data).each(function(){//jQuery each()함수로 반복함.
			str += "<li data-rno='"+this.rno+"' class='replyLi'>"
			+ this.rno+ " : <span class='com' style='color:blue;font-weight:bold;'>"+ this.replytext	+ "</span>"
			+" <button>댓글수정</button></li><br/>";
		});
		 $('#replies').html(str); //#replies 아이디 영역에 html()함수 사용하여 댓글
		 //목록을 변경적용.
	 });
 }//getAllList()함수
 
 //댓글 추가
 $('#replyAddBtn').on('click', function(){
	 var replyer = $('#newReplyWriter').val();//댓글 작성자
	 var replytext = $('#newReplyText').val();//댓글 내용
	 
	 $.ajax({//get or post방식을 처리하는 jQuery 비동기식 아작스 함수 => 사용빈도가 가장높다
		 //$대신 jQuery를 사용해도 된다.
		 type:'post', //비동기식 아작스로 서버로 데이터를 보내는 법
		 url : '/controller/replies', //아작스 서버 매핑주소
		 headers:{
			 "Content-Type":"application/json",
			 "X-HTTP-Method-Override" : "POST"
		 },
		 dataType:'text',
		 data:JSON.stringify({
			 bno:bno, //키, 값 쌍으로 번호값 전달
			 replyer:replyer, //키이름은 ReplyVO.java의 변수명과 일치, 댓글 작성자
			 replytext:replytext //댓글 내용
		 }),
		   success:function(result){
			   //비동기식 아작스로 가져오는 것이 성공시 호출되는 콜백함수. 가져온 자료는 result
			   //매개변수에 저장
			   if(result=='success'){
				   alert('댓글이 등록되었습니다!');
				   getAllList(); //댓글 목록 함수를 호출
			   }
		   }
	 });
 });
 
 //댓글수정화면
 $('#replies').on('click',".replyLi button",function(){
	 //.replyLi는 클래스 선택자
	 var reply=$(this).parent();
	 var rno=reply.attr("data-rno"); //data-rno 속성값은 댓글번호
	 var replytext=reply.text(); //댓글 내용
	 
	 $('.modal-title').html(rno);//댓글번호를 .modal-title 클래스 선택자 영역에
	 //문자와 태그를 변경 적용
	 $('#replytext').val(replytext);//댓글내용을 변경적용
	 $('#modDiv').show('slow');//수정화면을 show()함수로 천천히 보이게 함.
 });
 
 //댓글 수정화면 닫기
 function modDivClose(){
	 $('#modDiv').hide('slow');//hide()함수로 천천히 닫기
 }
 
 //댓글수정완료
 $('#replyModBtn').on("click",function(){
	 var rno=$(".modal-title").html();//댓글번호
	 var replytext=$('#replytext').val();//댓글내용
	 
	 $.ajax({
		 type:'put',
		 url:'/controller/replies/'+rno,
		 headers:{
			 "Content-Type":"application/json",
			 "X-HTTP-Method-Override":"PUT"
		 },
		 data:JSON.stringify({
			replytext:replytext //수정댓글내용이 전달
		 }),
		 dataType:'text',
		 success:function(result){
			 if(result == 'success'){
				 alert('댓글이 수정되었습니다!');
				 $('#modDiv').hide('slow');//수정화면을 숨김
				 getAllList();//댓글 목록함수를 호출
			 }
		 }
	 });
 });
 
 //댓글 삭제완료
 $('#replyDelBtn').on('click',function(){//삭제버튼 클릭이벤트 발생시 실행
    var rno=$('.modal-title').html();//댓글번호
    //var은 변수정의 예약어,$는 jQuery란 듯, .modal-title은 클래스 선택자, html() 
    //jQuery함수는 해당영역의 태그와 문자를 가져옴.var자바스크립트 예약어는 생략가능하다.
    
    $.ajax({
    	type:'delete',
    	url:'/controller/replies/'+rno,
    	headers:{
    		"Content-Type":"application/json",
    		"X-HTTP-Method-Override":"DELETE"
    	},
    	dataType:'text',
    	success:function(result){
    		//비동기식으로 받아오는 것이 성공시 호출되는 콜백함수
    		if(result == 'success'){
    			alert('댓글이 삭제되었습니다!');
    			$('#modDiv').hide('slow');//댓글 수정화면을 천천히 닫는다.
    			getAllList();//댓글 목록함수를 호출
    		}
    	}
    });
 });
</script>
</body>
</html>

