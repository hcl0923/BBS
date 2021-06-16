package com.yc.bean;

import java.io.Serializable;

public class Board implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 3335913652604856695L;
	private Integer boardid;
	private String boardname;
	private Integer parentid;
	private Integer total; //主题总个数
	private Integer topicid; //最新主题编号
	private String title; //最新的主题标题
	private String uname;//最新的主题的用户名称
	private String recentmodifytime; //修改时间
	public Integer getBoardid() {
		return boardid==null?0:boardid;
	}
	public void setBoardid(Integer boardid) {
		this.boardid = boardid;
	}
	public String getBoardname() {
		return boardname==null?"":boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public Integer getParentid() {
		return parentid==null?0:parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public Integer getTotal() {
		return total==null?0:total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTopicid() {
		return topicid==null?0:topicid;
	}
	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}
	public String getTitle() {
		return title==null?"":title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUname() {
		return uname==null?"":uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRecentmodifytime() {
		return recentmodifytime==null?"":recentmodifytime;
	}
	public void setRecentmodifytime(String recentmodifytime) {
		this.recentmodifytime = recentmodifytime;
	}
	@Override
	public String toString() {
		return "Board [boardid=" + boardid + ", boardname=" + boardname + ", parentid=" + parentid + ", total=" + total
				+ ", topicid=" + topicid + ", title=" + title + ", uname=" + uname + ", recentmodifytime="
				+ recentmodifytime + "]";
	}
}
