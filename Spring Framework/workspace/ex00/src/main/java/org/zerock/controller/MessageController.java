package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.MessageService;
import org.zerock.vo.MessageVO;

@RestController
@RequestMapping("/message") //컨트롤러 자체에 매핑주소 등록
public class MessageController {

	@Autowired //자동의존성 주입
	private MessageService messageService;
	
	//메시지 추가
	@RequestMapping(value="/",method=RequestMethod.POST)
	//POST로 접근하는 매핑주소를 처리
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo){
		//@RequestBody MessageVO vo는 json(키,값 쌍구조)데이터를 MessageVO 객체타입
		//으로 변경
		ResponseEntity<String> entity=null;
		
		try {
			this.messageService.addMessage(vo);
			entity=new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}










