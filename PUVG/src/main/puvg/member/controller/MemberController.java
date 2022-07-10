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
	
	@GetMapping(value="memberSelectAll")
	public ModelAndView memberSelectAll(MemberVO mvo) {
		logger.info("MemberController.memberSelectAll() 진입");
		mav.setViewName("member/MemberSelectAll");
		
		
		List<MemberVO> selectall = memberService.MemberSelectAll(mvo);	
		mav.addObject("selectall", selectall);
		
		return mav;
	}
	
	@GetMapping(value="updatePassWord")
	public ModelAndView updatePassWord() {
		logger.info("MemberController.updatePassWord() 진입");
		mav.setViewName("member/Update_pw_Popup");
		return mav;
	}
	
	@GetMapping(value="changePassWord")
	public ModelAndView changePassWord() {
		logger.info("MemberController.changePassWord() 진입");
		mav.setViewName("member/Update_pw");
		return mav;
	}
	
	@PostMapping(value="UpdatePassWord")
	public String UpdatePassWord(HttpServletRequest request,@ModelAttribute MemberVO mvo) {
		logger.info("MemberController.UpdatePassWord() 진입");
		
		HttpSession Session = request.getSession(false);
		String VNUM= (String)Session.getAttribute("VID");
		mvo.setVnum(VNUM);
		mvo.setVpw(request.getParameter("vpw"));
		
		logger.info(mvo.getVnum());
		logger.info(mvo.getVpw());
		int updatepw = memberService.MemberUpdatepw(mvo);
		if(updatepw == 1) {
			logger.info("업데이트 완료");
			return "success";
		}
		logger.info("업데이트 실패");
		return "fail";
	}
}
