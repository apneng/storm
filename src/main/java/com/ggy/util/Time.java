package com.ggy.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	
	public String changeDate(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		return df.format(date);
	}

}
