package org.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	
	@RequestMapping("/doE") //doE매핑주소 등록
	public String doE(RedirectAttributes rttr) {
		rttr.addFlashAttribute("msg", "this is seven");
		/* 다른 매핑주소간 이동시 msg키이름에 인자값을 담아서 전달한다. 서버상에서 실행되기 때문에
		 * 웹주소창에 전달되는 값이 보이지 않는다. 보안성이 아주 우수하다.
		 */
		return "redirect:/doF";//doE 매핑주소가 실행되면 다른 매핑주소인 doF로 이동함.
	}
	
	@RequestMapping("/doF")
	public void doF(@ModelAttribute("msg") String name) {
		System.out.println("전달된 값:"+name);		
	}
	
}
