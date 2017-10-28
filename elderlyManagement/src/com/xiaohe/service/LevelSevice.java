package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.LevelCustom;

@Transactional
public interface LevelSevice {
	
	/**
	 * 查询所有用户等级
	 * @return
	 */
	public List<LevelCustom> queryAll();

}
