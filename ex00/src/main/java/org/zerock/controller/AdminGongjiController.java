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
	
	//������ �����ۼ�
	@GetMapping("/admin_gongji_write")
	public ModelAndView admin_gongji_write(HttpServletResponse response,
			HttpSession session) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String admin_id=(String)session.getAttribute("admin_id");
		if(admin_id == null) {
			out.println("<script>");
			out.println("alert('�ٽ� �α��� �ϼ���!');");
			out.println("location='admin_index';");
			out.println("</script>");
		}else {//�����ڷ� �α��� �� ����
        	ModelAndView gm=new ModelAndView("admin/admin_gongji_write");
       	//�丮���� ���(�������� ���)->/WEB-INF/views/admin/admin_gongji_write
        	return gm;
		}
		return null;
	}//admin_gongji_write()
	
	//������ ��������
	@RequestMapping("/admin_gongji_write_ok")
	public String admin_gongji_write_ok(GongjiVO g,
			HttpServletResponse response,HttpSession session)
	throws Exception{
/* admin_gongji_write.jsp�� �����Ƕ���� �̸��� GongjiVO.java�� �������� ������ Gongji
 * VO g�� g��ü�� �ۼ���,����,���,���������� �����. 		
 */
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String admin_id=(String)session.getAttribute("admin_id");
        
        if(admin_id == null) {
          out.println("<script>");
          out.println("alert('�ٽ� �α��� �ϼ���!');");
          out.println("location='admin_index';");
          out.println("</script>");
        }else {
        	this.adminGongjiService.insertG(g);//������ ��������
        	/*����) ����,DAO,�����±ױ��� �ϼ��ϼ���. 
        	 */
        	System.out.println("������ �������� ����!");
        }
		return null;
	}//admin_gongji_write_ok()
}



























