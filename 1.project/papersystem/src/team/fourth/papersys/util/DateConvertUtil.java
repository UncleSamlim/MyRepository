package team.fourth.papersys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class DateConvertUtil {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String DateToString(Date date) {
		if (date!=null) {
			return sdf.format(date);
		}else {
			return null;
		}
	}
	
	public static Date StringToDate(String date) throws ParseException {
		if (!StringUtils.isEmpty(date)) {
			return sdf.parse(date);
		}else {
			return null;
		}
	}
	
}
