package com.xiaohe.mapper;

import com.xiaohe.bean.Verificationcode;

public interface VerificationcodeMapper {
    int deleteByPrimaryKey(String phone);

    int insert(Verificationcode record);

    int insertSelective(Verificationcode record);

    Verificationcode selectByPrimaryKey(String phone);

    int updateByPrimaryKeySelective(Verificationcode record);

    int updateByPrimaryKey(Verificationcode record);
}