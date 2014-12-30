package com.schoolo2o.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.schoolo2o.action.UpLoadFileAction;

/**
 * 文件通用工具类
 * 
 * @author hua
 * 
 */
public class MyFileUtils {

	/**
	 * 生成随机文件名，需要参数指定文件后缀名（.doc||.pdf||...） 返回："jbfdjbkdfjbksngknbdfknb.doc"
	 * 
	 * @return
	 */
	public static String CreateNewFileName(String fileSuffix) {
		String name = new Date().toString();
		int num = (int) (Math.random() * 100000) + 10000;
		String newfileName = name + num;
		return newfileName.trim() + fileSuffix;
	}

	/**
	 * 返回文件日期路径,使用时需要加上文件完整名字（返回值+test.doc），之后才是存储时使用的完整路径 返回值:形如"2014/12/30/"
	 * 
	 * @return
	 */
	public static String CreateFileParentPath(String fileType) {
		String path;
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		path = simpleDateFormat.format(date);
		return path + "/" + fileType + "/";
	}

	/**
	 * 根据文件名返回文件后缀名,接受"filename.doc"返回".doc"
	 * 
	 * @param fileName
	 * @return
	 */
	public static String GetFileNameExtension(String fileName) {
		String[] strs = fileName.split("\\.");
		return "." + strs[strs.length - 1];
	}

	/**
	 * 文件类型,接受“filename.doc”返回"doc"
	 * 
	 * @param fileName
	 * @return
	 */
	public static String GetFileNameExtensionWithoutPoint(String fileName) {
		String[] strs = fileName.split("\\.");
		return strs[strs.length - 1];
	}

	/**
	 * 将输入流存储到指定的文件中去,接受的fullPath形如:"/home/user/2014/12/30/doc/filename.pdf"
	 * 
	 * @param in
	 * @param fullPath
	 * @return
	 */
	public static String Store(InputStream in, String fileName) {

		// 文件所在文件夹，形如“2014/12/30/doc/”
		String uploadPath = MyFileUtils.CreateFileParentPath(MyFileUtils
				.GetFileNameExtensionWithoutPoint(fileName));
		// 得到完整的文件夹。形如“/home/user/temp/2014/12/30/doc/”
		String fullParentPath = UpLoadFileAction.FILE_ROOT_PATH + uploadPath;

		// 得到新的文件名,形如"jsafhkjsdghks.doc"
		String newFileName = MyFileUtils.CreateNewFileName(MyFileUtils
				.GetFileNameExtension(fileName));

		// 最终的存储路径
		String finalFilePath = fullParentPath + newFileName;

		// 文件夹不存在则创建
		MyFileUtils.createFilePath(fullParentPath);

		try {
			OutputStream out = new FileOutputStream(finalFilePath);
			byte[] buffer = new byte[1024];
			while (true) {
				int byteRead = in.read(buffer);
				if (byteRead == -1)
					break;
				out.write(buffer, 0, byteRead);
			}
			out.close();
			in.close();
			return finalFilePath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 创建目录，如果目录已经存在，则不做任何操作 接受的参数：形如“/home/user/temp/2014/12/30/doc/”
	 */
	public static void createFilePath(String filePath) {
		File file = new File(filePath);
		if (file.exists() && file.isDirectory()) {
			return;
		} else
			file.mkdirs();
	}

}
