package com.yc.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yc.bean.ReplyVO;
import com.yc.bean.Topic;
import com.yc.bean.TopicVO;
import com.yc.dao.ReplyDAO;
import com.yc.dao.TopicDAO;

public class TopicBiz {
	TopicDAO dao = new TopicDAO() ;
	ReplyDAO replyDAO = new ReplyDAO();
	/**
	 * 发布主贴信息
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int add(Topic t)throws Exception{
		return dao.add(t);
	}
	public Map<String, Object> findByPageVO(TopicVO t,Integer pageNum,Integer pageSize) 
			throws Exception {
		Map<String, Object> map =new HashMap<String,Object>();
		List<TopicVO> list=dao.findByPageVO(t,pageNum,pageSize);
		int total =dao.findByPageTotal(t);
		map.put("topics",list);
		if(null==pageNum) {
			return map;
		}
		System.out.println(total);
		//最大页码数
		int maxPage=0;
		if(total%pageSize==0) {
			maxPage =total/pageSize;
		}else{
			maxPage =total/pageSize+1;
		}
		map.put("maxPage",maxPage);
		return map;
	}
	/**
	 * 根据主题编号查看主题信息
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findByTopicid(TopicVO t) throws Exception{
		List<TopicVO> list01 =dao.findByPage(t) ;
		ReplyVO v =new ReplyVO() ;
		if (null!=list01&&!list01.isEmpty()) {
			v. setTopicid(t.getTopicid()); //主题编 号查询回帖信息
		}
		List<ReplyVO> list02 =replyDAO.find(v);//主题编号查询回帖信息
		Set<String> set=replyDAO.getAllKeys();//狄取所有回帖点赞的链
		//获取redis中zan数量
		if (null!=list02&&!list02.isEmpty()){
			for(ReplyVO vo:list02){
				vo.setZan(0);
				for(String s:set){
					if(("reply:rid:"+vo.getReplyid()).equals(s)){ 
						vo.setZan(replyDAO.getZan(vo.getReplyid()));
					}
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object> () ;
		if(null!=list01&&!list01.isEmpty()) {
			map.put ("topic", list01.get(0));
		}
		map.put ("replys", list02) ;
		return map;
	}
}