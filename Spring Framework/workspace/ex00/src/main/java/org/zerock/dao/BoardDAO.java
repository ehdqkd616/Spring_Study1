package org.zerock.dao;


import java.util.List;

import org.zerock.vo.BoardVO;

public interface BoardDAO {

	void insertBoard(BoardVO b);
	int getRowCount();
	List<BoardVO> getBoardList(BoardVO b);
	void updateHit(int bno);
	BoardVO getCont(int bno);
	void editBoard(BoardVO eb);
	void delBoard(int bno);
	void updateReplyCnt(int bno, int count);
}
