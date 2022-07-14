package main.puvg.util.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.puvg.approval.vo.Appr1DocVO;
import main.puvg.approval.vo.ApprovalTempVO;
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

	@Override
	public Appr1DocVO getApprovalChabun() {
		logger.info("ChabunServiceImpl.getApprovalChabun() 진입");
		return chabunDAO.getApprovalChabun();
	}

	@Override
	public ApprovalTempVO getApprovalTempChabun() {
		logger.info("ChabunServiceImpl.getApprovalTempChabun() 진입");
		return chabunDAO.getApprovalTempChabun();
	}
}