package com.xiaohe.mapper;

import com.xiaohe.bean.Medicalrecords;
import com.xiaohe.bean.MedicalrecordsWithBLOBs;
import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;
import com.xiaohe.bean.User;

public interface MedicalrecordsMapper {
    int deleteByPrimaryKey(Integer medicalrecordsid);

    int insert(MedicalrecordsWithBLOBs record);

    int insertSelective(MedicalrecordsWithBLOBs record);

    MedicalrecordsWithBLOBs selectByPrimaryKey(Integer medicalrecordsid);

    int updateByPrimaryKeySelective(MedicalrecordsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MedicalrecordsWithBLOBs record);

    int updateByPrimaryKey(Medicalrecords record);
    
    /**
     * 根据id查用户病例
     * @param id
     * @return
     */
    MedicalrecordsWithBLOBsCustom oneMedicalrecordsWithBLOBsCustom(Integer id);
    
    
    /**
     * 更新部分信息
     * @param medicalrecordsWithBLOBsCustom
     */
    void updateMeds(MedicalrecordsWithBLOBsCustom medicalrecordsWithBLOBsCustom);
    
    User oneUser(Integer id);
}