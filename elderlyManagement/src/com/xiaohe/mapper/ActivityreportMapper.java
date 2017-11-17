package com.xiaohe.mapper;

import com.xiaohe.bean.Activityreport;

public interface ActivityreportMapper {
    int deleteByPrimaryKey(Integer activityreporid);

    int insert(Activityreport record);

    int insertSelective(Activityreport record);

    Activityreport selectByPrimaryKey(Integer activityreporid);

    int updateByPrimaryKeySelective(Activityreport record);

    int updateByPrimaryKey(Activityreport record);
}