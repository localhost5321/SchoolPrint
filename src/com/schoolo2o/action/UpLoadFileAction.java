package com.schoolo2o.action;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.MyJSONObject;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.service.DocService;
import com.schoolo2o.service.UserService;
import com.schoolo2o.utils.DOMUtils;
import com.schoolo2o.utils.MyFileUtils;

/**
 * 文件上传的操作
 * 
 * @author hua
 * 
 */

public class UpLoadFileAction extends ActionSupport {

	private DocService docService;
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public DocService getDocService() {
		return docService;
	}

	public void setDocService(DocService docService) {
		this.docService = docService;
	}

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

		System.out.println("*************************");
		InputStream in = serletRequest.getInputStream();
		serletRequest.setCharacterEncoding("UTF-8");
		String fileName = serletRequest.getParameter("fileName");
//		fileName = new String(fileName.getBytes("iso8859-1"),"utf-8");
		String userName = serletRequest.getParameter("userName");
		System.out.println(fileName);
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");

		// 存储文件
		String finalFilePath = MyFileUtils.Store(in, fileName);

		// *******************以下代码需要重构下＊＊＊＊＊＊＊＊＊＊＊＊＊＊ //
		long docId = addDocument(fileName, finalFilePath, userName);
		int fileCount=DOMUtils.getPageCountWord(finalFilePath);
		DocMessage dm=new DocMessage(docId, fileCount);
		MyJSONObject jsonObject=new MyJSONObject();
		jsonObject.setStatus("1");
		jsonObject.setMessage("null");
		jsonObject.setData(dm);
		String jsonStr=JSON.toJSONString(jsonObject);
		response.getWriter().write(jsonStr);
		System.out.println(jsonStr);
		return null;
	}

	/**
	 * 添加到文件表中
	 */
	public long addDocument(String fileName, String filePath, String userName) {
		System.out.println("...." + userService);
		Docinfo doc = new Docinfo();
		doc.setFileName(fileName);
		doc.setFilePath(filePath);
		doc.setIsShare(1);
		doc.setBrowseNum(0L);
		doc.setDownNum(0L);
		Userinfo user = userService.searchUser(userName);
		doc.setUserinfo(user);
		doc = docService.add(doc, user);
		return doc.getDocId();
	}

}
/**
 * 文件信息传递对象
 * @author hua
 *
 */
class DocMessage{
	private long docId;
	private int fileCount;
	public DocMessage(long docId,int fileCount){
		this.docId=docId;
		this.fileCount=fileCount;
	}
	public DocMessage(){
		
	}
	@Override
	public String toString() {
		return "DocMessage [docId=" + docId + ", fileCount=" + fileCount + "]";
	}
	public long getDocId() {
		return docId;
	}
	public void setDocId(long docId) {
		this.docId = docId;
	}
	public int getFileCount() {
		return fileCount;
	}
	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}
	
	
}
