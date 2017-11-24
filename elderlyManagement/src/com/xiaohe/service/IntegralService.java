package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Integral;
import com.xiaohe.bean.IntegralCustom;

@Transactional
public interface IntegralService {
	
	/**
	 * 查询最新记录
	 * @param condition
	 * @return
	 */
	public IntegralCustom queryUpToDateRecord(IntegralCustom condition);
	
	/**
	 * 查询所有记录
	 * @param condition 条件
	 * @return
	 */
	public List<IntegralCustom> queryAllByCondition(IntegralCustom condition);
	
	/**
	 * 插入积分信息
	 * @param integral
	 * @return
	 */
	public int insertIntel(Integral integral);
}
