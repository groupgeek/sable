package com.xiaohe.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class GetStringByDate {
	public static String getString(Date date){
		String string = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		string = df.format(date);
		return string;
	}
	
	//时间的加法（天数）
	public Date addDate(Date date,int days){
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.add(Calendar.DAY_OF_YEAR, days);
		Date dt = rightNow.getTime();
		return dt;
	}
	
	//时间区间计算器，计算时间区间天数
	public int calculateDate(Date date1,Date date2){
		int a = date1.compareTo(date2);
		if(a>=0){
			return (int)((date2.getTime()-date1.getTime())/(1000*3600*24)+1);
		}
		else{
			return (int)((date2.getTime()-date1.getTime())/(1000*3600*24));
		}
		
	}
	
	public String getTime(Date date){
		String string = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		string = df.format(date);
		return string;
	}

}
