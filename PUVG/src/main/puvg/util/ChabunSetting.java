package main.puvg.util;
	
public class ChabunSetting {
	public static final String DELIMITER_MEMBER_V = "V";
	public static final String DELIMITER_APPROVAL_A = "A";
	public static final String DELIMITER_APPROVALTemp_A = "T";
	
	public static String numPad(String t, String c) {
		for (int i=c.length(); i < 4; i++) {
			c = "0" + c;
		}				
		String ymd = DateFormatUtil.ymdFormats(t);
		
		return ymd.concat(c);
	}
	
	public static String getMemberChabun(String type, String Num) {
		
		return DELIMITER_MEMBER_V.concat(ChabunSetting.numPad(type, Num));
	}
	
	public static String getApprovalChabun(String type, String Num) {
		
		return DELIMITER_APPROVAL_A.concat(ChabunSetting.numPad(type, Num));
	}
	
	public static String getApprovalTempChabun(String type, String Num) {
		
		return DELIMITER_APPROVALTemp_A.concat(ChabunSetting.numPad(type, Num));
	}
}