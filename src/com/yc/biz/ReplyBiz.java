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
	 * ���ݱ�Ų鿴������Ϣ
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
	 * ɾ��������Ϣ   ֻɾ�����˵�
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int deleteByID(Reply t) throws Exception{
		return dao.delete(t);
	}
	/**
	 * ��ӻ�����Ϣ
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int addReply(Reply t) throws Exception{
		return dao.add(t);
	}
	/**
	 * �޸Ļ�����Ϣ
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int updateReply(Reply t)throws Exception{
		System.out.println(t);
		return dao.update(t);
	}
}
