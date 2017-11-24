package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.AreaCustom;
import com.xiaohe.mapper.AreaMapper;
import com.xiaohe.service.AreaService;

@Repository("areaService")
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	@Qualifier("areaMapper")
	private AreaMapper areaMapper;

	public List<AreaCustom> queryAreas(AreaCustom condition) {
		return areaMapper.selectAreasByCondition(condition);
	}

}
