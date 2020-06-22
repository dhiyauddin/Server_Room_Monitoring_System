package jbr.springmvc.util;

import java.util.Calendar;

public class DateToolsUtilImpl implements DateToolsUtil {

	@Override
	public String getCurrentDateWithTimeStamp() {
		Calendar now = Calendar.getInstance();
		int month = now.get(Calendar.MONTH) + 1;
		String monthStr = ((month < 10) ? "0" : "") + month;
		int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
		String dayOfMonthStr = ((dayOfMonth < 10) ? "0" : "") + month;
		int year = now.get(Calendar.YEAR);
		String yearStr = String.valueOf(year);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		String hourStr = ((hour < 10) ? "0" : "") + hour;
		int minute = now.get(Calendar.MINUTE);
		String minuteStr = ((minute < 10) ? "0" : "") + minute;
		int second = now.get(Calendar.SECOND);
		String secondStr = ((second < 10) ? "0" : "") + second;
		
		String today = yearStr+"-"+monthStr+"-"+dayOfMonthStr+" "+hourStr+":"+minuteStr+":"+secondStr;
	
		return today;
	}

}
