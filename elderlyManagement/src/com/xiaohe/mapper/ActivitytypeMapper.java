package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Activitytype;
import com.xiaohe.bean.ActivitytypeCustom;

public interface ActivitytypeMapper {
    int deleteByPrimaryKey(Integer activitytypeid);

    int insert(Activitytype record);

    int insertSelective(Activitytype record);

    Activitytype selectByPrimaryKey(Integer activitytypeid);

    int updateByPrimaryKeySelective(Activitytype record);

    int updateByPrimaryKey(Activitytype record);
    
    /**
     * 查询所以的活动类型
     * @return
     */
    List<ActivitytypeCustom> AllActTypes(); 
}