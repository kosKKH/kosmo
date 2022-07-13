package main.puvg.util.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.puvg.approval.vo.Appr1DocVO;
import main.puvg.approval.vo.ApprovalListVO;
import main.puvg.approval.vo.ApprovalTempVO;
import main.puvg.member.vo.MemberVO;

@Repository
public class ChabunDAOImpl implements ChabunDAO {
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	public MemberVO getMemberChabun() {
		return sqlSession.selectOne("getMemberChabun");
	}

	@Override
	public Appr1DocVO getApprovalChabun() {
		return sqlSession.selectOne("getApprovalChabun");
	}

	@Override
	public ApprovalTempVO getApprovalTempChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getApprovalTempChabun");
	}
}
