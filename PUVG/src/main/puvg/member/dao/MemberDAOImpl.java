package main.puvg.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.puvg.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	public List<MemberVO> MemberSelect(MemberVO mvo){
		return sqlSession.selectList("MemberSelect", mvo);
	}
	
	public int MemberInsert(MemberVO mvo) {
		return (Integer)sqlSession.insert("MemberInsert", mvo);
	}
	
	public List<MemberVO> MemberSelectAll(MemberVO mvo) {
		return sqlSession.selectList("MemberSelectAll", mvo);
	}
	
	public int MemberUpdatepw(MemberVO mvo) {
		return (Integer)sqlSession.update("MemberUpdatepw", mvo);
	}
}
