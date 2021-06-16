package com.yc.bean;

import java.io.Serializable;
/**
 * ���༭���е��ļ�����
 * @author hp
 *
 */
public class FileBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4869141284372339068L;
	private String fileName; //�ļ���
	private String upload; //�ļ��ϴ���·��    �����������ֶ���
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