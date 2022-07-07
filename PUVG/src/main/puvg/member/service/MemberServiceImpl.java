package main.puvg.member.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.puvg.member.dao.MemberDAO;
import main.puvg.member.vo.MemberVO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	Logger logger = LogManager.getLogger(MemberServiceImpl.class);
	
	@Autowired(required=false)
	private MemberDAO memberDAO;
	
	public List<MemberVO> MemberSelect(MemberVO mvo){
		logger.info("MemberServiceImpl.MemberSelect() 진입");
		return memberDAO.MemberSelect(mvo);
	}
	
	public int MemberInsert(MemberVO mvo) {
		logger.info("MemberServiceImpl.MemberInsert() 진입");
		return memberDAO.MemberInsert(mvo);
	}

}
