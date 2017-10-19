package com.xiaohe.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		products.setSearch("1");
		products.setProducttypename("衣服");
		products.setSort("good");
		products.setBegin(0);
		products.setTotal(5);
		
		System.out.println(productService.queryProductByCondition(products).size());
	}
	
	
}
