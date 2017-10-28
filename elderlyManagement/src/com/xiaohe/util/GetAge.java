package com.xiaohe.util;

import java.util.Calendar;
import java.util.Date;

public class GetAge {
	public static Integer getAgeByBirth(Date birthday){
		
		Integer age = 0;
		Integer month = 0;
		try{
			Calendar now = Calendar.getInstance();
			now.setTime(new Date());
			
			Calendar birth = Calendar.getInstance();
			birth.setTime(birthday);
			
			Integer yearNow = now.get(Calendar.YEAR);
			Integer monthNow = now .get(Calendar.MONTH) + 1;
			Integer dayOfMonthNow = now.get(Calendar.DAY_OF_MONTH);
			
			Integer yearBirth = birth.get(Calendar.YEAR);
			Integer monthBirth = birth.get(Calendar.MONTH) +1;
			Integer dayOfMonthBirth = birth.get(Calendar.DAY_OF_MONTH);
			
			if(birth.after(now)){
				age = 0;
			}else{
				age = yearNow - yearBirth;
				month = monthNow - monthBirth;
				if(month == 0){
					if(dayOfMonthNow < dayOfMonthBirth){
						age --;
					}
					
				}else if(month < 0){
					age --;
				}
			}
			return age;
		}catch (Exception e){
			return 0;
		}
	} 
}
