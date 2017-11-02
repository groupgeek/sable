package com.xiaohe.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.ActivitytypeCustom;

@Transactional
public interface ActivitytypeService {
	/**
	 * 查询所有类型不包括父类
	 * @return
	 */
	public List<ActivitytypeCustom> queryAllType();
	
	/**
	 * 查询所有分组并根据父类分组
	 * @return map集合
	 */
	public Map<String, List<ActivitytypeCustom>> queryAllTypeOrderByFather();
}
