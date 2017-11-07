package com.xiaohe.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.Commonsense;
import com.xiaohe.bean.CommonsenseCustom;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.service.CommonsenseService;
import com.xiaohe.test.GridVO;
import com.xiaohe.util.FileUpload;

@Controller
@RequestMapping("/Commonsense")
public class CommonsenseController {
	@Autowired
	@Qualifier("commonsenseService")
	private CommonsenseService commonsenseService;
	String file1=null;
	 @RequestMapping(value = "/griddemo")
	    @ResponseBody
	    public GridVO getData(HttpServletRequest request){
		     //创建一个响应对象
	        GridVO<CommonsenseCustom> gridVO=new GridVO();
	         //创建一个响应对象
	        gridVO.setStatus("success");
	    	EmployeeCustom custom=new EmployeeCustom();
	    	
        	custom = (EmployeeCustom) request.getSession().getAttribute("admins");
        
	        List<CommonsenseCustom> list=new ArrayList<CommonsenseCustom>();
	        
	        CommonsenseCustom commonsenseCustom = new CommonsenseCustom();
	        //查询当前编辑员的所有编辑记录
	        commonsenseCustom.setEditorid(custom.getEmployeeid());
	        
	        
	       
	        list=commonsenseService.queryCommonsenseByCondition(commonsenseCustom);
	      //设置记录条数
	        gridVO.setTotal(list.size());

	        gridVO.setData(list);
	        	
	        return  gridVO;
	    }
	
	//查询当前编辑员所有编辑记录
	   @RequestMapping("/selectCommonsense")
	   
	   public String selectCommonsense(Model model,HttpServletRequest request) {
		   
		   return "/comm/js/indeCommonsense";
	   }
	//删除数据
	   @RequestMapping("/deleteCommonsense/{commonsenseid}")
	   
	   public String deleteCommonsense(@PathVariable Integer commonsenseid){
	   
		   commonsenseService.deleteCommonsense(commonsenseid);
	   
		   return "/comm/js/selectCommonsense";
   }
   //插入数据
	   @RequestMapping(value="/insert",method=RequestMethod.GET)
	   public String insertGet(Model model){ 
		   
		   return "comm/js/insertComm";
   }
	   @RequestMapping(value="/insert",method=RequestMethod.POST)
	   public String insertPost(Model model,Commonsense commonsense ,HttpServletRequest request ){
		
			EmployeeCustom custom=new EmployeeCustom();
        	custom = (EmployeeCustom) request.getSession().getAttribute("admins");
      
        	Date date = new Date(); 
        	commonsense.setPicture(file1);
        	commonsense.setCreatetime(date);
        	commonsense.setEditorid(custom.getEmployeeid());
        	System.out.print(commonsense.getTitle());
        	commonsenseService.insertCommonsense(commonsense);
  
        	return "comm/js/insertComm";
   }
	   @RequestMapping(value="/update/{commonsenseid}",method=RequestMethod.GET)
	   public String updateGet(Model model,@PathVariable Integer commonsenseid){ 
		   model.addAttribute("commonsense",commonsenseService.selectByPrimaryKey(commonsenseid) );
		   return "/comm/js/updateComm";
   }
	  @RequestMapping(value="/update",method=RequestMethod.POST)
	   public String updatePost(Model model,Commonsense commonsense ,HttpServletRequest request ){
		  EmployeeCustom custom=new EmployeeCustom();
      	custom = (EmployeeCustom) request.getSession().getAttribute("admins");
    	Date date = new Date(); 
    	commonsense.setPicture(file1);
    	commonsense.setCreatetime(date);
    	commonsense.setEditorid(custom.getEmployeeid());
    	System.out.println(commonsense.getContext());
    commonsenseService.updateCommonsense(commonsense);
        return "/comm/js/updateComm";
	   }
	  
	  
	  
	   @RequestMapping("/selOneComm/{commonsenseid}")
	   public String  selOneComm(Model model ,@PathVariable Integer commonsenseid){
		
	        model.addAttribute("commonsense",commonsenseService.selectByPrimaryKey(commonsenseid) );
	        
		   return "/comm/js/selOneComm";
	   }
	  
	   
	   //修改內容
       //上传文件
	   @RequestMapping("/file")
	   @ResponseBody
	   public String uploads( MultipartFile myFileName) {
		   System.out.println("进入");
			try {
				file1=FileUpload.oneFileUpload(myFileName,null, "picture");
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(file1);
             return file1;
	   }
    
}
