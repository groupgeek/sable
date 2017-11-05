package com.xiaohe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityVo;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.TransactionVo;
import com.xiaohe.mapper.TransactionMapper;
import com.xiaohe.service.TransactionService;

@Repository("transactionService")
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	@Qualifier("transactionMapper")
	private TransactionMapper transactionMapper;

	public TransactionVo queryAllRecordByCondition(TransactionCustom condition) {
		TransactionVo transactionVo = new TransactionVo();
		List<TransactionCustom> transactionList = new ArrayList<TransactionCustom>();
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
		transactionList = transactionMapper.selectAllRecordByCondition(condition);
		sum = transactionMapper.selectAllRecordSumByCondition(condition);
		pageSum = sum / condition.getPageNum();
		if(sum % condition.getPageNum() != 0){
			pageSum += 1;
		}
		
		transactionVo.setTransactionList(transactionList);
		transactionVo.setPageSum(pageSum);
		transactionVo.setRecordSum(sum);
		
		return transactionVo;
	}

	public TransactionCustom queryRecordInfoById(Integer id) {
		
		if(id == null || id < 0) return null;
		
		return transactionMapper.selectRecordById(id);
	}

	public boolean updateRecordInfoById(TransactionCustom record) {
		if(record.getTransactionid() == null) return false;
		if(record.getTransactionid() == null ||record.getTransactionid() < 0) return false;
		if(transactionMapper.updateByPrimaryKeySelective(record) < 0) return false;
		return true;
	}

}
