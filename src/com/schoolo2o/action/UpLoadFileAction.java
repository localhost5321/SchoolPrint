package com.schoolo2o.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.schoolo2o.pojo.Docinfo;
import com.schoolo2o.pojo.Orderinfo;
import com.schoolo2o.pojo.Orderitem;
import com.schoolo2o.pojo.Userinfo;
import com.schoolo2o.utils.FileName;


/**
 * 文件上传的操作
 * @author hua
 *
 */
public class UpLoadFileAction extends ActionSupport{
	private File[] uploadFile;
	private String[] uploadFileType;
	private String[] uploadFileName;
	private String[] uploadPath;
	private String[] newFileName;
	private Set<Orderitem> itemSet = new HashSet<Orderitem>();
	private List<Docinfo> docList = null;
	
	public File[] getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File[] uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String[] getUploadFileType() {
		return uploadFileType;
	}
	public void setUploadFileType(String[] uploadFileType) {
		this.uploadFileType = uploadFileType;
	}
	public String[] getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public Set<Orderitem> getItemSet() {
		return itemSet;
	}
	public void setItemSet(Set<Orderitem> itemSet) {
		this.itemSet = itemSet;
	}
	
	public List<Docinfo> getDocList() {
		return docList;
	}
	public void setDocList(List<Docinfo> docList) {
		this.docList = docList;
	}
	/**
	 * 上传文件保存到服务器硬盘中
	 * @throws IOException
	 */
	public void upLoadFileSave() throws IOException{
		File[] files = this.getUploadFile();
		for(int  i = 0; i < files.length; i++){
			InputStream is = new FileInputStream(files[i]);
			this.uploadPath[i] = new FileName().filePath() + this.getUploadFileType()[i];
			this.newFileName[i] = new FileName().FileRename();   /*文件重命名*/
			File toFile = new File(this.uploadPath[i], this.newFileName[i]);
			OutputStream os = new FileOutputStream(toFile);
			byte[] buffer = new byte[1024];
			int length = 0;
			while((length = is.read(buffer)) > 0){
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
		}
	}
	/**
	 * 添加到文件表中
	 */
	public void addDocument(){
		Docinfo doc = new Docinfo();
		HttpServletRequest serletRequest = ServletActionContext.getRequest();
		Userinfo user =  (Userinfo) serletRequest.getAttribute("user");
		for(int i=0; i<uploadFile.length; i++){
			Docinfo Doc = new Docinfo();
			
		}
	}
	/**
	 * 文件打印条目添加到Set容器中
	 * @param order
	 */
	public void createOrderItem(Orderinfo order){
		
	}
}
