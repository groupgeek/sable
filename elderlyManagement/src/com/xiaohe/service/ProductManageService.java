package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.ProductCustom;

@Transactional
public interface ProductManageService {
	
	//查询所有商品
	public List<ProductCustom> quertyAllProduct(Integer branchid) throws Exception;
	
	//删除商品
	public void  deleteProduct(Integer productid) throws Exception;
	
	//增加商品
	public void insertProduct(ProductCustom productCustom) throws Exception;
	
	//管理员登录
	//根据用户账号登录
	public EmployeeCustom productManageAdminsLogin(EmployeeCustom employeeCustom) throws Exception;
	
	

}
