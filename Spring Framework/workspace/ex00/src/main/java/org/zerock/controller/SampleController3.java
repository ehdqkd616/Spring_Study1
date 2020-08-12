package org.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.zerock.vo.ProductVO;

@Controller
public class SampleController3 {

	@GetMapping("/nameprice") //get으로 접근하는 nameprice매핑주소 처리
	public String nameprice(Model m) {
		ProductVO p = new ProductVO("수박", 15000);//오버로딩 된 생성자를 호출하면서
		//상품명과 가격을 저장
		m.addAttribute("p", p);//p키 이름에 p객체를 저장
		return "shop/pro_name";//뷰리졸브 경로=>/WEB-INF/views/shop/pro_name
		//.jsp
	}
	
}

