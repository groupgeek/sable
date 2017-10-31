package com.xiaohe.mapper;

import com.xiaohe.bean.Level;

public interface LevelMapper {
    int deleteByPrimaryKey(Integer levelid);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(Integer levelid);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);
    
    /**
     * 根据用户id查询等级
     * @param id
     * @return
     */
    Level oneLev(Integer id);
}