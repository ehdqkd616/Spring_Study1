package org.zerock.service;


import java.util.List;

import org.zerock.vo.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO b);
	int getRowCount();
	List<BoardVO> getBoardList(BoardVO b);
	BoardVO getCont(int bno);
	BoardVO getCont2(int bno);
	void editBoard(BoardVO eb);
	void delBoard(int bno);
	/* 인터페이스 특징)
	 * 1.인터페이스에 오는 추상메서드는 public abstract으로 인식된다.
	 * 2.추상메서드는 {}가 없고, 실행문장이 없어서 호출불가능. 인터페이스는 객체생성을 못함.
	 * 3.인터페이스에 오는 추상메서드는 이 인터페이스를 구현상속받은 자손클래스에서 반드시 오버라이딩
	 * 을 해야 자손클래스로 객체생성을 할 수 있다.
	 */
}
