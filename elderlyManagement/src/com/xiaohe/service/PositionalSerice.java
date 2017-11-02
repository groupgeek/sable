package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.PositionalCustom;

@Transactional
public interface PositionalSerice {
	
	/**
	 * 查询所哟职位
	 * @return
	 */
	public List<PositionalCustom> queryAll();

}
