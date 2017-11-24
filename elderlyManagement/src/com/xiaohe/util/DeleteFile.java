package com.xiaohe.util;

import java.io.File;

public class DeleteFile {
	public static boolean deleteFile(String path){
		String root = "D:\\code\\web\\upload\\";
		if(path == null){
			return true;
		}
		File rmFile = new File(root+path);
		if(rmFile.isDirectory()){
			return true;
		}
		if(rmFile.isFile()){
			if(rmFile.delete())
				return true;
		}
		return false;
	}
}
