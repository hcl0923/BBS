package com.yc.bean;
import java.io.Serializable;
/**
 * 用户表  主题表 版本表
 * @author hp
 *
 */
public class TopicVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -164482597965988471L;
	private Integer topicid;
	private String title;
	private String content;
	private String publishtime ;
	private String modifytime;
	private Integer uid;
	private Integer boardid;
	private String boardname ;
	private Integer parentid;
	private String userid;
	private String uname;
	private String upass;
	private String head;
	private String regtime;
	private Integer gender;
	private Integer total;//回帖总数
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
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
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	@Override
	public String toString() {
		return "TopicVO [topicid=" + topicid + ", title=" + title + ", content=" + content + ", publishtime="
				+ publishtime + ", modifytime=" + modifytime + ", uid=" + uid + ", boardid=" + boardid + ", boardname="
				+ boardname + ", parentid=" + parentid + ", userid=" + userid + ", uname=" + uname + ", upass=" + upass
				+ ", head=" + head + ", regtime=" + regtime + ", gender=" + gender + ", total=" + total + "]";
	}
	
}