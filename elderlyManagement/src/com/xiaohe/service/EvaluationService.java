package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.EvaluationCustom;

@Transactional
public interface EvaluationService {
	/**
	 * 根据评价id查询评价
	 * @param evaluationid
	 * @return
	 */
	public EvaluationCustom queryEvaluationByPrimaryKey(Integer evaluationid);
	
	/**
	 * 添加一条数据 评价
	 * @param info
	 * @return
	 */
	public boolean addEvaluationByUser(EvaluationCustom info);
}
