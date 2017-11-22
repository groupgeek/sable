package com.xiaohe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;
import com.xiaohe.mapper.MedicalrecordsMapper;
import com.xiaohe.service.MedicalrecordsService;

@Repository("medicalrecordsService")
public class MedicalrecordsServiceImpl implements MedicalrecordsService {
	
	@Autowired
	@Qualifier("medicalrecordsMapper")
	private MedicalrecordsMapper medicalrecordsMapper;
	
	public MedicalrecordsWithBLOBsCustom quertyMedicalRecords(Integer id) {
	
		return medicalrecordsMapper.oneMedicalrecordsWithBLOBsCustom(id);
	}

}
