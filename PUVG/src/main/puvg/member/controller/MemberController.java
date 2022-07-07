package main.puvg.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import main.puvg.member.service.MemberService;
import main.puvg.member.vo.MemberVO;
import main.puvg.util.ChabunSetting;
import main.puvg.util.FileUploadUtil;
import main.puvg.util.service.ChabunService;

@RestController
public class MemberController {
	Logger logger = LogManager.getLogger(MemberController.class);
	ModelAndView mav = new ModelAndView();
	
	private MemberService memberService;
	private ChabunService chabunService;
	
	@Autowired(required=false)
	public MemberController(MemberService memberService, ChabunService chabunService) {
		this.memberService = memberService;
		this.chabunService = chabunService;
	}
	
	@GetMapping(value="memberSelect")
	public ModelAndView memberSelect(HttpServletRequest request, MemberVO mvo) {
		logger.info("MemberController.memberSelect() 진입");
		HttpSession Session = request.getSession(true);
		String VID = (String)Session.getAttribute("VID");
		mvo.setVnum(VID);
		
		List<MemberVO> selectmem = memberService.MemberSelect(mvo);	
		mav.setViewName("member/MemberSelect");
		mav.addObject("selectmem", selectmem);
		
		return mav;
	}
	
	@GetMapping(value="memberInsertForm")
	public ModelAndView memberInsertForm(MemberVO mvo) {
		logger.info("MemberController.memberInsertForm() 진입");
		mav.setViewName("member/MemberInsertForm");
		return mav;
	}
	
	@PostMapping(value="memberInsert")
	public ModelAndView memberInsert(@ModelAttribute MemberVO mvo, HttpServletRequest request) throws IllegalStateException, IOException {
		logger.info("MemberController.memberInsert() 진입");
		mav.setViewName("member/MemberInsertForm");
		
		String chabun = ChabunSetting.getMemberChabun("d", chabunService.getMemberChabun().getVnum());
		logger.info("생성된 채번  : " + chabun);
		mvo.setVnum(chabun);
		
		String fileupload = FileUploadUtil.fileUpload(mvo.getVfile(), request);
		mvo.setVimg(fileupload);
		mvo.setVpw(mvo.getVbirth());
		mvo.setVdeleteyn("근무");
		mvo.setVauthority(0);
		int insertcount = memberService.MemberInsert(mvo);
		
		if(insertcount > 0) {
			mav.setViewName("main/MainPage");
		}
		return mav;
	}
}
