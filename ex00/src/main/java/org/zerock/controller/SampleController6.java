package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.vo.SampleVO;

@RestController //스프링 4.0 이후부터 이 애노테이션으로 jsp뷰페이지를 직접 만들지 않고도,
//Rest 방식의 데이터를 처리하기 위해서 사용하는 애노테이션이다. 만들어 지는 데이터는 문자열,xml,json
@RequestMapping("/sample") //컨트롤러 자체에 매핑주소 등록
public class SampleController6 {

	@RequestMapping("/hello") //hello 매핑주소 등록
	//get or post 방식을 처리
	public String hello() {
		return "rest Begin";//문자열 결과값이 반환.
	}
	
	@RequestMapping("sendVO") //sendVO 매핑주소 등록
	public SampleVO sendVO() {
	//반환 타입이 SampleVO이면 변수명이 json객체의 키이름이 된다.
		/* 매핑주소 sendVO만 입력하면 XML데이터로 출력된다. 이것을 키, 값쌍의 JSON 데이터를 보기
		 * 위해서는 sendVO.json(JSON)를 입력하면 된다.
		 */
		SampleVO vo = new SampleVO();
		vo.setMno(10); vo.setFirstName("홍"); vo.setLastName("길동");
		
		return vo;
	}
	
	@RequestMapping("/sendList")
	public List<SampleVO> sendList(){
/* java.util패키지의 컬렉션 List인터페이스 특징)
 *  1.가변적인 크기의 복수개의 데이터를 한꺼번에 저장하기 위한 컬렉션 자료구조이다.
 *  2.복수개의 원소값을 순서있게 저장하고, 중복원소값을 허용한다. 원래 컬렉션은 복수개의 자료형을
 *  동시에 저장할 수 있다. 이것은 여러개의 자료형이 동시 저장되다 보니 자료의 안정성이 떨어지고 원하는 자료
 *  추출이 어렵다. 그래서 jdk1.5 이후에 컬렉션에 제네릭 문법이 추가되어서 <SampleVO> 타입만 저장
 *  가능하게 되었다.
 */
		List<SampleVO> list = new ArrayList<>(); //업캐스팅 하면서 컬렉션 제니릭
		//list를 생성하고, 뒷부분<> 제네릭타입을 생략할 수 있는 것은 jdk 1.7부터 가능하다.
		
		for(int i=0; i<=10; i++) {
			SampleVO vo = new SampleVO();
			vo.setMno(i);
			vo.setFirstName("이");
			vo.setLastName("순신");
			
			list.add(vo);
		}//for
		return list;
	}
	
	//키, 값 쌍의 사전적인 Map타입 JSON
	@GetMapping("/sendMap") //sendMap 매핑주소등록
	public Map<Integer,SampleVO> sendMap(){
		Map<Integer,SampleVO> map = new HashMap<>();
/* java.util Map컬렉션 인터페이스 자료구조 특징)
 *  1.키, 값 쌍으로 저장하는 사전적인 자료구조이다.
 *  2.키를 통해서 값을 검색하기 때문에 검색속도가 빠르다.
 *  3.jdk 1.2에서 추가됨.
 */
		for(int i=1; i<=5; i++) {
			SampleVO vo = new SampleVO();
			
			vo.setMno(i); vo.setFirstName("이");
			vo.setLastName("순신");
			
			map.put(i,vo);
/* i키값은 오토언박싱(jdk1.5에서 추가된 문법으로 래퍼타입이 기본타입으로 형변환) 되면서 저장함.
 */
		}//for
		return map;
	}
	
	@RequestMapping("/sendError")
	public ResponseEntity<Void> sendError(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
/* 1.RestController 별도의 뷰페이지를 만들지 않고도 Rest서비스를 실행할 수 있기 때문에, 결과
 * 데이터에 대한 예외적인 상황에서 문제가 발생할 수 있다. 스프링에서 제공하는 ResponseEntity
 * 타입은 개발자가 문제가 되는 나쁜상태 404,500과 같은 Http 나쁜상태코드를 전송할 수 있기 때문에
 * 좀 더 세밀한 제어가 필요한 경우 사용된다. 200상태 전송은 정상적으로 데이터가 처리되었다는 뜻.
 * BAD_REQUEST는 400 나쁜상태코드이다.
 */
	}

	//정상적인 데이터와 404(자원또는 파일을 찾지 못했을때 발생하는 나쁜 상태코드)를 동시에 전송
	@RequestMapping("/sendNot")
	public ResponseEntity<List<SampleVO>> sendNot(){
		List<SampleVO> list=new ArrayList<>();
	
		for(int i=1;i<=3;i++) {
			SampleVO vo=new SampleVO();
			vo.setMno(i);
			vo.setFirstName("홍");
			vo.setLastName("길동");
        
			list.add(vo);//컬렉션에 추가            
		}//for
		return new ResponseEntity<List<SampleVO>>(list,
				HttpStatus.NOT_FOUND);
		
	}//구글 크롬 웹브라우저에서 F12 개발자도구 콘솔 또는 네트워크에서 404에러코드를 확인가능함.
}



