package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Producttype;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.mapper.ProducttypeMapper;
import com.xiaohe.service.ProductTypeService;

@Repository("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {
	
	
	@Autowired
	@Qualifier("producttypeMapper")
	private ProducttypeMapper producttypeMapper;

	public List<ProducttypeCustom> queryProductTypeByFather(ProducttypeCustom producttype) {
		return producttypeMapper.selectProductTypeByFatherId(producttype);
	}

	public List<ProducttypeCustom> querySimallProducttype() {
		ProducttypeCustom condition = new ProducttypeCustom();
		condition.setBegin(0);
		condition.setPageNum(9);
		return producttypeMapper.selectSmallProductType(condition);
	}

	public List<ProducttypeCustom> queryProductTypeByFatherId(Integer id) {
		
		return producttypeMapper.selectProductTypeByFather(id);
	}

	public List<ProducttypeCustom> queryFatherType() {
		return producttypeMapper.selectAllFatherType();
	}

	public boolean addProductFather(String addfatherType) {
		if(addfatherType == null || "".equals(addfatherType)) return false;
		
		addfatherType = addfatherType.substring(1, addfatherType.length()-1);
		Producttype record = new Producttype();
		record.setFatherid(0);
		record.setProducttypename(addfatherType);
		if(producttypeMapper.insertSelective(record) <= 0) return false;
		
		return true;
	}

	public boolean addProductType(ProducttypeCustom data) {
		
		if(data == null) return false;
		
		if(data.getFatherid() == null || data.getProducttypename() == null) return false;
		
		if(producttypeMapper.insertSelective(data) <= 0) return false;
		
		return true;
	}

}
