package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.dao.AdminGongjiDAO;
import org.zerock.vo.GongjiVO;

@Service
public class AdminGongjiServiceImpl implements AdminGongjiService {

	@Autowired
	private AdminGongjiDAO adminGongjiDAO;

	@Override
	public void insertG(GongjiVO g) {
	   this.adminGongjiDAO.insertG(g);			
	}	
}
