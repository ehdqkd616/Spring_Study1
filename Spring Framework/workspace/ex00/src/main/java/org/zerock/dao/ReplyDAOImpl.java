package org.zerock.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	private SqlSession sqlSession; //sqlSession은 mybatis쿼리문 수행객체

	@Override
	public void addReply(ReplyVO vo) {
		this.sqlSession.insert("reply_in", vo);
		/* 1.insert()메서드는 mybatis에서 쿼리문 수행메서드, reply_in은 reply.xml에서
		 * 설정할 insert 유일아이디명
		 */
	}//댓글 등록

	@Override
	public List<ReplyVO> listReply(int bno) {
		return this.sqlSession.selectList("reply_list", bno);
		/* 1.selectList()는 mybatis에서 한개 이상의 자료를 데이터베이스로 부터 검색해서
		 * 컬렉션 List로 반환한다.
		 * 2.reply_list는 reply.xml에서 설정할 유일한 select아이디명이다.
		 */
	}//댓글 목록

	@Override
	public void updateReply(ReplyVO vo) {
		this.sqlSession.update("reply_edit", vo);
		/* 1.reply_edit는 reply.xml 에서 설정할 유일한 아이디명
		 * 2.update()메서드는 레코드 수정한다.
		 */
	}//댓글 수정


	@Override
	public void remove(int rno) {
       this.sqlSession.delete("r_del",rno);
       /* 1.delete()메서드는 레코드 삭제
        * 2.r_del은 유일한 delete 아이디명
        */
	}//댓글 삭제

	@Override
	public int getBno(int rno) {
		return this.sqlSession.selectOne("reply_bno",rno);
		//selectOne()메서드는 mybatis에서 단 한개의 레코드만을 검색
	}
}




