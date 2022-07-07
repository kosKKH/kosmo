package main.puvg.util.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.puvg.member.vo.MemberVO;
import main.puvg.util.dao.ChabunDAO;

@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	Logger logger = LogManager.getLogger(ChabunServiceImpl.class);
	
	@Autowired(required=false)
	private ChabunDAO chabunDAO;
	
	public MemberVO getMemberChabun() {
		logger.info("ChabunServiceImpl.getMemberChabun() 진입");
		return chabunDAO.getMemberChabun();
	}
}
