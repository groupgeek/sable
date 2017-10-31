package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.PositionalCustom;
import com.xiaohe.mapper.PositionalMapper;
import com.xiaohe.service.PositionalSerice;

@Repository("positionalSerice")
public class PositionalSericeImpl implements PositionalSerice {

	
	@Autowired
	@Qualifier("positionalMapper")
	private PositionalMapper positionalMapper;
	
	public List<PositionalCustom> queryAll() {
		
		
		return positionalMapper.selectAll();
	}

}
