package main.puvg.util.dao;

import main.puvg.approval.vo.Appr1DocVO;
import main.puvg.approval.vo.ApprovalTempVO;
import main.puvg.member.vo.MemberVO;

public interface ChabunDAO {
	public MemberVO getMemberChabun();
	public Appr1DocVO getApprovalChabun();
	public ApprovalTempVO getApprovalTempChabun();
}
