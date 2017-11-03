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
    
    /**
     * 查询所有分店的地区，盈利，管理员等信息
     * @param condition
     * @return
     */
    List<BranchCustom> selectAllBranchByCondition(BranchCustom condition);
    
    /**
     * 根据条件查询所有分店的数量 和 selectAllBranchByCondition一起用 
     * @param condition
     * @return
     */
    Integer selectAllBranchSumByCondition(BranchCustom condition);
    
    /**
     * 查询分店的所有信息
     * @param id
     * @return
     */
    BranchCustom selectBranchInfoById(Integer id);

    /**
     * 查询所有分店
     * @param branch
     * @return
     */
    List<Branch> selectAllBranchName(Branch branch);

    /**
     * 查询所有分店(包括分店管理员和分店所在地址)
     * @param ceoBranchCustom
     * @return
     */
    List<BranchCustom> selectBranchs(BranchCustom branchCustom);
}