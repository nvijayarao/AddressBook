package com.gumtree.uk.addressbook.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {

	public static String fill2(int value)
	{
	    String ret = String.valueOf(value);

	    if (ret.length() < 2)
	        ret = "0" + ret;            
	    return ret;
	}

	public static String get_duration(Date date1, Date date2)
	{                   
	    TimeUnit timeUnit = TimeUnit.SECONDS;

	    long diffInMilli = date2.getTime() - date1.getTime();
	    long s = timeUnit.convert(diffInMilli, TimeUnit.MILLISECONDS);

	    long days = s / (24 * 60 * 60);
	    long rest = s - (days * 24 * 60 * 60);
	    long hrs = rest / (60 * 60);
	    long rest1 = rest - (hrs * 60 * 60);
	    long min = rest1 / 60;      
	    long sec = s % 60;

	    String dates = "";
	    if (days > 0) dates = days + " Days ";

	    dates += fill2((int) hrs) + "h ";
	    dates += fill2((int) min) + "m ";
	    dates += fill2((int) sec) + "s ";

	    return dates.trim();
	}
}
