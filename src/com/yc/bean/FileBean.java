package com.yc.bean;

import java.io.Serializable;
/**
 * 副编辑器中的文件数据
 * @author hp
 *
 */
public class FileBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4869141284372339068L;
	private String fileName; //文件名
	private String upload; //文件上传的路径    表单传过来的字段名
	private String url;
	private Integer uploaded;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getUploaded() {
		return uploaded;
	}
	public void setUploaded(Integer uploaded) {
		this.uploaded = uploaded;
	}
	@Override
	public String toString() {
		return "FileBean [fileName=" + fileName + ", upload=" + upload + ", url=" + url + ", uploaded=" + uploaded
				+ "]";
	}
	
	
}