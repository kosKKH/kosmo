package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bank.common.KosConnectivity;
import bank.sql.BankSql;
import bank.vo.accountVO;
import bank.vo.customerVO;

public class BankDAOImpl implements BankDAO {
	
	@Override
	public ArrayList<customerVO> customerSelect(customerVO cvo) {
		// TODO Auto-generated method stub
		
		//사용할 객체를 지역변수로 선언하고 초기화하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<customerVO> aList = null;
		
		try {
			
			conn = KosConnectivity.getConnection();
			String sql = BankSql.getAccountSelect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, cvo.getCid());
			pstmt.setString(2, cvo.getCpw());
			
			rsRs = pstmt.executeQuery();
			
			if (rsRs!=null) {
				
				aList = new ArrayList<customerVO>();
				
				while (rsRs.next()) {
					customerVO _cvo = new customerVO();
					_cvo.setCid(rsRs.getString("CID"));
					_cvo.setCustomer_name(rsRs.getString("CUSTOMER_NAME"));
					_cvo.setChp(rsRs.getString("CHP"));
					_cvo.setCemail(rsRs.getString("CEMAIL"));
					_cvo.setCzone(rsRs.getString("CZONE"));
					_cvo.setJibun_city(rsRs.getString("JIBUN_CITY"));
					_cvo.setRoad_city(rsRs.getString("ROAD_CITY"));
					_cvo.setDetail_city(rsRs.getString("DETAIL_CITY"));
					_cvo.setInsert_date(rsRs.getString("INSERT_DATE"));
					
					aList.add(_cvo);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	}

	//회원테이블 입력
	@Override
	public boolean customerInsert(customerVO cvo) {
		// TODO Auto-generated method stub
				
		//사용할 객체를 지역변수로 선언하고 초기화하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		//JDBC 객체 이용해서 테이블에 인서트 하기
		try {
			conn = KosConnectivity.getConnection();
			
			String sql = BankSql.getCustomerInsert();
			pstmt = conn.prepareStatement(sql);
			
			//플레이스 홀더에 입력할 데이터 바인딩하기
			//BNUM,BSUBJECT,BWRITER,BPW,BMEMO
			pstmt.clearParameters();
			
			pstmt.setString(1, cvo.getCnumber());
			pstmt.setString(2, cvo.getCid());
			pstmt.setString(3, cvo.getCpw());
			pstmt.setString(4, cvo.getCustomer_name());
			pstmt.setString(5, cvo.getChp());
			pstmt.setString(6, cvo.getCemail());
			pstmt.setString(7, cvo.getCzone());
			pstmt.setString(8, cvo.getJibun_city());
			pstmt.setString(9, cvo.getRoad_city());
			pstmt.setString(10, cvo.getDetail_city());
			pstmt.setString(11, cvo.getBranch_code());
			
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()) conn.commit();
			if (nCnt>0) bool=true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			KosConnectivity.conClose(conn, pstmt);
		}
		
		return bool;
	}

	@Override
	public boolean customerUpdate(customerVO cvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean customerDelete(customerVO cvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<customerVO> accountSelect(accountVO avo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean accountInsert(accountVO avo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accountUpdate(accountVO avo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accountDelete(accountVO avo) {
		// TODO Auto-generated method stub
		return false;
	}

}
