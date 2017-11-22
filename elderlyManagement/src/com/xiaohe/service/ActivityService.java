package com.xiaohe.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityVo;
import com.xiaohe.bean.ActivityrecommendCustom;
import com.xiaohe.bean.ActivitytypeCustom;

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
	public ActivityCustom queryActivityById(Integer id);
	
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
	
	/**
	 * 查询所有活动
	 * @param condition
	 * @return
	 */
	public ActivityVo queryAllActivityByCondition(ActivityCustom condition);
	
	/**
	 * 查询活动所有信息
	 * @param id
	 * @return
	 */
	public ActivityCustom queryActivityInfoById(Integer id);
	
	/**
	 * 更新活动详细信息
	 * @param activityInfo
	 * @return
	 */
	public boolean updateActivityInfo(ActivityCustom activityInfo,MultipartFile videoUpload,MultipartFile pictureUpload);
	
	
	/**
	 * 添加活动
	 * @param activity
	 * @return
	 */
	public boolean addActivity(ActivityCustom activity,MultipartFile videoUpload,MultipartFile pictureUpload);
	
	
	/**
	 * 删除活动
	 * @param activityid
	 * @return
	 */
	public boolean deleteActivity(Integer activityid);
	
	/**
	 * 查询用户活动
	 * @return
	 */
	public List<Activity> queryActivityByUserId(int id);
	
    /**
     * 查询教育的所有的小分类
     * @return
     */
	public List<ActivitytypeCustom> queryAllEduType();
	
	/**
	 * 根据用户查询出用户所在地区的有关教育所有类型的活动
	 * @param userid
	 * @return Map<ActivitytypeCustom, List<ActivityCustom>>
	 */
	public Map<String, List<ActivityCustom>> queryEduRecordByUserid(Integer userid);
	
	
	/**
	 * 查询教育里面的某一类所有活动
	 * @param condition
	 * @return
	 */
	public ActivityVo queryEduAllTypeActByCondition(ActivityCustom condition);
	
	/**
	 * 根据活动id查询到单个活动
	 * @param id
	 * @return
	 */
	public ActivityCustom oneAct(Integer id);
	
	/**
	 * 根据活动id查询活动总人数
	 * @param id
	 * @return
	 */
	public Integer countPeople(Integer id);
}
