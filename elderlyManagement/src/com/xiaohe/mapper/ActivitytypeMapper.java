package com.xiaohe.mapper;

import com.xiaohe.bean.Activitytype;

public interface ActivitytypeMapper {
    int deleteByPrimaryKey(Integer activitytypeid);

    int insert(Activitytype record);

    int insertSelective(Activitytype record);

    Activitytype selectByPrimaryKey(Integer activitytypeid);

    int updateByPrimaryKeySelective(Activitytype record);

    int updateByPrimaryKey(Activitytype record);
}