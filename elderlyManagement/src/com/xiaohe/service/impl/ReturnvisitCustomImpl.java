package com.xiaohe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.ReturnvisitCustom;
import com.xiaohe.bean.ReturnvisitVo;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.ReturnvisitMapper;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.ReturnvisitService;
import com.xiaohe.util.GetStringByDate;

@Repository("returnvisitService")
public class ReturnvisitCustomImpl implements ReturnvisitService {
	
	@Autowired
	@Qualifier("returnvisitMapper")
	private ReturnvisitMapper returnvisitMapper;
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	public ReturnvisitVo queryAllRecordByCondition(ReturnvisitCustom condition) {
		ReturnvisitVo returnvisitVo = new ReturnvisitVo();
		List<ReturnvisitCustom> returnvisitList = new ArrayList<ReturnvisitCustom>();
		Integer pageSum = 0;
		Integer sum = 0;
		
		if(condition != null){
			if(condition.getBranchid() == -1){
				condition.setBranchid(null);
			}
			
			if(condition.getCurrentPage() >= 1){
				Integer tempBegin = (condition.getCurrentPage()-1) * condition.getPageNum();
				condition.setBegin(tempBegin);
			}else{
				condition.setBegin(0);
			}
			
		}
		
		returnvisitList = returnvisitMapper.selectAllRecordByCondition(condition);
		
		for(ReturnvisitCustom temp : returnvisitList){
			temp.setLastvisttimeString(GetStringByDate.getString(temp.getLastvisttime()));
		}
		
		sum = returnvisitMapper.selectAllRecordSumByCondition(condition);
		
		pageSum = sum / condition.getPageNum();
		if(sum % condition.getPageNum() != 0){
			pageSum += 1;
		}
		
		returnvisitVo.setReturnvisitList(returnvisitList);
		returnvisitVo.setPageSum(pageSum);
		returnvisitVo.setRecordSum(sum);
		
		
		return returnvisitVo;
	}

	public ReturnvisitCustom queryRecordInfoById(Integer id) {
		
		if(id == null || id < 0) return null;
		ReturnvisitCustom temp = returnvisitMapper.selectRecordById(id);
		temp.setLastvisttimeString(GetStringByDate.getString(temp.getLastvisttime()));
		return temp;
	}

	public boolean updateRecordInfoById(ReturnvisitCustom info) {
		
		if(info == null ) return false;
		if(info.getReturnvisitid() == null || info.getReturnvisitid() < 0) return false;
		if(info.getUserid() == null || info.getUserid() < 0) return false;
		
		if(returnvisitMapper.updateByPrimaryKeySelective(info) < 0) return false;
		UserCustom user = new UserCustom();
		user.setUserid(info.getUserid());
		user.setAddress(info.getAddress());
		
		if(userMapper.updateByPrimaryKeySelective(user) < 0) return false;
		
		return true;
		
	}

}
