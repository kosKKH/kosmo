package main.puvg.approval.service;

import java.util.List;

import main.puvg.approval.dao.ApprovalDAO;
import main.puvg.approval.vo.*;

public interface ApprovalService {
	
	// 결재게시판
	public List<ApprovalListVO> ApprovalListSelectAll(ApprovalListVO amvo);
	public List<ApprovalListVO> ApprovalListSelect(ApprovalListVO amvo);
	
	// 휴가신청서
	public int Appr1DocInsert(Appr1DocVO amvo);
	public List<Appr1DocVO> Appr1DocSelect(Appr1DocVO amvo);
	
	// 자재구매요청서
	public int Appr2DocInsert(Appr2DocVO amvo);
	public List<Appr2DocVO> Appr1DocSelect(Appr2DocVO amvo);
	
	// 지출결의서
	public int Appr3DocInsert(Appr3DocVO amvo);
	public List<Appr3DocVO> Appr1DocSelect(Appr3DocVO amvo);
	
	// 프로젝트기획서
	public int Appr4DocInsert(Appr4DocVO amvo);
	public List<Appr4DocVO> Appr1DocSelect(Appr4DocVO amvo);
	
	// 결재선
	public int ApprovalLineInsert(Appr4DocVO amvo);
	public int ApprovalLineSelect(Appr4DocVO amvo);
	
	// 임시파일
	public List<ApprovalTempVO> ApprovalTempSelectAll(ApprovalTempVO amvo);
	public List<ApprovalTempVO> ApprovalTempSelect(ApprovalTempVO amvo);
	
	// 결재파일보기
	
}