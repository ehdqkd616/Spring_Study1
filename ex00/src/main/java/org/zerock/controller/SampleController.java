package org.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //@Controller 애노테이션을 사용하면 해당 컨트롤러 클래스는 스프링에서 인식한다.
public class SampleController {
	
	@RequestMapping("doA") //doA 매핑주소 등록=>매핑주소란 웹주소창에서 실행되는 주소값
	//또다른 말로 url-pattern 주소값이다. get or post 방식으로 접근하는 doA매핑주소를
	//웹주소창에서 실행하게 한다.
	public void doA() {
		//리턴타입이 없는 void형이면 매핑주소가 뷰페이지 파일명(doA.jsp)가 된다.
		//뷰리졸브 경로=>/WEB-INF/views/doA.jsp
		System.out.println("doA 매핑주소가 실행되었다.");
	}
	
	@GetMapping("doB") //GET방식으로 접근하는 doB매핑주소를 실행함.
	public void doB() {
		System.out.println("doB 매핑주소가 실행됨.");
	}
}
