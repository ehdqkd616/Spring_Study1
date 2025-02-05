package org.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.vo.ProductVO;

@Controller
public class SampleController5 {

	@RequestMapping("/doJSON") //doJSON매핑주소 등록
	public @ResponseBody ProductVO doJSON() {
/* @ResponseBody 애노테이션을 사용하면 jsp파일을 만들지 않고도 웹브라우저에 키, 값 쌍의 json
 * 데이터를 쉽게 출력할 수 있다. 처음에는 XML객체로 보여진다. 이럴때는 doJSON.json 확장자추가
 * 하면 원하는 json데이터 키, 값을 볼수 있다.
 */
		ProductVO p = new ProductVO("노트북",1500000);
		return p;//json데이터의 키이름이 ProductVO 빈클래스의 변수명이 된다.
	}	
}
