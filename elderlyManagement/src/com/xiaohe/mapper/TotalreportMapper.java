package com.xiaohe.mapper;

import com.xiaohe.bean.Totalreport;

public interface TotalreportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Totalreport record);

    int insertSelective(Totalreport record);

    Totalreport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Totalreport record);

    int updateByPrimaryKey(Totalreport record);
}