package com.xiaohe.test;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.service.ProductService;

/**
 * 测试
 * @author 张彪
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class ProductTest {
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	

	@org.junit.Test
	public void queryPopularProductByRankTest(){
		
		ProductCustom productCustom = new ProductCustom();
		
		productCustom.setBegin(0);
		productCustom.setTotal(3);
		System.out.println(productService.queryPopularProductByCondition(productCustom));
	}
	
	@Test
	public void type(){
		
		ProducttypeCustom producttypeCustom = new ProducttypeCustom();
		producttypeCustom.setFatherid(7);
		//producttypeCustom.setProducttypeid(7);
		System.out.println(productService.queryProductTypeByCondition(producttypeCustom));
	}
	
	@Test
	public void blurry(){
		
		System.out.println(productService.queryProductByBlurry("1").size());
	}
	@Test
	public void type1(){
		ProductCustom products = new ProductCustom();
		//products.setSearch("");
		//products.setProducttypename("裤子");
		products.setSort("price");
		//products.setBegin(1);
		//products.setTotal(1);
		//products.setCurrentPage(2);
		//products.setSort("price");
		//products.setBegin(1);
		products.setTotal(4);
		products.setCurrentPage(1);
		java.util.List<ProductCustom> haha = new ArrayList<ProductCustom>();
		haha = productService.queryProductByCondition(products);
		for(ProductCustom h : haha ){
			
			System.out.println(h.getPrice());
		}
	}
	
	
}
