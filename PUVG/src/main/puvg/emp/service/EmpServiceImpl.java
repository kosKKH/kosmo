package main.puvg.emp.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.puvg.emp.dao.EmpDAO;
import main.puvg.emp.vo.Empvo;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
	Logger logger = LogManager.getLogger(EmpServiceImpl.class);
	@Autowired(required=false)
	private EmpDAO empDAO;
	
	public List<Empvo> empselectall() {
		logger.info("서비스 진입");
		return empDAO.empselectall();
	}
}
