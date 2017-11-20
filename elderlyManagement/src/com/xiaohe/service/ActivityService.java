package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityVo;
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
	 * 查询所有活动
	 * @return
	 */
	public List<Activity> getpicture();
	 /**
     * 查询activitytypeId=1的活动
     */
    public List<Activity> getonline();
    /**
     * 查询activitytypeId=5的活动
     */
    public List<Activity> getlecture();
    
    /**
     * 查询activitytypeId=4的活动
     */
    public List<Activity> getactivity();
    /**
     * 查询activitytypeId=6的直播
     */
    public List<Activity> getLive();
    /**
     * 
     */
    public Activity getactivityid(int id );
    /**
     * 
     * 
     */
    public void insertactivityid(int activityid,int userid );
    /**
     * 
     */
    public void delectactivityid(int activityid,int userid );
    
}
