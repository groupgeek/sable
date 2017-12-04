package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttypeCustom;

@Transactional
public interface ProductTypeService {
	
	/**
	 * 根据父类查询子类
	 * @return 商品类型集合
	 */
	public List<ProducttypeCustom> queryProductTypeByFather(ProducttypeCustom producttype);
	
	/**
	 * 查询出商品小类型
	 * @param
	 * @return
	 */
	public List<ProducttypeCustom> querySimallProducttype();
	
	/**
	 * 根据父类id查询子类
	 * @param id
	 * @return
	 */
	public List<ProducttypeCustom> queryProductTypeByFatherId(Integer id);
	
	/**
	 * 查询父类类型
	 * @return
	 */
	public List<ProducttypeCustom> queryFatherType();
	
	/**
	 *  添加商品大类型
	 * @param addfatherType
	 * @return
	 */
	public boolean addProductFather(String addfatherType);
	
	/**
	 *  添加商品类型
	 * @param data
	 * @return
	 */
	public boolean addProductType(ProducttypeCustom data);
}
