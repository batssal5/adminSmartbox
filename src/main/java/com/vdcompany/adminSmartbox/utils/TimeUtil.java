package com.vdcompany.adminSmartbox.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
	
	private static Logger logger = LoggerFactory.getLogger(TimeUtil.class);
	
	public static String getCurrentTimeStamp(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
		
		return sdf.format(new Date()).toLowerCase();
	}
	
	public static long getTimeInSecondsDifference(String time1, String time2) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
			
			Date nowDate = sdf.parse(time1);
			Date lastDate = sdf.parse(time2);
			
			long diff = (nowDate.getTime() - lastDate.getTime())/1000;
			
			return diff;
			
		} catch (ParseException e) {
			logger.error("TimeUtil parse error", e);
		}
		
		return 0;
	}
}
