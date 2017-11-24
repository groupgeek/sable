package com.xiaohe.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityVo;
import com.xiaohe.bean.ActivityrecommendCustom;
import com.xiaohe.bean.Activityregistery;
import com.xiaohe.bean.Activityreport;
import com.xiaohe.bean.ActivitytypeCustom;
import com.xiaohe.mapper.ActivityMapper;
import com.xiaohe.mapper.ActivityregisteryMapper;
import com.xiaohe.mapper.ActivityreportMapper;
import com.xiaohe.mapper.ActivitytypeMapper;
import com.xiaohe.service.ActivityService;
import com.xiaohe.util.FileUpload;
import com.xiaohe.util.GetStringByDate;

@Repository("activityService")
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	@Qualifier("activityMapper")
	private ActivityMapper activityMapper;
	
	@Autowired
	@Qualifier("activitytypeMapper")
	private ActivitytypeMapper activitytypeMapper;
	
	@Autowired
	@Qualifier("activityregisteryMapper")
	private ActivityregisteryMapper activityregisteryMapper;
	
	@Autowired
	private ActivityreportMapper activityreportMapper;
	
	/**
	 * 给Introduction字段赋值 (活动描述里面的值的一部分)
	 * @param activityCustoms 查询出来的活动集合
	 * @param x 截取的位置
	 * @return activityCustoms
	 */
	public List<ActivityCustom> sub(List<ActivityCustom> activityCustoms , int x){
		
		
		for(int i = 0 ; i < activityCustoms.size(); i++){
			String introduction=activityCustoms.get(i).getActivitydetails().substring(0,x);
			activityCustoms.get(i).setIntroduction(introduction);
		}
		
		return activityCustoms;
	}
	
	public ActivityCustom queryActivityById(Integer id ) {
		ActivityCustom activityCustom = (ActivityCustom) activityMapper.selectByPrimaryKey(id);
		activityCustom.setActivitydateString(GetStringByDate.getString(activityCustom.getActivitydate()));
		return activityCustom;
	}

	public List<ActivityCustom> queryActivitiesByCondition(
			ActivityCustom activityCondition) {
		List<ActivityCustom> activityCustoms = activityMapper.selectActivitiesByCondition(activityCondition);
		
		return sub(activityCustoms,4);
	}

	public List<ActivityCustom> queryActivityrecommend(ActivityrecommendCustom custom) {
		
		List<ActivityCustom> activityCustoms = activityMapper.selectActivityrecommendByCondition(custom);
	
		return sub(activityCustoms,4);
	}

	public ActivityVo queryAllActivityByCondition(ActivityCustom condition) {
		
		ActivityVo activityVo = new ActivityVo();
		List<ActivityCustom> allActivity = new ArrayList<ActivityCustom>();
		Integer pageSum = 0;
		Integer sum = 0;
		
		if(condition != null){
			condition.setActivityname(condition.getSearch());
			condition.setActivitydetails(condition.getSearch());
			if("全部".equals(condition.getActivitystatus())){
				condition.setActivitystatus(null);
			}
			
			if(condition.getCurrentPage() >= 1){
				Integer tempBegin = (condition.getCurrentPage()-1) * condition.getPageNum();
				condition.setBegin(tempBegin);
			}else{
				condition.setBegin(0);
			}
			
		}
		
		allActivity = activityMapper.selectAllActivityByCondition(condition);
		for(ActivityCustom activityCustom : allActivity){
			activityCustom.setActivitydateString(GetStringByDate.getString(activityCustom.getActivitydate()));
		}
		sum = activityMapper.selectAllActivitySumByCondition(condition);
		pageSum = sum / condition.getPageNum();
		if(sum % condition.getPageNum() != 0){
			pageSum += 1;
		}
		
		activityVo.setActivityList(allActivity);
		activityVo.setActivitySum(sum);
		activityVo.setPageSum(pageSum);
		
		
		
		return activityVo;
	}

	public ActivityCustom queryActivityInfoById(Integer id) {
		if(id == null || id < 0) return null;
		
		ActivityCustom activityInfo = activityMapper.selectActivityInfoById(id);
		activityInfo.setActivitydateString(GetStringByDate.getString(activityInfo.getActivitydate()));
		return activityInfo;
	}

	public boolean updateActivityInfo(ActivityCustom activityInfo,MultipartFile videoUpload,MultipartFile pictureUpload) {
		
		if(activityInfo == null) return false;
		if(activityInfo.getActivityid() == null || activityInfo.getActivityid() <0) return false;
		if(activityInfo.getActivityname() == null || " ".equals(activityInfo.getActivityname()) || "".equals(activityInfo.getActivityname()))
			return false;
		if(!videoUpload.isEmpty()){
			try {
				String newVideo = FileUpload.oneFileUpload(videoUpload,activityInfo.getVideo() , "video");
				activityInfo.setVideo(newVideo);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(!pictureUpload.isEmpty()){
			try {
				activityInfo.setActivitypicture(FileUpload.oneFileUpload(pictureUpload,activityInfo.getActivitypicture(), "picture"));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(activityMapper.updateByPrimaryKeySelective(activityInfo) < 0) return false;
		return true;
	}

	public boolean addActivity(ActivityCustom activity,MultipartFile videoUpload,MultipartFile pictureUpload) {
		if(activity == null) return false;
		
		if(!videoUpload.isEmpty()){
			try {
				String newVideo = FileUpload.oneFileUpload(videoUpload,null ,"video");
				activity.setVideo(newVideo);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(!pictureUpload.isEmpty()){
			try {
				activity.setActivitypicture(FileUpload.oneFileUpload(pictureUpload,null,"picture"));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(activityMapper.insertSelective(activity) < 0) return false;
		return true;
	}

	public boolean deleteActivity(Integer activityid) {
		
		if(activityid == null) return false;
		if(activityMapper.deleteByPrimaryKey(activityid) <= 0) return false;
		
		return true;
	}
	

	public List<Activity> queryActivityByUserId(int id) {
		return activityMapper.queryActivityByUserId(id);
	}

	public List<ActivitytypeCustom> queryAllEduType() {
		
		List<ActivitytypeCustom> allType = new ArrayList<ActivitytypeCustom>();
		
		allType = activitytypeMapper.selectAllEduType();
		
		return allType;
	}

	public Map<String, List<ActivityCustom>> queryEduRecordByUserid(
			Integer userid) {
		if(userid == null) return null;
		
		Map<String, List<ActivityCustom>> all = new HashMap<String, List<ActivityCustom>>();
		List<ActivitytypeCustom> allType = new ArrayList<ActivitytypeCustom>();
		List<ActivityCustom> allAct = new ArrayList<ActivityCustom>();
		ActivityCustom condition = new ActivityCustom();
		condition.setUserid(userid);
		condition.setPageNum(3);
		condition.setBegin(0);
		//查询所有分类
		allType = activitytypeMapper.selectAllEduType();
		
		if(allType == null) return null;
		
		for(ActivitytypeCustom record : allType){
			condition.setActivitytypeid(record.getActivitytypeid());
			allAct = activityMapper.selectActivityByTypeAndUserid(condition);
			
			all.put(record.getActivitytypename(), allAct);
		}
		
		
		return all;
	}

	public ActivityVo queryEduAllTypeActByCondition(ActivityCustom condition) {
		if(condition == null) return null;
		if(condition.getCurrentPage() == null) return null;
		
		condition.setPageNum(1);///////////////////////////////////
		
		ActivityVo activityVo = new ActivityVo();
		List<ActivityCustom> allActivity = new ArrayList<ActivityCustom>();
		Integer pageSum = 0;
		Integer sum = 0;
		
		
		if(condition.getCurrentPage() >= 1){
			Integer tempBegin = (condition.getCurrentPage()-1) * condition.getPageNum();
			condition.setBegin(tempBegin);
		}else{
			condition.setBegin(0);
		}
			
		
		allActivity = activityMapper.selectActivityByTypeAndUserid(condition);
		for(ActivityCustom activityCustom : allActivity){
			activityCustom.setActivitydateString(GetStringByDate.getString(activityCustom.getActivitydate()));
		}
		sum = activityMapper.selectActivitySumByTypeAndUserid(condition);
		pageSum = sum / condition.getPageNum();
		if(sum % condition.getPageNum() != 0){
			pageSum += 1;
		}
		
		activityVo.setActivityList(allActivity);
		activityVo.setActivitySum(sum);
		activityVo.setPageSum(pageSum);
		
		
		
		return activityVo;
	}

	public ActivityCustom oneAct(Integer id) {
		return activityMapper.oneActivityCustom(id);
	}

	public Integer countPeople(Integer id) {
		return activityMapper.countActNo(id);
	}
	
	public List<ActivityCustom> quertyActivityArea(String phone) {
	 	
		return activityMapper.quertyActivityArea(phone);
	}

	public Activity quertyUserActivity(Integer activityid) {
		
		return activityMapper.selectByPrimaryKey(activityid);
	}

	
	public void insertUserRegistery(Activityregistery activityregistery) {
		activityregisteryMapper.insert(activityregistery);
	}

	public boolean quertyIfUsetRegistery(Activityregistery activityregistery ) {
		Activityregistery acrg=new Activityregistery();
		acrg=activityregisteryMapper.selectUserActivityregistery(activityregistery);
		if (acrg!=null) {
			if (acrg.getActivityid().equals(activityregistery.getActivityid())) {
				if (acrg.getUserid().equals(activityregistery.getUserid())) {
					if (acrg.getRegistery().equals("报名")) {
						return false;
					}return true;
				}return true;
			}return true;
		}
		
		return true;
	}

	public int insertActRec(Activityregistery activityregistery) {
		activityregisteryMapper.insert(activityregistery);
		return 0;
	}

	public Activityregistery oneActreg(Activityregistery activityregistery) {
		return activityregisteryMapper.selectByPrimaryKey(activityregistery);
	}

	public Activityregistery oneUserAct(Activityregistery activityregistery) {
		return activityregisteryMapper.oneUserAct(activityregistery);
	}

	public Activityreport oneActivityreport(Integer id) {
		return activityreportMapper.oneActivityreport(id);
	}

	public int updateActrep(Activityreport activityreport) {
		activityreportMapper.updateByPrimaryKey(activityreport);
		return 0;
	}
	
	
    
}
