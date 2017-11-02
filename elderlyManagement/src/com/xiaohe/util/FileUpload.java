package com.xiaohe.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUpload {
	
	public static String oneFileUpload(MultipartFile newFile,String oldFile,String type) throws IllegalStateException, IOException{
		
				if(newFile.isEmpty()){
					return null;
				}
				String path = "D:\\code\\web\\upload\\";
				//开始上传文件的处理
				//原始文件名称
				String file_name =  newFile.getOriginalFilename();
				//新文件名称
				String newFileName = UUID.randomUUID().toString()+file_name.substring(file_name.lastIndexOf("."));
				if("picture".equals(type)){
					newFileName = "picture\\" + newFileName;
				}
				if("video".equals(type)){
					newFileName = "video\\" + newFileName;
				}
				//上传图片
				File uploadPic = new File(path+newFileName);
				//向磁盘写文件
				newFile.transferTo(uploadPic);
				
				//开始删除原来文件的处理
				if(oldFile == null){
					return newFileName;
				}
				File rmFile = new File(path+oldFile);
				if(rmFile.isDirectory()){
					return newFileName;
				}
				if(rmFile.isFile()){
					if(rmFile.delete()){
						return newFileName;
					}else{
						File rmNewFile = new File(path+newFileName);
						rmNewFile.delete();
						return null;
					}
				}
				
				return newFileName;
	}
	
	
	public static String FileUplaod(MultipartHttpServletRequest request) throws IllegalStateException, IOException{
		String newFileNames = null;
		if(request!=null){
			
			//多个文件的处理
			
			Iterator<String> fileNames=request.getFileNames();
			
			while(fileNames.hasNext()){
				String fileName=fileNames.next();
				
				//System.out.println(fileName);
				//获取文件集合
				List<MultipartFile> fileList=request.getFiles(fileName);
				if (fileList.size()>0) {  
	                  
	                //遍历文件列表  
	                Iterator<MultipartFile> fileIte=fileList.iterator();  
	                  
	                while (fileIte.hasNext()) {  
	                      
	                    //获得每一个文件  
	                    MultipartFile multipartFile=fileIte.next();
	                      
	                    //获得原文件名  
	                    String originalFilename = multipartFile.getOriginalFilename();  
	                    System.out.println("originalFilename: "+originalFilename);  
	                      
	                    //设置保存路径.   
	                    String path ="D:\\code\\web\\upload\\temp\\";  
	                      
	                    //检查该路径对应的目录是否存在. 如果不存在则创建目录  
	                    File dir=new File(path);  
	                    if (!dir.exists()) {  
	                        dir.mkdirs();  
	                    }  
	                      
	                    String newFileName = UUID.randomUUID()+ originalFilename.substring(originalFilename.lastIndexOf("."));  
	                    
	                    System.out.println("filePath: "+path+newFileName);  
	                      
	                    //保存文件  
	                    File dest = new File(path+newFileName);  
	                    if (!(dest.exists())) {  
	                    	//写入磁盘
	                        multipartFile.transferTo(dest); 
	                        
	                        /**
	                         * 这里把文件名字"newFileName"存入数据库
	                         */
	                        newFileNames = "--"+newFileName;
	                    }  
	                      
	                      
	                    //获取文件contentType  
	                    String contentType=multipartFile.getContentType();  
	                    System.out.println("contentType: "+contentType);  
	                      
	                    /* 
	                     * 获取name 
	                     */  
	                    String name=multipartFile.getName();  
	                    System.out.println("name: "+name);  
	                      
	                    //获取文件大小, 单位为字节  
	                    long size=multipartFile.getSize();  
	                    System.out.println("size: "+size);  
	                      
	                    System.out.println("---------------------------------------------------");  
	                }  
	            } 
			}
		}
		return newFileNames;
	}
	
}
