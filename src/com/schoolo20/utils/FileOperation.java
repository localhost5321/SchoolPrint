package com.schoolo20.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;

/**
 * 完成对文件的一些列操作 包括文件拷贝,获取
 * @author hua
 *
 */
public class FileOperation {
	
	/**
	 * 判断当前文件是否为文件格式,若是,返回true,否则返回false
	 * @param file 需要判定的文件
	 * @return
	 */
	public boolean isImage(File file){
		boolean flag = false; 
		try {
			BufferedImage bufferImage = ImageIO.read(file);
			int width = bufferImage.getWidth();
			int height = bufferImage.getHeight();
			if(width == 0 || height==0){
				flag = false;
			}else{
				flag = true;
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 获取文件类型,如 doc,docx,pdf,caj
	 * @param file 需要判定的文件
	 * @return 返回文件类型
	 */
	public String getFileType(File file){
		String fileType = null;
		return null;
	}
	/**
	 * 文件存储,更具年月日加文件类型的格式如/2014/12/26/doc/*.doc
	 * @param file  未完成
	 * @return 若存储成功,则返回true,否则返回false;
	 */
	public String FileStorage(File file){
		Date date = new Date();
		String path = "" + date.getYear() + "/" + date.getMonth() + "/" + date.getDay();
		path = path+ "/" + getFileType(file) + "/" + file.getName();
		
		return null;
	}
}
