package main.puvg.approval.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import main.puvg.approval.dao.ApprovalDAO;
import main.puvg.approval.service.ApprovalService;
import main.puvg.approval.vo.ApprovalListVO;

@RestController
public class ApprovalController {
	
	Logger logger = LogManager.getLogger(ApprovalController.class);
	
	@Autowired(required=false)
	ApprovalService approvalService;
	
	ModelAndView mav = new ModelAndView();
	
	@GetMapping(value="ApprovalListSelectAll")
	public ModelAndView ApprovalListSelectAll(ApprovalListVO avo) {
		
		logger.info("ApprovalController ApprovalListSelectAll 함수진입");
		
		List<ApprovalListVO> listAll = approvalService.ApprovalListSelectAll(avo);
		
		if(listAll.size() > 0) {
			logger.info("ApprovalController ApprovalListSelectAll listAll");
			
			mav.addObject("listAll", listAll);
			mav.addObject("avo", avo);
			
			mav.setViewName("approval/ApprovalListSelectAll");
			
			return mav;
		}
		mav.setViewName("approval/ApprovalListSelectAll");
		return mav;
	}

}