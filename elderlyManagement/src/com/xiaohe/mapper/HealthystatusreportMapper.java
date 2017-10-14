package com.xiaohe.mapper;

import com.xiaohe.bean.Healthystatusreport;

public interface HealthystatusreportMapper {
    int deleteByPrimaryKey(Integer healthystatusid);

    int insert(Healthystatusreport record);

    int insertSelective(Healthystatusreport record);

    Healthystatusreport selectByPrimaryKey(Integer healthystatusid);

    int updateByPrimaryKeySelective(Healthystatusreport record);

    int updateByPrimaryKeyWithBLOBs(Healthystatusreport record);

    int updateByPrimaryKey(Healthystatusreport record);
}