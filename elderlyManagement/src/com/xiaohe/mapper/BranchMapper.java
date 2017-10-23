package com.xiaohe.mapper;

import com.xiaohe.bean.Branch;

public interface BranchMapper {

    int deleteByPrimaryKey(Integer branchid);

    int insert(Branch record);

    int insertSelective(Branch record);

    Branch selectByPrimaryKey(Integer branchid);

    int updateByPrimaryKeySelective(Branch record);
    
    int updateByPrimaryKey(Branch record);
 
}