package com.xiaohe.mapper;

import com.xiaohe.bean.Medicalrecords;
import com.xiaohe.bean.MedicalrecordsWithBLOBs;

public interface MedicalrecordsMapper {
    int deleteByPrimaryKey(Integer medicalrecordsid);

    int insert(MedicalrecordsWithBLOBs record);

    int insertSelective(MedicalrecordsWithBLOBs record);

    MedicalrecordsWithBLOBs selectByPrimaryKey(Integer medicalrecordsid);

    int updateByPrimaryKeySelective(MedicalrecordsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MedicalrecordsWithBLOBs record);

    int updateByPrimaryKey(Medicalrecords record);
}