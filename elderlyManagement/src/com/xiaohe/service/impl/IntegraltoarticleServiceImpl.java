package com.xiaohe.service.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.Integral;
import com.xiaohe.bean.IntegralCustom;
import com.xiaohe.bean.IntegralorderCuntom;
import com.xiaohe.bean.Integraltoarticle;
import com.xiaohe.bean.IntegraltoarticleCuntom;
import com.xiaohe.bean.IntegraltoarticleVo;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.IntegralMapper;
import com.xiaohe.mapper.IntegralorderMapper;
import com.xiaohe.mapper.IntegraltoarticleMapper;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.IntegraltoarticleService;
import com.xiaohe.util.FileUpload;

@Repository("integraltoarticleService")
public class IntegraltoarticleServiceImpl implements IntegraltoarticleService {
	
	@Autowired
	@Qualifier("integraltoarticleMapper")
	private IntegraltoarticleMapper integraltoarticleMapper;
	
	@Autowired
	@Qualifier("integralorderMapper")
	private IntegralorderMapper integralorderMapper;
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	
	@Autowired
	@Qualifier("integralMapper")
	private IntegralMapper integralMapper;
	

	public IntegraltoarticleVo queryAllProductIntegralByProductTypeId(
			IntegraltoarticleCuntom condition) {
		
		if(condition == null) return null;
		if(condition.getUserid() == null) return null;
		IntegraltoarticleVo productVo = new IntegraltoarticleVo();
		List<IntegraltoarticleCuntom> allProducts = new ArrayList<IntegraltoarticleCuntom>();
		Integer pageSum = 0;
		Integer sum = 0;
		
			
		if(condition.getCurrentPage() >= 1){
			Integer tempBegin = (condition.getCurrentPage()-1) * condition.getPageNum();
			condition.setBegin(tempBegin);
		}else{
			condition.setBegin(0);
		}
			
		
		
		allProducts = integraltoarticleMapper.selectAllIntegralProductByCondition(condition);
		sum = integraltoarticleMapper.selectAllIntegralProductSumByCondition(condition);
		pageSum = sum / condition.getPageNum();
		if(sum % condition.getPageNum() != 0){
			pageSum += 1;
		}
		productVo.setProductList(allProducts);
		productVo.setProductSum(sum);
		productVo.setPageSum(pageSum);
		
		
		return productVo;
	}

	public boolean addIntegralOrder(IntegraltoarticleCuntom info) {
		
		if(info == null) return false;
		if(info.getUserid() == null) return false;
		if(info.getArticleid() == null) return false;
		if(info.getPassword() == null) return false;
		
		UserCustom user = new UserCustom();
		IntegralCustom integral = new IntegralCustom();
		Integraltoarticle integraltoarticle = new IntegraltoarticleCuntom();
		IntegralorderCuntom order = new IntegralorderCuntom();
		
		//查询用户
		user = userMapper.selectUserInfoById(info.getUserid());
		if(user == null) return false;
		if(!info.getPassword().equals(user.getPassword())) return false;
		
		//查询积分情况
		integral.setUserid(user.getUserid());
		integral = integralMapper.selectUpToDateRecord(integral);
		if(integral == null) return false;
		
		//查询商品情况
		integraltoarticle = integraltoarticleMapper.selectByPrimaryKey(info.getArticleid());
		
		//判断积分是否足够
		if(integraltoarticle.getIntegral() > integral.getRemainingpoints() || integral.getRemainingpoints() == null) return false;
		
		//生成订单
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderid = df.format(new Date())+(integralorderMapper.selectCountOrder()+1) + UUID.randomUUID().toString().split("-")[0];
		
		order.setIntegralorderid(orderid);
		order.setArticleid(integraltoarticle.getArticleid());
		order.setUsername(user.getUsername());
		order.setUserid(user.getUserid());
		order.setResaddress(info.getResaddress());
		order.setPhone(info.getPhone());
		//order.setPrice(integraltoarticle.getIntegral());
		order.setOrdertime(new Date());
		order.setBranchid(integraltoarticle.getBranchid());
		order.setIntegral(integraltoarticle.getIntegral());
		
		order.setOrderstatus("已付款");
		order.setProductstatus("未发货");
		//order.setSignstatus("未签收");
		if(integralorderMapper.insertSelective(order) <= 0) return false;
		
		//扣除积分
		Integral integralInfo = new Integral();
		integralInfo.setUserid(user.getUserid());
		integralInfo.setDetails("兑换商品，单号："+orderid);
		integralInfo.setChangeintegral(0-integraltoarticle.getIntegral());
		integralInfo.setRemainingpoints(integral.getRemainingpoints() - integraltoarticle.getIntegral());
		integralInfo.setChangetime(new Date());
		
		if(integralMapper.insertSelective(integralInfo) <= 0) return false; 
		
		return true;
	}

	public boolean addPointsProduct(Integraltoarticle integraltoarticle,
			MultipartFile pictureUpload) {
		
		if(integraltoarticle.getBranchid() == null) return false;
		if(integraltoarticle.getArticlename() == null) return false;
		
		if(pictureUpload != null){
			if(!pictureUpload.isEmpty()){
				try {
					integraltoarticle.setPicture(FileUpload.oneFileUpload(pictureUpload,null, "picture"));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(integraltoarticleMapper.insertSelective(integraltoarticle) <= 0) return false;
		
		return true;
	}

}
