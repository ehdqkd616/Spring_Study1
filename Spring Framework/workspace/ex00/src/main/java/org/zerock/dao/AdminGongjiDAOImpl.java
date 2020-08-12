package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.GongjiVO;

@Repository
public class AdminGongjiDAOImpl implements AdminGongjiDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertG(GongjiVO g) {
		sqlSession.insert("ag_in",g);		
	}//관리자 공지저장	
}




