package org.zerock.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.dao.BoardDAO;
import org.zerock.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired //자동의존성 주입(DI)
	private BoardDAO boardDao;
	
	@Override
	public void insertBoard(BoardVO b) {
		this.boardDao.insertBoard(b);
	}

	@Override
	public int getRowCount() {
		return this.boardDao.getRowCount();
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return this.boardDao.getBoardList(b);
	}
	
	//스프링의 aop를 통한 트랜잭션을 적용해서 자료일치(일관성을 유지)
	@Transactional(isolation = Isolation.READ_COMMITTED)
	//트랜잭션 격리(트랜잭션이 처리되는 중간에 외부간섭을 없앰)
	@Override
	public BoardVO getCont(int bno) {
		this.boardDao.updateHit(bno); //조회수 증가
		return this.boardDao.getCont(bno); //오라클로 부터 게시물 내용을 가져오기.
	}//조회수 증가와 게시물 내용보기

	@Override
	public BoardVO getCont2(int bno) {
		return this.boardDao.getCont(bno);
	}//게시물 내용 가져오기

	@Override
	public void editBoard(BoardVO eb) {
		this.boardDao.editBoard(eb);
	}//게시물 수정

	@Override
	public void delBoard(int bno) {
		this.boardDao.delBoard(bno);
	}//게시물 삭제완료
	
}




