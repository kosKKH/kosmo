package main.puvg.member.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import main.puvg.member.service.MemberService;
import main.puvg.member.vo.MemberVO;

@RestController
public class MemberController {
	Logger logger = LogManager.getLogger(MemberController.class);
	ModelAndView mav = new ModelAndView();
	
	@Autowired(required=false)
	private MemberService memberService;
	
	@GetMapping(value="memberSelect")
	public ModelAndView memberSelect(List<MemberVO> mvo) {
		
		
		mav.setViewName("member/MemberSelect");
		return mav;
	}
}
