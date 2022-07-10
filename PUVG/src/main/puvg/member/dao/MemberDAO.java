package main.puvg.member.dao;

import java.util.List;

import main.puvg.member.vo.MemberVO;

public interface MemberDAO {
	public List<MemberVO> MemberSelect(MemberVO mvo);
	public int MemberInsert(MemberVO mvo);
	public List<MemberVO> MemberSelectAll(MemberVO mvo);
	public int MemberUpdatepw(MemberVO mvo);
}
