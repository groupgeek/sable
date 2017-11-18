package com.xiaohe.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.mapper.ProducttransactionreportMapper;
import com.xiaohe.service.ReportService;
import com.xiaohe.util.GetStringByDate;

@Repository("reportService")
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	@Qualifier("producttransactionreportMapper")
	private ProducttransactionreportMapper producttransactionreportMapper;

	public Map<String, String[]> queryProductReportByTimeInterval(
			ProducttransactionreportCustom condition) {
		
		if(condition == null) return null;
		if(condition.getStartDateString() == null || condition.getEndDateString() == null) return null;
		
		DateFormat df = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			
			Date tempStart = df.parse(condition.getStartDateString());
			Date tempEnd = df.parse(condition.getEndDateString());
			
			condition.setStartingTime(tempStart);
			condition.setEndTime(tempEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return null;
			return null;
		}
		
		Map<String, String[]> map = new TreeMap<String, String[]>();
		List<ProducttransactionreportCustom> productList = new ArrayList<ProducttransactionreportCustom>();
		
		
		Calendar startingTime = Calendar.getInstance();
		startingTime.setTime(condition.getStartingTime());
		
		Calendar endTime = Calendar.getInstance();
		endTime.setTime(condition.getEndTime());
		
		if(startingTime.after(endTime)) return null;
		
		while(endTime.after(startingTime)){
			condition.setStartingTime(startingTime.getTime());
			
			Date XTemp = startingTime.getTime();//key
			
			startingTime.set(Calendar.DAY_OF_MONTH, startingTime.get(Calendar.DAY_OF_MONTH)+1);
			condition.setEndTime(startingTime.getTime());
			productList = producttransactionreportMapper.selectPtByTimeInterval(condition);
			
			Integer buyNo = 0;
			BigDecimal total = new BigDecimal(0);
			String[] arr = new String[3];
			if(productList != null){
				for(ProducttransactionreportCustom  temp : productList){
					buyNo += temp.getCountbuy();
					total = total.add(temp.getTotalprice());
				}
				arr[0] = buyNo + "";
				arr[1] = total + "";
			}else{
				arr[0] = "";
				arr[1] = "";
			}
			
			
			//时间转换
			map.put(GetStringByDate.getString(XTemp).split(" ")[0], arr);
			
			//map.put(startingTime.getTime()+"", arr);
			
		}
		
		/*List<Map.Entry<String,List<ProducttransactionreportCustom>>> list = new ArrayList<Map.Entry<String,List<ProducttransactionreportCustom>>>(map.entrySet());  
        Collections.sort(list,new Comparator<Map.Entry<String,List<ProducttransactionreportCustom>>>() {  
            //升序排序  
            public int compare(Entry<String, List<ProducttransactionreportCustom>> o1,  
                    Entry<String, List<ProducttransactionreportCustom>> o2) {  
                return (o1.getKey()).compareTo(o2.getKey());  
            }  
  
        });
		
        for(Entry<String, List<ProducttransactionreportCustom>> mapping:list){   
            System.out.println(mapping.getKey()+":"+mapping.getValue());   
       }  */
        
        
		return map;
	}

}
