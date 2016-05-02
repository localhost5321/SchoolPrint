package com.schoolo2o.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class TestFileAction {
	private File[] upFile;
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File[] getUpFile() {
		return upFile;
	}

	public void setUpFile(File[] upFile) {
		this.upFile = upFile;
	}

	public String execute() {
		System.out.println("*********************");
		ActionContext.getContext().get("request");
		HttpServletRequest servletRequest = ServletActionContext.getRequest();
		try {
			InputStream in = servletRequest.getInputStream();
			OutputStream out = new FileOutputStream("/home/hengyi/temp/"
					+ fileName);
			byte[] buffer = new byte[1024];
			while (true) {
				int byteRead = in.read(buffer);
				if (byteRead == -1)
					break;
				out.write(buffer, 0, byteRead);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// int i = 0;
		// for (File file : upFile) {
		// i++;
		// System.out.println(file.getTotalSpace());
		//
		// try {
		// FileInputStream fin = new FileInputStream(file);
		// OutputStream out = new FileOutputStream(
		// "/home/hengyi/temp/upLoad_" + i + ".pdf");
		// byte[] buffer = new byte[1024];
		// while (true) {
		// int byteRead = fin.read(buffer);
		// if (byteRead == -1)
		// break;
		// out.write(buffer, 0, byteRead);
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// }
		return "success";
	}
}
