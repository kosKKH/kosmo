package main.puvg.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import main.puvg.login.service.LoginService;
import main.puvg.member.vo.MemberVO;

@RestController
public class LoginController {
	Logger logger = LogManager.getLogger(LoginController.class);
	ModelAndView mav = new ModelAndView();
	
	@Autowired(required=false)
	private LoginService loginService;
	
	@GetMapping(value="loginpage")
	public ModelAndView loginPage() {
		mav.setViewName("main/LoginPage");
		
		return mav;
	}
	
	@PostMapping(value="logincheck")
	public String LoginCheck(HttpServletRequest request, MemberVO mvo) {
		logger.info("LoginController.loginCheck() 진입");
		List<MemberVO> loginlist = loginService.LoginCheck(mvo);
		mav.setViewName("main/LoginPage");
		
		logger.info("mvo.getVnum() = " + (loginlist.get(0)).getVnum());
		logger.info("mvo.getVname() = " + (loginlist.get(0)).getVname());
		
		HttpSession Session = request.getSession(true);
		Session.setAttribute("VID", (loginlist.get(0)).getVnum());
		Session.setAttribute("VNAME",(loginlist.get(0)).getVname());
		logger.info("Session 생성 = " +Session);
		if (loginlist.size() == 0) {
			logger.info("로그인 실패");
			return "fail";
		} else {
			logger.info("로그인 성공");
			mav.addObject("loginlist", loginlist);
			return "success";
		}
		
		
	}
}
