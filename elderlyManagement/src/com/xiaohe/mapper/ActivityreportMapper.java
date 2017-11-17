package com.xiaohe.mapper;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.Activityreport;

public interface ActivityreportMapper {
    int deleteByPrimaryKey(Integer activityreporid);

    int insert(Activityreport record);

    int insertSelective(Activityreport record);

    Activityreport selectByPrimaryKey(Integer activityreporid);

    int updateByPrimaryKeySelective(Activityreport record);

    int updateByPrimaryKey(Activityreport record);
    
    /**
     * 查询活动的开展情况（总报名人数，总报名费）（报表）
     * @param activityCustom
     * @return
     */
    ActivityCustom activityCondition(ActivityCustom activityCustom);
}