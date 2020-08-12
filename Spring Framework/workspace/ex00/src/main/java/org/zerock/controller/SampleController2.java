package org.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {

	@RequestMapping("doC") //doC 매핑주소 등록
	public String doC(@ModelAttribute("msg") String msg) {
		/* @ModelAttribute("msg")는 msg 파라미터이름에 인자값을 담아서 문자열로 전달한다.
		 * 웹주소 실행 매핑주소값으로 doC?msg=인자값 형태의 웹주소창에 노출되는 get방식으로
		 * 전달한다.
		 */
		return "result"; //뷰리졸브 경로(jsp파일경로)=>/WEB-INF/views/result.jsp
	}
	
}
