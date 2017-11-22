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
	public String  productManageAdminsLogin(HttpServletRequest request, Model model,int mark,String id, String password) throws Exception {
		if(mark==1){
			EmployeeCustom admin2=new EmployeeCustom();
			admin2.setAccountnumber(id);
			admin2.setPassword(password);
			EmployeeCustom	admins  = productManageService.productManageAdminsLogin(admin2);
			if(admins==null){
				return "AdminLogin/login";
			}else {
		request.getSession().setAttribute("admins", admins);
		 if (admins.getAuthorityid()==2) {
			System.out.println(admins.getAuthority()+"------------------------");
			//编辑员跳转页面'
			
			return  "redirect:/Commonsense/selectCommonsense";
		}else if (admins.getAuthorityid()==3) {
			//送货员跳转
		return "redirect:/selectorder/selectorderbybranchid.action";
		}else if (admins.getAuthorityid()==4) {
			//商品管理跳转
			return"redirect:/productmanage/quertyProduct.action";
		}else if (admins.getAuthorityid()==5) {
			//分店管理跳转
			return"redirect:/brach/index.action";
		}else if (admins.getAuthorityid()==7) {
		//超级管理员跳转
		return "redirect:/jsp/admin/index.jsp";
	}}
		}
		if (mark==0) {
			Ceo  ceos=new Ceo();
			int id1=Integer.parseInt(id);
			ceos.setCeoid(id1);
			ceos.setPassword(password);
			 ceos = ceoService.quertyCEO(ceos);
			request.getSession().setAttribute("ceos", ceos);
			System.out.println(ceos.getAuthorityid()+"----adad--------------------");
			//ECO跳转
			return"redirect:/ceo/index.action";
			}
		return "AdminLogin/login";
	}	
}
