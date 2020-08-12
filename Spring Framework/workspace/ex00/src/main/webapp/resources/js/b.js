/**
 * b.js
 */

function w_check() { //function 자바스크립트 키워드로 w_check() 라는 함수 정의
	$writer = $.trim($('#writer').val());
	/* 1.$는 jQuery란 뜻. $writer는 jQuery변수명. $.trim()함수는 양쪽공백을 제거
	 * 2.#writer는 아이디 선택자. val() jQuery 함수는 입력박스값을 가져옴.
	 */
	if($writer == ""){
		window.alert("글쓴이를 입력하세요.");
		/* 자바스크립트 한줄이상 주석문기호. alert()는 자바스크립트 내장함수로써 경고창을 만듬
		 * window.은 생략가능하다. window는 자바스크립트 브라우저 내장객체이다.
		 */
		$('#writer').val(''); // val('') 함수는 입력박스 값을 초기화하고, 한문장 끝을
		//뜻하는 세미콜론(;) 해도 되고, 안해도 된다.
		$("#writer").focus();//focus()는 자바스크립트 메서드로 입력박스로 포커스를 이동시킴
		return false;
	}
	
	if($.trim($("#title").val()) == ""){
		//자바스크립트에서는 문자열을 '' 또는 ""로 처리한다.
		alert('제목을 입력하세요!');
		$('#title').val('').focus(); //입력박스를 초기화하고 포커스 이동
		return false;
	}
	
	if($.trim($('#content').val()) == ""){
		alert('글내용을 입력하세요!');
		$('#content').val('').focus();
		return false;
	}
	
}



