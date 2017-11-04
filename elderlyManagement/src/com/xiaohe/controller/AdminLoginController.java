package com.xiaohe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.Ceo;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.service.CeoService;
import com.xiaohe.service.ProductManageService;
@Controller
@RequestMapping("/adminlogin")
public class AdminLoginController {

	@Autowired
	@Qualifier("productManageService")
	private ProductManageService productManageService;
	
	@Autowired
	@Qualifier("ceoService")
	private CeoService ceoService;
	
	@RequestMapping(value="AdminLogin")
	public String  productManageAdminsLogin(HttpServletRequest request, Model model,int mark,int id, String password) throws Exception {
		if(mark==1){
			EmployeeCustom admins=new EmployeeCustom();
			admins.setEmployeeid(id);
			admins.setPassword(password);
			admins = productManageService.productManageAdminsLogin(admins);
		request.getSession().setAttribute("admins", admins);
		 if (admins.getAuthorityid()==2) {
			System.out.println(admins.getAuthority()+"------------------------");
			//编辑员跳转页面'
			
			return "null";
		}else if (admins.getAuthorityid()==3) {System.out.println(admins.getAuthorityid()+"dsds-----------------------");
			//送货员跳转
			return null;
		}else if (admins.getAuthorityid()==4) {System.out.println(admins.getAuthorityid()+"----adada--------------------");
			//商品管理跳转
			return"redirect:/productmanage/quertyProduct.action";
		}else if (admins.getAuthorityid()==5) {System.out.println(admins.getAuthorityid()+"-----adas-------------------");
			//分店管理跳转
			return"redirect:/brach/index.action";
		}else if (admins.getAuthorityid()==7) {
		//超级管理员跳转
		return "admin/index";
	}
		}
		if (mark==0) {
			Ceo  ceos=new Ceo();
			ceos.setCeoid(id);
			ceos.setPassword(password);
			 ceos = ceoService.quertyCEO(ceos);
			request.getSession().setAttribute("ceos", ceos);
			System.out.println(ceos.getAuthorityid()+"----adad--------------------");
			//ECO跳转
			return"redirect:/ceo/index.action";
			}
		return null;
	}	
}
