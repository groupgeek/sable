package com.xiaohe.mapper;

import com.xiaohe.bean.Lecturer;

public interface LecturerMapper {
    int deleteByPrimaryKey(Integer lecturerid);

    int insert(Lecturer record);

    int insertSelective(Lecturer record);

    Lecturer selectByPrimaryKey(Integer lecturerid);

    int updateByPrimaryKeySelective(Lecturer record);

    int updateByPrimaryKey(Lecturer record);
}