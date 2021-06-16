package com.vdcompany.adminSmartbox.utils;

/**
 * @author han, sung-ku
 * @since 2017. 12. 19.
 * @version 1.0.0
 */
public class NumberUtil {
	
	
	public static int toInt(Object val) {
		if(val == null) {
			return 0;
			
		}
		
		return (int)Float.parseFloat(String.valueOf(val));
		
	}
	
	
	public static long toLong(Object val) {
		if(val == null) {
			return 0;
			
		}
		
		return (long)Double.parseDouble(String.valueOf(val));
		
	}


	public static double toDouble(Object val) {
		if(val == null) {
			return 0;

		}

		return Double.parseDouble(String.valueOf(val));

	}
	
	
	public static float toFloat(Object val) {
		if(val == null) {
			return 0;
			
		}
		
		return Float.parseFloat(String.valueOf(val));
		
	}
	

}
