package com.xiaohe.mapper;

import com.xiaohe.bean.Authority;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer authorityid);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer authorityid);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
}