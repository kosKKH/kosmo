package main.puvg.member.service;

import java.util.List;

import main.puvg.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> MemberSelect(MemberVO mvo);
	public int MemberInsert(MemberVO mvo);
}
