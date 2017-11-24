package com.xiaohe.mapper;

import com.xiaohe.bean.Userlevelreport;

public interface UserlevelreportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userlevelreport record);

    int insertSelective(Userlevelreport record);

    Userlevelreport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userlevelreport record);

    int updateByPrimaryKey(Userlevelreport record);
}