package com.xiaohe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.service.ActivityService;

@Controller
@RequestMapping("edu")
public class ActivityController {
	@Autowired
	@Qualifier("activityService")
	private ActivityService activityService;
	
		
}
