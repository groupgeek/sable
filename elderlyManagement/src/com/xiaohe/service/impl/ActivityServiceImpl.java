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
		List<ActivityCustom> activityCustoms = activityMapper.selectActivitiesByCondition(activityCondition);
		for(int i = 0 ; i < activityCustoms.size(); i++){
			String introduction=activityCustoms.get(i).getActivitydetails().substring(0,4);
			activityCustoms.get(i).setIntroduction(introduction);
		}
		return activityCustoms;
	}

	

}
