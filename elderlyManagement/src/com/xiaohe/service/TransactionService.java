package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Transaction;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.TransactionVo;

@Transactional
public interface TransactionService {

	/**
	 * 查询所有记录
	 * @param condition
	 * @return
	 */
	public TransactionVo queryAllRecordByCondition(TransactionCustom condition);
	
	/**
	 * 查询单条记录的详细信息(包括y用户) admin
	 * @param id
	 * @return
	 */
	public TransactionCustom queryRecordInfoById(Integer id);
	
	/**
	 * 修改记录
	 * @param id
	 * @return
	 */
	public boolean updateRecordInfoById(TransactionCustom info);
	
	/**
	 * 删除用户交易表记录
	 * @param transactionid
	 * @return
	 */
	public boolean deleteRecord(Integer transactionid);
	
	/**
	 * 根据用户id查询交易表
	 * @param id
	 * @return
	 */
	public TransactionCustom oneTransaction(Integer id);
}
