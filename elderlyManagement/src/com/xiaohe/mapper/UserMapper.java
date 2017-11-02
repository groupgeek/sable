package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    /**
     * 插入用戶
     * @param record 用戶信息
     * @return
     */
    int insertSelective(UserCustom record);

    UserCustom selectByPrimaryKey(Integer userid);

    /**
     * 更新用戶
     * @param record 更新信息
     * @return
     */
    int updateByPrimaryKeySelective(UserCustom record);

    int updateByPrimaryKey(User record);
    
    /**
     * 查询所有的用户信息
     * @return
     */
    List<UserCustom> queryAllUser();
    
    /**
     * 根据手机号查询用户
     * @param phone 手机号
     * @return
     */
    UserCustom selectUserByPhone(String phone);
    
    /**
     * 查询分店所有的用户信息
     * @param employeeid
     * @return
     */
    List<UserCustom> branchUserCustoms(Integer areaid);
    
    /**
     * 查询分店的所有用户数量
     * @return
     */
    int countBranchUser(Integer id);
    
    /**
     * 改变用户的在线情况
     * @param userid
     * @return
     */
    int changeOnLine(UserCustom user);
    
    /**
     * 查询用户信息
     * @param condition
     * @return
     */
    List<UserCustom> selectAllUserByCondition(UserCustom condition);
    
    /**
     * 查询用户数量
     * @param condition
     * @return
     */
    Integer selectAllUserSumByCondition(UserCustom condition);
    
    /**
     * 查询用户所有信息
     * @return
     */
    UserCustom selectUserInfoById(Integer id);
}