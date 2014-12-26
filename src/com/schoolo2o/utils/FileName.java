package com.schoolo2o.utils;

import java.io.File;
import java.util.Date;

/**
 * 文件重命名
 * @author hua
 *
 */
public class FileName {

	/**
	 * 对文件重命名的操作,重命名规范为当前日期加上五位随机数字
	 * @param path 文件路径 取相对路径
	 * @param oldFileName 文件名,要重命名的文件名
	 * @return 文件是否重命名成功
	 */
	public boolean FileRename(String path, String oldFileName){
		String name = new Date().toString();
		int num = (int)(Math.random()*100000)+10000;
		String newfileName = name + num;
		File oldFile = new File(path + "/" + oldFileName);
		File newFile = new File(path + "/" +  newfileName);
		if(oldFile.exists() && !newFile.exists()){
			oldFile.renameTo(newFile);
			return true;
		}
		return false;
	}
}
