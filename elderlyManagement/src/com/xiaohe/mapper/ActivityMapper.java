package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityrecommendCustom;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activityid);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activityid);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKeyWithBLOBs(Activity record);

    int updateByPrimaryKey(Activity record);
    
    /**
     * 根据activity里面的字段查询活动表
     * @param aCustom activity扩展类  继承了activity 里面有自己的属性
     * @return 活动类集合
     */
    List<ActivityCustom> selectActivitiesByCondition(ActivityCustom aCustom);
    
    /**
	 * 查询活动推荐表，根据ActivityrecommendCustom区分
	 * @param ActivityrecommendCustom 条件
	 * @return ActivityrecommendCustom集合
	 */
    List<ActivityCustom> selectActivityrecommendByCondition(ActivityrecommendCustom custom);
}