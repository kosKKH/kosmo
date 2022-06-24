package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bank.common.ChabunUtil;
import bank.service.BankService;
import bank.service.BankServiceImpl;
import bank.vo.customerVO;

@WebServlet("/Study")
public class BankController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	retret
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("isudType");
		
		if (isudType!=null && isudType.length()>0) {
			isudType=isudType.toUpperCase();
			
			//회원테이블 입력
			if ("I".equals(isudType)) {
				
				
				String cnumber = ChabunUtil.getMemBoard("Y");
				String cid = request.getParameter("cid");
				String cpw = request.getParameter("cpw"); 
				String customer_name = request.getParameter("customer_name");
				String chp = request.getParameter("chp");
				String chp1 = request.getParameter("chp1");
				String chp2 = request.getParameter("chp2");
				String cemail = request.getParameter("cemail");
				String cemail1 = request.getParameter("cemail1");
				String czone = request.getParameter("czone");
				String jibun_city = request.getParameter("jibun_city");
				String road_city = request.getParameter("road_city");
				String detail_city = request.getParameter("detail_city");
				String branch_code = request.getParameter("branch_code");
				

				customerVO cvo = new customerVO();
				
				cvo.setCnumber(cnumber);				//1
				cvo.setCid(cid);						//2
				cvo.setCpw(cpw);						//3
				cvo.setCustomer_name(customer_name);	//4
				cvo.setChp(chp);						//5
				cvo.setCemail(cemail);					//6
				cvo.setCzone(czone);					//7
				cvo.setJibun_city(jibun_city);			//8
				cvo.setRoad_city(road_city);			//9
				cvo.setDetail_city(detail_city);		//10
				cvo.setBranch_code(branch_code);		//11
				
				//StudyServiceImpl implements StudyService
				BankService ss = new BankServiceImpl();
				boolean bool = ss.customerInsert(cvo);
				
				if (bool) {
					out.println("<script>");
					out.println("alert('회원가입성공')");
					out.println("location.href='/study/login/login.html'");
					out.println("</script>");
				}else {
					out.println("<script>");
					out.println("alert('입력실패ㅜㅜ')");
					out.println("location.href='/study/login/login.html");
					out.println("</script>");
				}
				
			}//if ("I".equals(isudType))
			
			if ("S".equals(isudType)) {
				
				String cid = request.getParameter("cid");
				String cpw = request.getParameter("cpw");
				
				customerVO cvo = new customerVO();
				cvo.setCid(cid);
				cvo.setCpw(cpw);
				
				BankService ss = new BankServiceImpl();
				ArrayList<customerVO> aList = ss.customerSelect(cvo);
				
				if (aList!=null && aList.size()>0) {
					
					request.setAttribute("aList_select", aList);
					RequestDispatcher rd = request.getRequestDispatcher("/login/select.jsp");
					rd.forward(request, response);
				}else {
					
					out.println("<script>");
					out.println("location.href='/study/login/login.html'");
					out.println("</script>");
			}
			
			}//if ("L".equals(isudType))
			
			if("U".equals(isudType)) {
			
			String cnumber = request.getParameter("cnumChk");
			
			customerVO cvo = null;
			cvo = new customerVO();
			cvo.setCnumber(cnumber);
			
			
			BankService ss = new BankServiceImpl();
			ArrayList<customerVO> aList = ss.customerUpdate(cvo);
			
			if(aList != null && aList.size() > 0) {
				
				request.setAttribute("aList_select", aList);
				
				RequestDispatcher rd = request.getRequestDispatcher("/sonBank/sonBankSelect.jsp");
				rd.forward(request, response);
			}else {
				
				logger.info("조회실패!");
				out.println("<script>");
				out.println("alert('조회실패!')");
				out.println("location.href='/SonContext/SonBank?isudType=SALL'");
				out.println("</script>");
			}
			
		}//if (isudType!=null && isudType.length()>0)
	
	}//doGet

}//StudyController
