package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Lecturer;
import com.xiaohe.bean.LecturerCustom;

public interface LecturerMapper {
    int deleteByPrimaryKey(Integer lecturerid);

    int insert(Lecturer record);

    int insertSelective(Lecturer record);

    Lecturer selectByPrimaryKey(Integer lecturerid);

    int updateByPrimaryKeySelective(Lecturer record);

    int updateByPrimaryKey(Lecturer record);
    
    /**
     * 根据用户ID查询出本地区的所有的讲师
     * @param userid
     * @return
     */
    List<LecturerCustom> selectAllByBranch(Integer userid);
}