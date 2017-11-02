package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Authority;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer authorityid);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer authorityid);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
    
    /**
     * 查询所有的权限
     * @return
     */
    List<Authority> allAuths();
}