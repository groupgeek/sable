package com.xiaohe.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GetStringByDate {
	public static String getString(Date date){
		if(date == null) return "error";
		String string = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		string = df.format(date);
		return string;
	}

}
