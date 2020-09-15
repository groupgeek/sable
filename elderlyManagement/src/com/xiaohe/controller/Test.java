package com.xiaohe.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.methods.HttpPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CompleteMultipartUploadResult;
import com.aliyun.oss.model.UploadFileRequest;
import com.aliyun.oss.model.UploadFileResult;

/**
 * 测试接口类
 * @author asus
 *
 */
@Controller
public class Test {

	private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
	private static String accessKeyId = "";
	private static String accessKeySecret = "";
	private static String bucketName = "com-xiaohe-res";
    private static String key = "1.mp4";
    private static String uploadFile = "<uploadFile>";
	
    @RequestMapping("/upload")
	public String upload(MultipartFile file,HttpServletRequest request){
    	//System.out.println(System.getProperty("xiaohe.com"));
		//System.out.println(file.getPath());
		//System.out.println(file.getAbsolutePath());
    	System.out.println(request.getSession().getServletContext().getRealPath("/"));
    	OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		try {
			file.transferTo(new File(System.getProperty("xiaohe.com")+File.separator+file.getOriginalFilename()));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	
		 try {
	            UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName, key);
	            // 待上传的本地文件
	            uploadFileRequest.setUploadFile(System.getProperty("xiaohe.com")+File.separator+file.getOriginalFilename());
	            // 设置并发下载数，默认1
	            uploadFileRequest.setTaskNum(5);
	            // 设置分片大小，默认100KB
	            uploadFileRequest.setPartSize(1024 * 1024 * 1);
	            // 开启断点续传，默认关闭
	            uploadFileRequest.setEnableCheckpoint(true);
	            
	            UploadFileResult uploadResult = ossClient.uploadFile(uploadFileRequest);
	            
	            CompleteMultipartUploadResult multipartUploadResult = 
	                    uploadResult.getMultipartUploadResult();
	            System.out.println(multipartUploadResult.getETag());
	            
	        } catch (OSSException oe) {
	            System.out.println("Caught an OSSException, which means your request made it to OSS, "
	                    + "but was rejected with an error response for some reason.");
	            System.out.println("Error Message: " + oe.getErrorCode());
	            System.out.println("Error Code:       " + oe.getErrorCode());
	            System.out.println("Request ID:      " + oe.getRequestId());
	            System.out.println("Host ID:           " + oe.getHostId());
	        } catch (ClientException ce) {
	            System.out.println("Caught an ClientException, which means the client encountered "
	                    + "a serious internal problem while trying to communicate with OSS, "
	                    + "such as not being able to access the network.");
	            System.out.println("Error Message: " + ce.getMessage());
	        } catch (Throwable e) {
	            e.printStackTrace();
	        } finally {
	            ossClient.shutdown();
	        }
		return "test/upload";
	}
}
