package org.zerock.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession; //mybatis 쿼리문 수행객체를 생성

	@Override
	public void insertBoard(BoardVO b) {
		this.sqlSession.insert("b_in",b);
		/* 1.mybatis에서 insert()메서드는 레코드를 저장시킨다.
		 * 2.레코드란 데이터베이스 용어로서 테이블 컬럼(필드)명에 저장된 한행의 자료집합을 말함.
		 * 3.b_in은 board.xml에서 설정할 유일한 insert 아이디명.
		 */
	}

	@Override
	public int getRowCount() {
		return this.sqlSession.selectOne("b_count");
		/* 1.mybatis 에서 b_count는 board.xml에서 설정할 유일한 select아이디명 
		 * 2.mybatis 에서 selectOne()메서드는 단 한개의 레코드만을 반환해 준다.
		 */
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return this.sqlSession.selectList("b_list", b);
		/* 1. mybatis에서 selectList()메서드는 하나이상의 레코드를 검색해서 컬렉션 List
		 * 로 반환한다.
		 * 2.b_list는 board.xml 에서 설정한 유일한 select아이디명
		 */

	}//게시물 목록

	@Override
	public void updateHit(int bno) {
		this.sqlSession.update("b_hit",bno);
		/* 1. mybatis 에서 레코드를 수정할때는 update()메서드를 사용한다.
		 * 2. b_hit는 유일한 board.xml에 설정할 update 아이디명.
		 */
	}//조회수 증가

	@Override
	public BoardVO getCont(int bno) {
		return this.sqlSession.selectOne("b_cont", bno);
	}//게시물 내용보기 

	@Override
	public void editBoard(BoardVO eb) {
		sqlSession.update("b_edit", eb);
		/* 1.this.은 생략가능하다.
		 * 2.mybatis에서 update()메서드는 레코드 수정한다.
		 * 3.b_edit는 board.xml에 설정할 유일한 update 아이디명
		 */
	}//게시물 수정완료

	@Override
	public void delBoard(int bno) {
		sqlSession.delete("b_del", bno);
		/* 1.delete()메서드는 mybatis에서 레코드 삭제시킨다.
		 * 2.b_del은 delete 유일 아이디명
		 */
	}//게시물 삭제

	@Override
	public void updateReplyCnt(int bno, int count) {
		Map<String, Object> pm = new HashMap<>();	
		
		pm.put("bno", bno); //board.xml에서 키이름을 참조해서 게시물 번호값을 가져옴.\
		pm.put("count", count);
		
		this.sqlSession.update("cnt",pm);

	}//댓글 카운터 추가

	
}
