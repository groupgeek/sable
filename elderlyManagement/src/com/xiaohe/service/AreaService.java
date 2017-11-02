package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.AreaCustom;

@Transactional
public interface AreaService {
	
	/**
	 * 查询地区表
	 * @param condition
	 * @return
	 */
	public List<AreaCustom> queryAreas(AreaCustom condition);
	

}
