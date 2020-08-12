package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.dao.MessageDAO;
import org.zerock.dao.PointDAO;
import org.zerock.vo.MessageVO;

@Service
public class MessageServivceImpl implements MessageService {

	@Autowired
	private MessageDAO messageDao;
	
	@Autowired
	private PointDAO pointDao;
	
	//aop를 통한 트랜잭션 적용
	@Transactional
	@Override
	public void addMessage(MessageVO vo) {
		this.messageDao.create(vo);
		this.pointDao.updatePoint(vo.getSender(),10); //메시지를 보낸사람에게
		//포인트 점수 10점 업데이트
	}

}
