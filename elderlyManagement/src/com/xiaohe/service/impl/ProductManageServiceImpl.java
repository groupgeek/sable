package com.xiaohe.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.mapper.ProductMapper;
import com.xiaohe.mapper.ProductrecommendMapper;
import com.xiaohe.service.ProductManageService;
import com.xiaohe.util.FileUpload;

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

	public void insertProduct(Product product,MultipartFile pictureUpload) throws Exception {
		if(!pictureUpload.isEmpty()){
			try {
				product.setPicture(FileUpload.oneFileUpload(pictureUpload,product.getPicture(), "picture"));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
