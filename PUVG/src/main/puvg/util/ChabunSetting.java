package main.puvg.util;
	
public class ChabunSetting {
	public static final String DELIMITER_MEMBER_V = "V";
	
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
}
