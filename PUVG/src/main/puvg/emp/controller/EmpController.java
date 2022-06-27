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
		logger.info("컨트롤러 진입");
		mav.setViewName("empselectall");
		logger.info("뷰네임 설정 완료");
		List<Empvo> list = empService.empselectall();
		logger.info("list 값 받아오기 완료");
		mav.addObject("selectall", list);
		return mav;
	}
}
