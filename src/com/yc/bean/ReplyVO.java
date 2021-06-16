package com.yc.bean;

import java.io.Serializable;

public class ReplyVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1163212742657267966L;
	private String uid;
	private String uname;
	private String upass;
	private String head; 
	private String regtime;
	private Integer gender;
	private Integer zan;
	private Integer replyid;
	private String title;
	private String content;
	private String publishtime;
	private String modifytime;
	private Integer topicid;
	
	public Integer getZan() {
		return zan;
	}
	public void setZan(Integer zan) {
		this.zan = zan;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getReplyid() {
		return replyid;
	}
	public void setReplyid(Integer replyid) {
		this.replyid = replyid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
	public Integer getTopicid() {
		return topicid;
	}
	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}
	@Override
	public String toString() {
		return "ReplyVO [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", head=" + head + ", regtime="
				+ regtime + ", gender=" + gender + ", zan=" + zan + ", replyid=" + replyid + ", title=" + title
				+ ", content=" + content + ", publishtime=" + publishtime + ", modifytime=" + modifytime + ", topicid="
				+ topicid + "]";
	}
	
;

}