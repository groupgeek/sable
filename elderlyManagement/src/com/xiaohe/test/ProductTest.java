package com.xiaohe.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		System.out.println(productService.queryPopularProductByRank(1));
	}
	
	
	
}
