package com.schoolo2o.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.service.DocService;
import com.schoolo2o.service.UserService;
import com.schoolo2o.utils.Constant;
import com.schoolo2o.utils.MyFileUtils;

/**
 * 文件上传的操作
 * 
 * @author hua
 * 
 */

public class UpLoadFileAction extends ActionSupport {

	private DocService dcoService;
	private UserService userService;
	private final HttpServletRequest serletRequest = ServletActionContext
			.getRequest();
	private final ServletContext servletContext = ServletActionContext
			.getServletContext();
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

		String webName = serletRequest.getContextPath().toString()
				.replace("/", "").trim();
		Constant.WebFilePath = servletContext.getRealPath("/")
				.replace(webName, "files").toString();
		System.out.println(Constant.WebFilePath);

		// 存储文件
		String finalFilePath = MyFileUtils.Store(in, fileName);

		// *******************以下代码需要重构下＊＊＊＊＊＊＊＊＊＊＊＊＊＊ //
		long docId = addDocument(fileName, finalFilePath, userName);
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
