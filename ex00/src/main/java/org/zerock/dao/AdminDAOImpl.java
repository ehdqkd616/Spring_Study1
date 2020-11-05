package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.AdminVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public AdminVO admin_Login(String admin_id) {
		return this.sqlSession.selectOne("admin_login",admin_id);
	}//관리자 로그인 인증	
}
