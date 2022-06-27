package main.puvg.emp.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import main.puvg.emp.service.EmpService;
import main.puvg.emp.vo.Empvo;

@RestController
public class EmpController {
	Logger logger = LogManager.getLogger(EmpController.class);
	ModelAndView mav = new ModelAndView();
	
	private EmpService empService;
	
	@Autowired(required=false)
	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	
	@GetMapping(value="selectallemp")
	public ModelAndView selectAllemp() {
		logger.info("��Ʈ�ѷ� ����");
		mav.setViewName("emp/empSelectall");
		logger.info("����� ���� �Ϸ�");
		List<Empvo> list = empService.empselectall();
		logger.info("list �� �޾ƿ��� �Ϸ�");
		mav.addObject("selectall", list);
		return mav;
	}
}
