package org.zerock.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.service.AdminService;
import org.zerock.vo.AdminVO;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	//관리자 로그인 폼
	@GetMapping("/admin_index") //get으로 접근하는 매핑주소를 처리
	public ModelAndView admin_index() {
		ModelAndView am=new ModelAndView();
		am.setViewName("admin/admin_index");
		//뷰리졸브 경로=> /WEB-INF/views/admin/admin_index.jsp
		return am;
/* 뷰페이지 경로가 /WEB-INF 로 잡힌 이유는 JSP파일이 GET방식으로 직접 웹브라우저 주소창에서 실행
 * 되지 않는다.->보안효과 		
 */
	}
	
	//관리자 로그인 인증
	@PostMapping("/admin_login_ok")
	//post로 접근하는 매핑주소 처리
	public String admin_loign_ok(AdminVO ab,
			HttpServletResponse response,HttpSession session)
	throws Exception{
/* 1. AdminVO ab는 빈클래스 변수명과 admin_index.jsp의 네임피라미터 이름이 같으면 ab에 
 * 관리자 아이디와 비번이 저장됨.
 * 2. HttpServletResponse는 서버의 가공된 정보를 사용자 웹브라우저에 응답할 때 사용
 * 3. session은 서버에서 사용되며 보안성이 우수하고 로그인 인증과 로그아웃할 때 사용함.		
 */
		response.setContentType("text/html;charset=UTF-8");
		//웹브라우저에 출력되는 문자,태그,언어코딩 타입을 지정
		PrintWriter out=response.getWriter();//출력스트림 객체 out생성
		
		AdminVO admin_pwd=this.adminService.admin_Login(ab.getAdmin_id());
		//관리자 아이디를 기준으로 데이터베이스로 부터 관리자 정보를 가져옴.
		
		/* 문제) 서비스,모델 DAO,mybatis매퍼태그까지 admin_Login()메서드를
		 * 완성하시오.(시간은 20분=>개발자 테스트와 디버깅)
		 */
		
		if(admin_pwd == null) {
			out.println("<script>");
			out.println("alert('관리자 정보가 없습니다!');");
			out.println("history.back();");//history는 자바스크립트에서 이전 주소
			//정보를 담고 있는 과거형 객체이다.back()메서드로 이전으로 이동. go(-1)과 같다
			out.println("</script>");
		}else {
            if(!admin_pwd.getAdmin_pwd().equals(ab.getAdmin_pwd())) {
            	out.println("<script>");
            	out.println("alert('관리자 비번이 다릅니다!');");
            	out.println("history.go(-1);");
            	out.println("</script>");
            }else {
            	//System.out.println("관리자 로그인 성공!");
            	session.setAttribute("admin_id",ab.getAdmin_id());
            	//admin_id 세션키이름에 관리자 아이디를 저장=>세션은 웹사이트 전체에 영향을
            	//미치는 전역변수처럼 사용된다.
           	session.setAttribute("admin_name",admin_pwd.getAdmin_name());
           	//관리자이름 저장
           	return "redirect:/admin_main";//관리자 메인으로 이동
            }
		}
		return null;
	}//admin_login_ok()
	
	//관리자 메인화면
    @RequestMapping("/admin_main")
    public String admin_main(HttpServletResponse response,
    		HttpSession session) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        
        String admin_id=(String)session.getAttribute("admin_id");
        //세션키이름에 문자열 관리자 아이디값은 자바 최상위 조상클래스 Object타입으로 업캐스팅
        //을 해서 저장되었다.다운캐스팅은 업캐스팅을 한것에 한해서만 허용.
        
        if(admin_id == null) {
        	out.println("<script>");
        	out.println("alert('다시 로그인 하세요!');");
        	out.println("location='admin_index';");
        	out.println("</script>");
        }else {//관리자 로그인 이후
        	return "admin/admin_main";// /WEB-INF/views/admin/admin_main
        	//.jsp
        }
    	return null;
    }//admin_main()
    
    //관리자 로그아웃
    @RequestMapping("/admin_logout")
    public String admin_logout(HttpServletResponse response,
    		HttpSession session) throws Exception{
    	response.setContentType("text/html;charset=UTF-8");
    	//웹브라우저에 응답하는 문자,HTML태그,언어코딩 타입 설정
    	PrintWriter out=response.getWriter();
    	
    	session.invalidate();//세션 만료
    	
    	out.println("<script>");
    	out.println("alert('관리자가 로그아웃 되었습니다!');");
    	out.println("location='admin_index';");
    	out.println("</script>");
    	
    	return null;
    }
}



