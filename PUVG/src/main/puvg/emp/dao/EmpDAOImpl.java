package main.puvg.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.puvg.emp.vo.Empvo;
@Repository
public class EmpDAOImpl implements EmpDAO {
	Logger logger = LogManager.getLogger(EmpDAOImpl.class);
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	public List<Empvo> empselectall() {
		logger.info("다오 진입");
		return sqlSession.selectList("empselectall");
	}
}
