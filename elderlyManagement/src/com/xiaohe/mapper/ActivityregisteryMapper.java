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
}