package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Positional;
import com.xiaohe.bean.PositionalCustom;

@Transactional
public interface PositionalSerice {
	
	/**
	 * 查询所哟职位
	 * @return
	 */
	public List<PositionalCustom> queryAll();
	
	/**
	 * 根据id查询职位
	 * @param pid
	 * @return
	 */
	public Positional queryByPositionalId(Integer pid);

}
