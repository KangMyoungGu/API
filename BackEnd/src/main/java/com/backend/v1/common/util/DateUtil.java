package com.backend.v1.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public Date getToday() {
		Date time = new Date();
		return time;
	}

	public String getTodayByString(String format) {
		SimpleDateFormat sdf = new java.text.SimpleDateFormat(format); 
		return sdf.format(new java.util.Date());
	}

	public Date getWantDay(int arg) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, arg);
        
        return new Date(cal.getTimeInMillis());
	}
	
}
