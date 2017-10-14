package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.mapper.ActivityMapper;
import com.xiaohe.service.ActivityService;

@Repository("activityService")
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	@Qualifier("activityMapper")
	private ActivityMapper activityMapper;

	public Activity queryActivityById(Integer id ) {
		return activityMapper.selectByPrimaryKey(id);
	}

	public List<ActivityCustom> queryActivitiesByCondition(
			ActivityCustom activityCondition) {
		
		return activityMapper.selectActivitiesByCondition(activityCondition);
	}

}
