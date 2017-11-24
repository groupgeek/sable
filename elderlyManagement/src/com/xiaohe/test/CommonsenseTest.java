package com.xiaohe.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaohe.bean.CommonsenseCustom;
import com.xiaohe.service.CommonsenseService;

/**
 * 测试
 * @author 张彪
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class CommonsenseTest {
	@Autowired
	@Qualifier("commonsenseService")
	private CommonsenseService commonsenseService;
	
	@Test
	public void test1(){
		CommonsenseCustom commonsenseCustom = new CommonsenseCustom();
		//commonsenseCustom.setCommonsenseid(1);
		//commonsenseCustom.setEditorid(1);
		//commonsenseCustom.setBranchid(1);
		//commonsenseCustom.setTitle("1");
		commonsenseCustom.setWebsitetype("官网");
		commonsenseCustom.setContexttype("养生小常识");
		commonsenseCustom.setBegin(0);
		commonsenseCustom.setTotal(5);
		System.out.println();
		for(CommonsenseCustom CCustom2: commonsenseService.queryCommonsenseByCondition(commonsenseCustom)){
			
			System.out.println(CCustom2);
			
		}
		
	}

}
