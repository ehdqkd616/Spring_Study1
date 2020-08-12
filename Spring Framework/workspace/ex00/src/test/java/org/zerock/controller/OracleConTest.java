package org.zerock.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConTest {

	private static final String DRIVER="oracle.jdbc.OracleDriver";
	//ojdbc9.jar 오라클 jdbc라이브러리 압축파일에 있는 oracle.jdbc는 패키지폴더명
	//OracleDriver 오라클 jdbc드라이버 클래스명.
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	//오라클 접속주소, 1521은 오라클 접속포트번호, xe는 데이터베이스 명
	private static final String USER="night";//오라클 접속 사용자
	private static final String PW="night";//오라클 사용자 비번
	
	@Test
	public void testCon() throws Exception{
		Class.forName(DRIVER);//JDBC드라이버 클래스 로드
		try(Connection con=DriverManager.getConnection(URL, USER, PW))
		{
			System.out.println(con);
		}catch(Exception e) {e.printStackTrace();}
/* jdk1.7이후부터는 Connection이 AutoCloseable인터페이스를 상속받았기 때문에 try()에서
 * 데이터베이스 연결 con을 생성하면 finally문에서 명시적으로 close()하지 않아도 알아서 자동으로 닫힌다.
 */
	}//junit 연습
}

