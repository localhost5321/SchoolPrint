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
	private File saveFile;
	private Set<Orderitem> itemSet = new HashSet<Orderitem>();
	private List<Docinfo> docList = null;
	HttpServletRequest serletRequest = ServletActionContext.getRequest();
	
	
	public File getSaveFile() {
		return saveFile;
	}
	public void setSaveFile(File saveFile) {
		this.saveFile = saveFile;
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
			File files = this.getSaveFile();
			InputStream is = new FileInputStream(files);
			String uploadPath = new FileName().filePath() + "doc";  //文件路径
			String newFileName = new FileName().FileRename();   /*文件重命名*/
			File toFile = new File(uploadPath, newFileName);
			OutputStream os = new FileOutputStream(toFile);
			byte[] buffer = new byte[1024];
			int length = 0;
			while((length = is.read(buffer)) > 0){
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
			addDocument(newFileName, uploadPath);
	}
	/**
	 * 添加到文件表中
	 */
	public void addDocument(String fileName, String filePath){
		Docinfo doc = new Docinfo();
		doc.setFileName(fileName);
		doc.setFilePath(filePath);
		doc.setIsShare(1);
		doc.setBrowseNum(0L);
		doc.setDownNum(0L);
		this.getDocList().add(doc);
	}
	/**
	 * 文件打印条目添加到Set容器中
	 * @param order
	 */
	public void createOrderItem(Orderinfo order){
		
	}
}
