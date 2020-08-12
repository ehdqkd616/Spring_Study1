package org.zerock.service;

import java.util.List;

import org.zerock.vo.ReplyVO;

public interface ReplyService {

	void addReply(ReplyVO vo);
	List<ReplyVO> listReply(int bno);
	void updateReply(ReplyVO vo);
	void remove(int rno); //public abstract 예약어가 생략된 추상메서드, 추상메서드는 {}
	//가 없고, 실행문장이 없고, 호출이 불가능.
	
}
