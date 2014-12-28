package com.schoolo2o.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Modelfile entity. @author MyEclipse Persistence Tools
 */

public class Modelfile implements java.io.Serializable {

	// Fields

	private Long modelFileId;
	private String fileName;
	private String filePath;
	private Set orderitems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Modelfile() {
	}

	/** minimal constructor */
	public Modelfile(String fileName, String filePath) {
		this.fileName = fileName;
		this.filePath = filePath;
	}

	/** full constructor */
	public Modelfile(String fileName, String filePath, Set orderitems) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Long getModelFileId() {
		return this.modelFileId;
	}

	public void setModelFileId(Long modelFileId) {
		this.modelFileId = modelFileId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

}