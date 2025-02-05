package org.zerock.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class DataSourceTest {
	
	@Inject //자동의존성 주입 -> ds참조변수에 객체 주소를 외부에서 의존해서 주입하여 실제 
	//사용할 수 있게 해줌.
	private DataSource ds;
	
	/* 스프링에서 의존성(DI) 주입하는 방법)
	 * 1. setter() 메서드를 통한 의존성 주입
	 * 2. 생성자를 통한 의존성 주입
	 */

	@Test
	public void testCon() throws Exception{
		try(Connection con=ds.getConnection()){
			System.out.println(con);
		}catch(Exception e) {e.printStackTrace();}
	}
	
}
