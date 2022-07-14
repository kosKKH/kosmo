package main.puvg.util.service;

import main.puvg.approval.vo.Appr1DocVO;
import main.puvg.approval.vo.ApprovalTempVO;
import main.puvg.member.vo.MemberVO;

public interface ChabunService {
	public MemberVO getMemberChabun();
	public Appr1DocVO getApprovalChabun();
	public ApprovalTempVO getApprovalTempChabun();
}