package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Branch;
import com.xiaohe.bean.BranchCustom;

public interface BranchMapper {
    int deleteByPrimaryKey(Integer branchid);

    int insert(Branch record);

    int insertSelective(Branch record);

    Branch selectByPrimaryKey(Integer branchid);

    int updateByPrimaryKeySelective(Branch record);

    int updateByPrimaryKey(Branch record);
    
    /**
     * 根据管理员id查询分店
     * @param employeeid
     * @return
     */
    Branch oneBranch(Integer employeeid);
    
    /**
     * 查询所有分店
     * @return
     */
    List<BranchCustom> selectAll();
}