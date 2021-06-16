package com.yc.biz;

import java.util.List;

import com.yc.bean.Reply;
import com.yc.bean.ReplyVO;
import com.yc.dao.ReplyDAO;

public class ReplyBiz {
	ReplyDAO dao = new ReplyDAO();
	
	public String dianzan(Reply t) {
		return dao.dianzan(t);
	}
	/**
	 * 根据编号查看回帖信息
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public ReplyVO findByID (ReplyVO t) throws Exception {
		List<ReplyVO> list = dao.find(t);
		if(null==list||list.isEmpty()){
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * 删除回帖信息   只删除本人的
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int deleteByID(Reply t) throws Exception{
		return dao.delete(t);
	}
	/**
	 * 添加回帖信息
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int addReply(Reply t) throws Exception{
		return dao.add(t);
	}
	/**
	 * 修改回帖信息
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int updateReply(Reply t)throws Exception{
		System.out.println(t);
		return dao.update(t);
	}
}
