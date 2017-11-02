package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Level;
import com.xiaohe.bean.LevelCustom;

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
    
    /**
     * 查询所有用户等级
     * @return
     */
    List<LevelCustom> selectAll();
}