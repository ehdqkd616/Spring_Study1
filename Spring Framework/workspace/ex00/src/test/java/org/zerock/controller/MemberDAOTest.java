package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dao.MemberDAO;
import org.zerock.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class MemberDAOTest {

	@Inject //자동의존성 주입
	private MemberDAO memberdao;
	
	@Test
	public void insertMember() throws Exception{
		MemberVO m = new MemberVO();
		m.setUserid("asdf");//회원아이디 저장
		m.setUserpw("123");//비번저장
		m.setUsername("김연우");//이름저장
		m.setEmail("rudy@instargram.com");//이메일저장
		
		memberdao.insertM(m);//회원저장
	}
	
}
