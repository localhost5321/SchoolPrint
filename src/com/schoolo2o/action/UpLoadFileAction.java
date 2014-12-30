package com.schoolo2o.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.service.DocService;
import com.schoolo2o.service.UserService;
import com.schoolo2o.utils.MyFileUtils;

/**
 * 文件上传的操作
 * 
 * @author hua
 * 
 */

public class UpLoadFileAction extends ActionSupport {

	/** 这个final字段是在服务器硬盘上存储的根路径，按需改变 **/
	private static final String FILE_ROOT_PATH = "/home/user/temp/";
	private DocService dcoService;
	private UserService userService;
	private final HttpServletRequest serletRequest = ServletActionContext
			.getRequest();
	private final HttpServletResponse response = ServletActionContext
			.getResponse();

	/**
	 * 上传文件保存到服务器硬盘中
	 * 
	 * @throws IOException
	 */
	public String upLoadFileSave() throws IOException {
		InputStream in = serletRequest.getInputStream();
		String fileName = serletRequest.getParameter("fileName");
		String userName = serletRequest.getParameter("userName");
		response.setContentType("text/plain");

		response.setCharacterEncoding("utf-8");

		// 文件所在文件夹，形如“2014/12/30/doc/”
		String uploadPath = MyFileUtils.CreateFileParentPath(MyFileUtils
				.GetFileNameExtensionWithoutPoint(fileName));
		// 得到新的文件名,形如"jsafhkjsdghks.doc"
		String newFileName = MyFileUtils.CreateNewFileName(MyFileUtils
				.GetFileNameExtension(fileName));

		String fullParentPath = FILE_ROOT_PATH + uploadPath;
		// 文件夹不存在则创建
		MyFileUtils.createFilePath(fullParentPath);
		// 文件完整的存储路径　形如"/home/user/2014/12/30/filename.doc"
		String fullPath = FILE_ROOT_PATH + uploadPath + newFileName;

		MyFileUtils.Store(in, fullPath);

		// *******************以下代码需要重构下＊＊＊＊＊＊＊＊＊＊＊＊＊＊ //
		long docId = addDocument(fileName, fullPath, userName);
		response.getWriter().write(
				"status\":\"1\",\"message\":\"'" + docId + "'\"}");
		return null;
	}

	/**
	 * 添加到文件表中
	 */
	public long addDocument(String fileName, String filePath, String userName) {

		Docinfo doc = new Docinfo();
		doc.setFileName(fileName);
		doc.setFilePath(filePath);
		doc.setIsShare(1);
		doc.setBrowseNum(0L);
		doc.setDownNum(0L);
		Userinfo user = userService.searchUser(userName);
		doc.setUserinfo(user);
		doc = dcoService.add(doc, user);
		return doc.getDocId();
	}

}
