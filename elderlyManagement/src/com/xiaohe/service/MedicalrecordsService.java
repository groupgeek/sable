package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;

@Transactional
public interface MedicalrecordsService {
	/**
	 *  查询用户病例
	 * @return
	 */
	MedicalrecordsWithBLOBsCustom quertyMedicalRecords(Integer id);
}
