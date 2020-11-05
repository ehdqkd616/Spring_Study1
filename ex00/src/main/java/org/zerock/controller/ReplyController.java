package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.ReplyService;
import org.zerock.vo.ReplyVO;

@RestController
@RequestMapping("/replies") //컨트롤러 자체에 매핑주소 등록
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	//댓글 등록
	@RequestMapping(value="", method=RequestMethod.POST)
	//post방식으로 접근하는 매핑주소를 처리하는 애노테이션
	public ResponseEntity<String> register(@RequestBody ReplyVO vo){
/* 1. @RequestBody 애노테이션은 전송된 JSON 데이터를 객체로 변환한다. 데이터 전송방식은
 * JSON을 이용한다. JSON으로 보내진 데이터를 ReplyVO 타입으로 변환한다.
 */
		ResponseEntity<String> entity=null;
		try {
			this.replyService.addReply(vo); //댓글 등록
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			//댓글저장 성공시 정상코드 200반환, 
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),
					HttpStatus.BAD_REQUEST);
//예외 오류가 발생했을때 나쁜 상태코드 문자열을 반환
		}
		return entity;	
	}
	
	//게시물 번호에 해당하는 댓글목록
	@RequestMapping(value="/all/{bno}",method=RequestMethod.GET)
	//get으로 접근하는 매핑주소 처리
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") int bno) {
		/* @PathVariable("bno")은 매핑주소의 게시물 번호값을 추출하는 용도로 활용됨.
		 */
		ResponseEntity<List<ReplyVO>> entity=null;
		try {
			entity = new ResponseEntity<>(this.replyService.listReply(bno),
					HttpStatus.OK);
			//게시물 번호헤 해당하는 댓글목록을 반환
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//list()
	
	//댓글 수정
	@RequestMapping(value="/{rno}", method= {RequestMethod.PUT,
			RequestMethod.PATCH})
	//PUT은 전체자료를 수정, PATCH는 일부자료만 수정
	public ResponseEntity<String> update(@PathVariable("rno") int rno,
			@RequestBody ReplyVO vo){
		
		ResponseEntity<String> entity=null;
		try {
			vo.setRno(rno); //댓글 번호 저장
			this.replyService.updateReply(vo); //댓글 수정
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
		return entity;	
	}//update()
	
	//댓글 삭제
	@RequestMapping(value="{rno}", method=RequestMethod.DELETE)
	//DELETE 방식은 댓글 삭제
	public ResponseEntity<String> remove(@PathVariable("rno") int rno)
	{		
		ResponseEntity<String> entity=null;
		try {
			this.replyService.remove(rno); //댓글 삭제
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
		return entity;	
	}//delete()
	
	
	
}




