package org.zerock.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.service.AdminGongjiService;
import org.zerock.vo.GongjiVO;

@Controller
public class AdminGongjiController {
	
	@Autowired
	private AdminGongjiService adminGongjiService;
	
	//관리자 공지작성
	@GetMapping("/admin_gongji_write")
	public ModelAndView admin_gongji_write(HttpServletResponse response,
			HttpSession session) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String admin_id=(String)session.getAttribute("admin_id");
		if(admin_id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("location='admin_index';");
			out.println("</script>");
		}else {//관리자로 로그인 된 상태
        	ModelAndView gm=new ModelAndView("admin/admin_gongji_write");
       	//뷰리졸브 경로(뷰페이지 경로)->/WEB-INF/views/admin/admin_gongji_write
        	return gm;
		}
		return null;
	}//admin_gongji_write()
	
	//관리자 공지저장
	@RequestMapping("/admin_gongji_write_ok")
	public String admin_gongji_write_ok(GongjiVO g,
			HttpServletResponse response,HttpSession session)
	throws Exception{
/* admin_gongji_write.jsp의 네임피라미터 이름과 GongjiVO.java의 변수명이 같으면 Gongji
 * VO g의 g객체에 작성자,제목,비번,공지내용이 저장됨. 		
 */
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String admin_id=(String)session.getAttribute("admin_id");
        
        if(admin_id == null) {
          out.println("<script>");
          out.println("alert('다시 로그인 하세요!');");
          out.println("location='admin_index';");
          out.println("</script>");
        }else {
        	this.adminGongjiService.insertG(g);//관리자 공지저장
        	/*문제) 서비스,DAO,매퍼태그까지 완성하세요. 
        	 */
        	System.out.println("관리자 공지저장 성공!");
        }
		return null;
	}//admin_gongji_write_ok()
}



























