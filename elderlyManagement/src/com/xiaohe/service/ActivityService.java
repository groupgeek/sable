package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityrecommendCustom;

/**
 * 活动处理
 * @author 张彪
 *
 */
@Transactional
public interface ActivityService {
	/**
	 * 根据id查询活动
	 * @return ActivityCustom对象
	 */
	public Activity queryActivityById(Integer id);
	
	/**
	 * 根据活动状态查询活动   已开展 未开展 正在开展
	 * @param status 活动状态
	 * @return ActivityCustom集合
	 *//*
	public List<ActivityCustom> queryActivitiesByStatus(String status);
	
	*//**
	 * 查询线上或者线下的全部活动
	 * @param online 是否线上 boolean类型
	 * @return ActivityCustom集合
	 *//*
	public List<ActivityCustom> queryActivitiesByOnline(Boolean online);
	*/
	/**
	 * 根据activity里面的字段查询活动
	 * @param activityCondition 条件
	 * @return ActivityCustom集合
	 */
	public List<ActivityCustom> queryActivitiesByCondition(ActivityCustom activityCondition);
	
	/**
	 * 查询活动推荐表，根据ActivityrecommendCustom区分
	 * @param ActivityrecommendCustom 条件
	 * @return ActivityCustom集合
	 */
	public List<ActivityCustom> queryActivityrecommend(ActivityrecommendCustom custom);
	

}
