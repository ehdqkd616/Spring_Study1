package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Autowired //자동의존성 주입
	private SqlSession sqlSession; //mybatis 쿼리문 수행객체 생성

	@Override
	public void create(MessageVO vo) {
	  this.sqlSession.insert("m_in2",vo);			
	}	
}
