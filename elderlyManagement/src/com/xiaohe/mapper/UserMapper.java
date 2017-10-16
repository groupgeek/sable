package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 查询所有的用户信息
     * @return
     */
    List<UserCustom> queryAllUser();
}