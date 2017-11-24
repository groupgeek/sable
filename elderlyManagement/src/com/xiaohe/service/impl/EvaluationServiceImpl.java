package com.xiaohe.service.impl;

import java.util.Date;

import org.apache.logging.log4j.core.config.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.Orders;
import com.xiaohe.mapper.EvaluationMapper;
import com.xiaohe.mapper.OrdersMapper;
import com.xiaohe.service.EvaluationService;

@Repository("evaluationService")
public class EvaluationServiceImpl implements EvaluationService {
	
	@Autowired
	@Qualifier("evaluationMapper")
	private EvaluationMapper evaluationMapper;
	
	@Autowired
	@Qualifier("ordersMapper")
	private OrdersMapper ordersMapper;

	public EvaluationCustom queryEvaluationByPrimaryKey(Integer evaluationid) {
		if(evaluationid == null) return null;
		EvaluationCustom evaluation = new EvaluationCustom();
		evaluation = evaluationMapper.selectOneByEvaluationId(evaluationid);
		return evaluation;
	}

	public boolean addEvaluationByUser(EvaluationCustom info) {
		
		if(info == null) return false;
		if(info.getUserid() == null || info.getOrderid() == null) return false;
		
		info.setCommentdate(new Date());
		
		if(evaluationMapper.updateByPrimaryKeySelective(info) <= 0) return false;
		//更新订单信息
		Orders record = new Orders();
		record.setOrderid(info.getOrderid());
		record.setEvaluationstatus(true);
		if(ordersMapper.updateByPrimaryKeySelective(record) <= 0) return false;
		
		
		return true;
	}

}
