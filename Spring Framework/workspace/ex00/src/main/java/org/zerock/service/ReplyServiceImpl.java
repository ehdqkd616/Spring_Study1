package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.dao.BoardDAO;
import org.zerock.dao.ReplyDAO;
import org.zerock.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replyDao;
	
	@Autowired
	private BoardDAO boardDao;
	
	@Transactional //AOP를 통한 트랜잭션 적용
	@Override
	public void addReply(ReplyVO vo) {
		this.replyDao.addReply(vo);
		this.boardDao.updateReplyCnt(vo.getBno(),1); //댓글로부터 게시물 번호값을
		//구해서 댓글이 추가되면 댓글 개수 카운터 1증가
	}

	@Override
	public List<ReplyVO> listReply(int bno) {
		return this.replyDao.listReply(bno);
	}

	@Override
	public void updateReply(ReplyVO vo) {
		this.replyDao.updateReply(vo);
	}

	@Transactional
	@Override
	public void remove(int rno) {
		int bno=this.replyDao.getBno(rno);//댓글번호로 게시판번호값을 구함.
		this.replyDao.remove(rno);
		this.boardDao.updateReplyCnt(bno, -1);
	}//댓글이 삭제되면 댓글 개수 1감소
	/* 문제) 1.board_list_jsp 게시물 목록 제목 옆에 다음과 같이 출력되게 한다.
	 * 제목입니다.[댓글개수 : 00개], 댓글개수 : 00개 부분은 <Strong>태그 혹은 <b>를
	 * 사용하여 진하게 출력하자.
	 * 
	 * 2.board.cont.jsp에서 다음 뷰페이지도 완성한다.
	 *   <br/>
	 *   [댓글개수 : <b>00</b> 개]
	 *   <br/>
	 */
}



