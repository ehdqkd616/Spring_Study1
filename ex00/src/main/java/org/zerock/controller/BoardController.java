package org.zerock.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.service.BoardService;
import org.zerock.vo.BoardVO;

@Controller
@RequestMapping("/board/*") //컨트롤러 자체에 매핑주소 등록
public class BoardController {

	@Inject //의존성 주입(DI)
	private BoardService boardService;
	
	//게시판 글쓰기
	@GetMapping("/board_write") //get으로 접근하는 매핑주소 처리.board_write
	//매핑주소 등록
	public String board_write(HttpServletRequest request) {
		int page=1;
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", page); //page키 이름에 쪽번호 저장 => 페이징에서
		//책갈피 기능
		return "board/board_write";//뷰리졸브 경로 => /WEB/INF/views/
		//board/board_write.jsp
	}//board_write()
	
	//게시판 저장
	@PostMapping("/board_write_ok") //post로 접근하는 매핑주소를 처리. 
	//board_write_ok 매핑주소 등록
	public ModelAndView board_write_ok(BoardVO b,
			RedirectAttributes rttr) throws Exception{
/* BoardVO b는 board_write.jsp의 네임파라미터 이름과 BoardVO.java의 변수명이 일치하면
 * b객체에 글쓴이, 제목, 내용이 함께 저장되어 있다.
 */
		this.boardService.insertBoard(b);//게시물을 저장
		rttr.addFlashAttribute("msg","success");
		/* msg키 이름에 success문자열을 담아서 다른 매핑주소로 전달한다. 이 방법은 웹주소창에
		 * 자료 노출이 되지 않아서 보안상 좋다.
		 */
		ModelAndView wm = new ModelAndView("redirect:/board/board_list");
		return wm; //게시물을 저장하고 다른 매핑주소인 목록보기 board_list로 이동시킴
	}
	
	//게시물 목록보기
	@RequestMapping(value="/board_list",
			method=RequestMethod.GET) //GET으로 접근하는 매핑주소를 처리.
	//board_list매핑주소 등록
	public void board_list(Model m, HttpServletRequest request,
			@ModelAttribute BoardVO b) throws Exception{
 /* 1. 메서드 반환타입이 없는 void형이면 해당 매핑주소가 jsp파일명이 된다.
  * 2. HttpServletRequest 서블릿 api는 사용자폼에서 입력한 정보를 서버로 가져오는 역할을 한다.
  * 3. @ModelAttribute BoardVO b는 b객체 생성 효과가 난다.
  */
		/*페이징 추가코드 */
		int page=1; //현재 쪽번호
		int limit=10; //한페이지에 보여지는 목록개수
		if(request.getParameter("page") != null) {
			//get으로 전달된 페이지 번호가 있는 경우 실행
			page=Integer.parseInt(request.getParameter("page"));
			//페이지번호값을 정수 숫자로 바꿔서 저장
		}
		b.setStartrow((page-1)*10+1); //시작행 번호
		b.setEndrow(b.getStartrow()+limit-1); //끝행번호
		
		int totalCount = this.boardService.getRowCount(); //총게시물 수
		System.out.println("총 게시물 수 : "+totalCount+"개");
		List<BoardVO> blist=this.boardService.getBoardList(b); //게시물 목록
/* 1.java.util 패키지의 컬렉션 인터페이스 List는 복수개의 원소값을 순서있게 저장하고, 중복원소값을
 * 허용하는 가변적인 배열 즉 컬렉션이다. 하지만 컬렉션은 복수개의 타입을 동시 저장하다 보니 자료의 안정성이
 * 떨어지고 원하는 타입 추출이 어렵다. 그래서 jdk1.5에서 추가된 <BoardVO>제네릭타입이 새롭게 추가되어서
 * BoardVO타입만 저장가능하다.
 */
		System.out.println("게시물 목록 : "+blist.size()+"개");
		
		/* 페이징(쪽나누기) */
		//총 페이지 수
		int maxpage=(int)((double)totalCount/limit+0.95);
		//시작 페이지
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		//마지막 페이지
		int endpage = maxpage;
		if(endpage > startpage+10-1) {
			endpage = startpage+10-1;
		}
		
    	m.addAttribute("blist", blist);//blist키이름에 목록을 저장
    	m.addAttribute("totalCount", totalCount);//totalCount키이름에 총게시물
    	m.addAttribute("startpage", startpage);
    	m.addAttribute("endpage", endpage);
    	m.addAttribute("maxpage", maxpage);
    	m.addAttribute("page", page);//현재 쪽(페이지)번호 저장
    	//수 저장
    }//board_list()
	
	//게시물 내용보기+조회수증가
	@RequestMapping("/board_cont") //get or post로 전달되는 매핑주소를 처리
	//board_cont매핑주소 등록
	public ModelAndView board_cont(@RequestParam("bno") int bno, int page) {
/* @RequestParam("bno"는 서블릿 또는 jsp코드의 request.getParameter("bno")와
 * 같다. get으로 전달된 bno파라미터이름의 번호값을 가져온다.
 */
    	BoardVO b=this.boardService.getCont(bno);
    	//오라클로 부터 게시물 내용을 가져오고,동시에 조회수 증가
    	
    	ModelAndView cm=new ModelAndView();
    	cm.addObject("b",b);//b키이름에 b객체를 저장
    	cm.addObject("page", page);//책갈피 기능때문에 page키이름에 쪽번호를 저장
    	cm.setViewName("board/board_cont");//뷰페이지 경로=>/WEB-INF/views/
    	//board/board_cont.jsp
    	return cm;
    }//board_cont()
	
	//수정폼
	@GetMapping("/board_edit") //get으로 전달된 매핑주소 처리, board_edit매핑주소
	//등록 
	public ModelAndView board_edit(int bno, int page) {
/* int bno매개변수로 처리하면 get으로 전달된 번호값을 가져올 수 있다.
 */
		BoardVO b = this.boardService.getCont2(bno);
		ModelAndView em = new ModelAndView("board/board_edit");
		//생성자 인자값으로 뷰페이지 경로 설정
		em.addObject("b", b);
		em.addObject("page", page);
		return em;
	}//board_edit()
	
    //수정완료
    @RequestMapping(value="/board_edit_ok",
    		method=RequestMethod.POST)
    //post로 전달되는 매핑주소를 처리
    public String board_edit_ok(@ModelAttribute BoardVO eb,
    		RedirectAttributes rttr, int page) {
/* @ModelAttribute BoardVO eb는 board_edit.jsp의 네임파라미터 이름과 BoardVO.java
 * 의 변수명이 일치하면 eb객체에 히든번호값,수정한 작성자,제목,내용이 저장되어 있다.     	
 */
    	this.boardService.editBoard(eb);//게시물 수정
    	rttr.addFlashAttribute("msg","success");
    	
    	return "redirect:/board/board_list?page="+page;
    	//board_list?page=쪽번호값이 get방식으로 전달되면서 수정한 값을 해당 쪽번호에서 확인
    }//board_edit_ok()
    
    //게시물 삭제
    @GetMapping("/board_del") //get으로 접근하는 매핑주소를 처리,
    // board_del매핑주소 등록
    public ModelAndView board_del(int bno,RedirectAttributes rttr) {
/* int bno매개변수로 자바스크립트 location객체에 의해서 전달된 번호값을 가져온다.     	
 */
    	this.boardService.delBoard(bno);//게시물 삭제
    	rttr.addFlashAttribute("msg","success");
    	return new ModelAndView("redirect:/board/board_list");
    }//board_del()
}










