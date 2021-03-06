package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;

@Transactional
public interface ProductManageService {
	
	//查询所有商品
	public List<ProductCustom> quertyAllProduct(Integer branchid) throws Exception;
	
	//删除商品
	public void  deleteProduct(Integer productid) throws Exception;
	
	//增加商品
	public void insertProduct(Product product,MultipartFile pictureUpload) throws Exception;
	
	//管理员登录
	//根据用户账号登录
	public EmployeeCustom productManageAdminsLogin(EmployeeCustom employeeCustom) throws Exception;
	
	//商品信息更新
	public void updateProductCustom(Product product,MultipartFile pictureUpload)throws Exception;
	/**
	 * 查询单个商品信息
	 * @param productid
	 * @return 单个商品信息
	 * @throws 单个
	 */
	public Product quertyProduct(Integer productid) throws Exception;
	
	/**
	 * 
	 * @param branchid
	 * @return	本店现在推荐商品
	 */
	public List<ProductCustom> quertyRecommendProduct(Integer branchid);
	
	
		
	

}
 