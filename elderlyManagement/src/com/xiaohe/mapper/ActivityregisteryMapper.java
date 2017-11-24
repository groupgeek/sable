package com.xiaohe.mapper;

import com.xiaohe.bean.Activityregistery;
import com.xiaohe.bean.ActivityregisteryKey;

public interface ActivityregisteryMapper {
    int deleteByPrimaryKey(ActivityregisteryKey key);

    int insert(Activityregistery record);

    int insertSelective(Activityregistery record);

    Activityregistery selectByPrimaryKey(ActivityregisteryKey key);

    int updateByPrimaryKeySelective(Activityregistery record);

    int updateByPrimaryKey(Activityregistery record);
    /**
     * 	用户活动查询
     * @param activityregistery
     * @return
     */
    Activityregistery  selectUserActivityregistery(Activityregistery activityregistery);
    
    /**
     * 根据用户id查询到用户的报名情况
     * @param id
     * @return
     */
    Activityregistery oneUserAct(Activityregistery activityregistery);
}