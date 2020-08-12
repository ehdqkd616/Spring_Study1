package org.zerock.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.MemberVO;

@Repository //@Repository 애노테이션은 DAO를 스프링에서 인식하게 한다.
public class MemeberDAOImpl implements MemberDAO {
	
	@Autowired //자동의존성 주입(DI)
	private SqlSession sqlSession; //mybatis 쿼리문 수행객체 생성

	@Override
	public void insertM(MemberVO m) {
		this.sqlSession.insert("m_in", m);
		/* 1.mybatis에서 insert() 메서드는 레코드를 저장시킨다.
		 * 2.레코드란 테이블 컬럼(필드)에 저장된 한행의 자료집합을 뜻한다.
		 * 3.m_in은 member.xml에 설정된 insert매퍼태그의 유일아이디명.
		 */
		
	}
		
}
	