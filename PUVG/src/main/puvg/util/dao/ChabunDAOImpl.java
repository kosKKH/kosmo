package main.puvg.util.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.puvg.member.vo.MemberVO;

@Repository
public class ChabunDAOImpl implements ChabunDAO {
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	public MemberVO getMemberChabun() {
		return sqlSession.selectOne("getMemberChabun");
	}
}
