package com.xiaohe.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.service.ActivityService;
/**
 * 测试
 * @author 张彪
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class ActivityTest {
	
	@Autowired
	@Qualifier("activityService")
	private ActivityService activityService;
	
	@Test
	public void activityConditon(){
		ActivityCustom aCustom=new ActivityCustom();
		aCustom.setActivityid(2);
		aCustom.setActivityname("跑");
		aCustom.setActivitystatus("已开展");
		aCustom.setOnline(false);
		aCustom.setBranchid(1);
		aCustom.setActivitytypeid(2);
		aCustom.setBegin(0);
		aCustom.setTotal(2);
		
		
		
		for(ActivityCustom aCustom2: activityService.queryActivitiesByCondition(aCustom)){
			
			System.out.println(aCustom2);
			
		}
		
		
		
	}
	@Test
	public void queryActivityrecommendTest(){
		System.out.println(activityService.queryActivityrecommend("分店官网").get(0).getWebsitetype());
		
	}
	

}
