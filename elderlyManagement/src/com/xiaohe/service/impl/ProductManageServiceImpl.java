package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.mapper.ProductMapper;
import com.xiaohe.mapper.ProductrecommendMapper;
import com.xiaohe.service.ProductManageService;

@Repository("productManageService")
public class ProductManageServiceImpl implements ProductManageService {
	
	@Autowired
	@Qualifier("productMapper")
	private ProductMapper productMapper;
	

	@Autowired
	@Qualifier("productrecommendMapper")
	private ProductrecommendMapper productrecommendMapper;
	
	
	
	
	public List<ProductCustom> quertyAllProduct(Integer branchid) throws Exception {
		
		return productMapper.quertyAllProduct(branchid);
	}

	public void deleteProduct(Integer productid) throws Exception {
		productMapper.deleteByPrimaryKey(productid);
		
	}

	public void insertProduct(Product product) throws Exception {
		productMapper.insertSelective(product);
	}

public EmployeeCustom productManageAdminsLogin(EmployeeCustom employeeCustom)throws Exception {
		EmployeeCustom admin = productMapper.selectAdminCustom(employeeCustom.getEmployeeid());
		if(admin == null){
			
			return null;
			
		}else if(admin.getPassword().equals(employeeCustom.getPassword()) == false){
			
			return  null;
			
		}else{
			return admin;
		}
	}



public Product quertyProduct(Integer productid) throws Exception {
	
	return productMapper.selectByPrimaryKey(productid);
}

public void updateProductCustom(Product product) throws Exception {
	productMapper.updateByPrimaryKeySelective(product);
}
public List<ProductCustom> quertyRecommendProduct(Integer branchid) {
	
	return productrecommendMapper.quertyRecommendProdcut(branchid);
}

}
