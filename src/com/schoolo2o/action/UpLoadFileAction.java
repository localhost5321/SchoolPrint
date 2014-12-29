package com.schoolo2o.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.utils.MyFileUtils;

/**
 * 文件上传的操作
 * 
 * @author hua
 * 
 */

public class UpLoadFileAction extends ActionSupport {

	HttpServletRequest serletRequest = ServletActionContext.getRequest();

	/**
	 * 上传文件保存到服务器硬盘中
	 * 
	 * @throws IOException
	 */
	public void upLoadFileSave() throws IOException {
		InputStream in = serletRequest.getInputStream();
		String fileName = serletRequest.getParameter("fileName");

		String uploadPath = MyFileUtils.CreateFileParentPath()
				+ MyFileUtils.GetFileNameExtensionWithoutPoint(fileName) + "/"; // 文件所在文件夹
		String newFileName = MyFileUtils.CreateFileName()
				+ MyFileUtils.GetFileNameExtension(fileName); /* 文件重命名 */
		String fullPath = uploadPath + newFileName;
		MyFileUtils.Store(in, fullPath);
		addDocument(fileName, fullPath);
	}

	/**
	 * 添加到文件表中
	 */
	public void addDocument(String fileName, String filePath) {
		Docinfo doc = new Docinfo();
		doc.setFileName(fileName);
		doc.setFilePath(filePath);
		doc.setIsShare(1);
		doc.setBrowseNum(0L);
		doc.setDownNum(0L);
	}

}
