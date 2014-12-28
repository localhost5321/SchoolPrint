package com.schoolo2o.utils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * 文件通用工具类
 * 
 * @author hua
 * 
 */
public class MyFileUtils {

	/**
	 * 生成随机文件名，使用时需要加上文件后缀名（.doc||.pdf||...）
	 * 
	 * @return
	 */
	public static String CreateFileName() {
		String name = new Date().toString();
		int num = (int) (Math.random() * 100000) + 10000;
		String newfileName = name + num;
		return newfileName;
	}

	/**
	 * 返回文件日期路径,使用时需要加上文件完整名字（返回值+test.doc），之后才是存储时使用的完整路径
	 * 
	 * @return
	 */
	public static String CreateFileParentPath() {
		String path;
		Date date = new Date();
		path = "" + date.getYear() + "/" + date.getMonth() + "/"
				+ date.getDay() + "/";
		return path;
	}

	/**
	 * 根据文件名返回文件后缀名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String GetFileNameExtension(String fileName) {
		String[] strs = fileName.split("\\.");
		return "." + strs[strs.length - 1];
	}

	/**
	 * 将输入流存储到指定的文件中去
	 * 
	 * @param in
	 * @param fullPath
	 * @return
	 */
	public static boolean Store(InputStream in, String fullPath) {
		try {
			OutputStream out = new FileOutputStream(fullPath);
			byte[] buffer = new byte[1024];
			while (true) {
				int byteRead = in.read(buffer);
				if (byteRead == -1)
					break;
				out.write(buffer, 0, byteRead);
			}
			out.close();
			in.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
