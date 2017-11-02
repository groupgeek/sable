package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.LevelCustom;
import com.xiaohe.mapper.LevelMapper;
import com.xiaohe.service.LevelSevice;

@Repository("levelSevice")
public class LevelSeviceImpl implements LevelSevice {

	@Autowired
	@Qualifier("levelMapper")
	private LevelMapper levelMapper;
	public List<LevelCustom> queryAll() {
		
		return levelMapper.selectAll();
	}

}
