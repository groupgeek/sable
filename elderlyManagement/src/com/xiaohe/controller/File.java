package com.xiaohe.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.util.FileUpload;

@Controller
public class File {

	@RequestMapping(value="/upload")
	public String upload(MultipartFile file,Model model){
		String filename = null;
		
		try {
			filename = FileUpload.oneFileUpload(file, "picture");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("url", filename);
		return "test/upload";
	}
}
