package com.xiaohe.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.ActivitytypeCustom;
import com.xiaohe.mapper.ActivitytypeMapper;
import com.xiaohe.service.ActivitytypeService;

@Repository("activitytypeService")
public class ActivitytypeServiceImpl implements ActivitytypeService {
	
	@Autowired
	@Qualifier("activitytypeMapper")
	private ActivitytypeMapper activitytypeMapper;

	public List<ActivitytypeCustom> queryAllType() {
		return activitytypeMapper.selectAllActTypes();
	}

	public Map<String, List<ActivitytypeCustom>> queryAllTypeOrderByFather() {
		//集合
		Map<String, List<ActivitytypeCustom>> allTypes = new HashMap<String, List<ActivitytypeCustom>>();
		List<ActivitytypeCustom> allSonTypes = new ArrayList<ActivitytypeCustom>();
		List<ActivitytypeCustom> allFatherTypes = new ArrayList<ActivitytypeCustom>();
		
		allFatherTypes = activitytypeMapper.selectFatherTypes();
		for(ActivitytypeCustom father : allFatherTypes){
			allSonTypes = activitytypeMapper.selectAllSonByFatherId(father.getActivitytypeid());
			allTypes.put(father.getActivitytypename(), allSonTypes);
		}
		return allTypes;
	}

}
