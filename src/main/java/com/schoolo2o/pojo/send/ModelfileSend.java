package com.schoolo2o.pojo.send;

import java.util.HashSet;
import java.util.Set;

import com.schoolo2o.pojo.Modelfile;

/**
 * Modelfile entity. @author MyEclipse Persistence Tools
 */

public class ModelfileSend implements java.io.Serializable {

	// Fields

	private Long modelFileId;
	private String fileName;
	private String filePath;

	// Constructors

	/** default constructor */
	public ModelfileSend(Modelfile mf) {
		this.fileName = mf.getFileName();
		this.filePath = mf.getFilePath();
		this.modelFileId=mf.getModelFileId();
	}
}