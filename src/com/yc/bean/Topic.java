package com.yc.bean;

import java.io.Serializable;

public class Topic implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5595889281029350260L;
	private Integer topicid;
	private String title;
	private String content;
	private String publishtime;
	private String modifytime ;
	private Integer uid;
	private Integer boardid;
	public Integer getTopicid() {
		return topicid;
	}
	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
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
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getBoardid() {
		return boardid;
	}
	public void setBoardid(Integer boardid) {
		this.boardid = boardid;
	}
	private String uname;
	private String head;
	private String regtime;
	private Integer replycount;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public Integer getReplycount() {
		return replycount;
	}
	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
	}
	@Override
	public String toString() {
		return "Topic [topicid=" + topicid + ", title=" + title + ", content=" + content + ", publishtime="
				+ publishtime + ", modifytime=" + modifytime + ", uid=" + uid + ", boardid=" + boardid + ", uname="
				+ uname + ", head=" + head + ", regtime=" + regtime + ", replycount=" + replycount + "]";
	}
}
