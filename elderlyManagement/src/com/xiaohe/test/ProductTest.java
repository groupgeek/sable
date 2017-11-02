package com.xiaohe.test;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.mapper.ProductMapper;
import com.xiaohe.mapper.ProducttransactionreportMapper;
import com.xiaohe.service.ProductService;
import com.xiaohe.service.ProducttransactionreportService;

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
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProducttransactionreportService producttransactionreportService;
	
	@Autowired
	private ProducttransactionreportMapper producttransactionreportMapper;
	

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
	
	@Test
	public void productInfoTest(){
		
		
		ProductCustom custom = productService.queryProductInfoById(4);
		
		System.out.println(custom);
		
	}
	
	@Test
	public void demo2(){
		Product record = new Product();
		record.setProductname("1");
		record.setProducttypeid(12);
		record.setBranchid(1);
		System.out.println(productMapper.insertSelective(record));
	}
	@Test
	public void Test223333(){
		
		
		/*EvaluationCustom custom = new EvaluationCustom();
		custom.setCurrentPage(1);
		custom.setProductid(1);
		
		
		System.out.println((productService.queryEvaluationByProductId(custom)));*/
		/*EvaluationCustom custom = productService.queryEvaluationLevalByProductId(3);
		
		System.out.println(custom.getBadReview());
		System.out.println(custom.getAverage());
		System.out.println(custom.getPraise());
		System.out.println(custom.getPraiseOf());*/
		
		//System.out.println(productService.queryEvaluationSum(1));
		
		 
			ProductCustom condition = new ProductCustom();
			condition.setProductid(1);
			condition.setBegin(0);
			condition.setTotal(4);
		System.out.println(productService.querySimilarProductsByProductId(condition));
	}
	
	@Test
	public void test56565(){
		/*ProducttransactionreportCustom custom = producttransactionreportService.statisticsProductSalesByProductId(2);
		System.out.println(custom.getTotalCount());
		System.out.println(custom.getTotalMoney());
		System.out.println(custom.getTotalExpenses());*/
		
		ProducttransactionreportCustom condition = new ProducttransactionreportCustom();
		Date date1 = new Date();
		Date date2 = new Date();
		date2.setYear(date1.getYear());
		date2.setMonth(date1.getMonth());
		date2.setDate(1);
		date2.setHours(0);
		date2.setMinutes(0);
		date1.setDate(32);
		date1.setHours(0);
		date1.setMinutes(0);
		
		System.out.println(date1.getTime() - date2.getTime());
		
		
		condition.setStartingTime(date2);
		condition.setEndTime(date1);
		
		condition.setProductid(1);
		condition.setUserid(26);
		condition.setSort("BuyTime");
		System.out.println(producttransactionreportMapper.selectByCondition(condition));
		
		
	}
	
	
}
