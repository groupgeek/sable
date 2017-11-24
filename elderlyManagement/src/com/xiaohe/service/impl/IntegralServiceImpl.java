package com.xiaohe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.IntegralCustom;
import com.xiaohe.mapper.IntegralMapper;
import com.xiaohe.service.IntegralService;
import com.xiaohe.util.GetStringByDate;

@Repository("integralService")
public class IntegralServiceImpl implements IntegralService {

	@Autowired
	@Qualifier("integralMapper")
	private IntegralMapper integralMapper;
	
	
	public IntegralCustom queryUpToDateRecord(IntegralCustom condition) {
		return integralMapper.selectUpToDateRecord(condition);
	}

	public List<IntegralCustom> queryAllByCondition(IntegralCustom condition) {
		List<IntegralCustom> all = new ArrayList<IntegralCustom>();
		all = integralMapper.selectIntegralByCondition(condition);
		for(IntegralCustom temp : all){
			temp.setChangetimeString(GetStringByDate.getString(temp.getChangetime()));
		}
		
		return all;
	}

}
