package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityrecommendCustom;
import com.xiaohe.mapper.ActivityMapper;
import com.xiaohe.service.ActivityService;

@Repository("activityService")
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	@Qualifier("activityMapper")
	private ActivityMapper activityMapper;
	
	/**
	 * 给Introduction字段赋值 (活动描述里面的值的一部分)
	 * @param activityCustoms 查询出来的活动集合
	 * @param x 截取的位置
	 * @return activityCustoms
	 */
	public List<ActivityCustom> sub(List<ActivityCustom> activityCustoms , int x){
		
		
		for(int i = 0 ; i < activityCustoms.size(); i++){
			String introduction=activityCustoms.get(i).getActivitydetails().substring(0,x);
			activityCustoms.get(i).setIntroduction(introduction);
		}
		
		return activityCustoms;
	}
	
	public Activity queryActivityById(Integer id ) {
		return activityMapper.selectByPrimaryKey(id);
	}

	public List<ActivityCustom> queryActivitiesByCondition(
			ActivityCustom activityCondition) {
		List<ActivityCustom> activityCustoms = activityMapper.selectActivitiesByCondition(activityCondition);
		
		return sub(activityCustoms,4);
	}

	public List<ActivityCustom> queryActivityrecommend(ActivityrecommendCustom custom) {
		
		List<ActivityCustom> activityCustoms = activityMapper.selectActivityrecommendByCondition(custom);
	
		return sub(activityCustoms,4);
	}
	

	

}
