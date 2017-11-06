package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.ReturnvisitCustom;
import com.xiaohe.bean.ReturnvisitVo;


@Transactional
public interface ReturnvisitService {
	
	/**
	 * 查询所有记录
	 * @param condition
	 * @return
	 */
	public ReturnvisitVo queryAllRecordByCondition(ReturnvisitCustom condition);
	
	/**
	 * 查询单条记录的详细信息(包括用户) admin
	 * @param id
	 * @return
	 */
	public ReturnvisitCustom queryRecordInfoById(Integer id);
	
	/**
	 * 修改记录
	 * @param id
	 * @return
	 */
	public boolean updateRecordInfoById(ReturnvisitCustom info);

}
