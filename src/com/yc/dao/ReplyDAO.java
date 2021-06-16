package com.yc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.yc.bean.Reply;
import com.yc.bean.ReplyVO;
import com.yc.commons.DbHelper;
import com.yc.util.RedisClient;

public class ReplyDAO implements BaseDao<Reply>{
	DbHelper db=new DbHelper();
	//键的设计reply:rid:1001
	public String dianzan(Reply t) {
		//获取回帖编号
		int rid=t.getReplyid();
		//获取到已有的赞
		int number=getZan(rid);
		number++;//在原有赞的基础上加一
		String ok=RedisClient.getInstance().getJedis().set("reply:rid:"+rid,number+"");
		if("ok".equalsIgnoreCase(ok)) {
			return number+"";
		}else {
			return "error";
		}
	}
	/**
	 * 获取到指定的赞
	 * @param rid 回帖编号
	 * @return
	 */
	public int getZan(Integer rid) {
		String num=RedisClient.getInstance().getJedis().get("reply:rid:"+rid);
		if(null==num||"".equals(num)) {
			return 0;
		}else {
			return Integer.parseInt(num);
		}
	}
	
	/**
	 * 获取所有键
	 */
	public Set<String> getAllKeys(){
		return RedisClient.getInstance().getJedis().keys("reply:rid:*");
	}
	/**
	 * 添加回帖信息
	 */
	@Override
	public int add(Reply t) throws Exception {
		String sql="insert into tb_reply values(null,?,?,now(),now(),?,?)";
		return db.update(sql,t.getTitle(),t.getContent(),t.getUid(),t.getTopicid());
	}
	
	/**
	 * 查看回帖信息
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public List<ReplyVO> find(ReplyVO t) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select replyid,title,content,DATE_FORMAT(publishtime,'%Y-%m-%d %H:%i') as publishtime,");
		sb.append(" DATE_FORMAT (modifytime,'%Y-%m-%d %H:%i') as modifytime,r.uid,topicid,uname,head,");
		sb.append(" DATE_FORMAT (regtime,'%Y-%m-%d %H:%i') as regtime,gender ");
		sb.append(" from tb_reply r left join tb_user u on r.uid=u.uid where 1 =1 ");
		List<Object> params =null;
		if (null!=t) {
			params = new ArrayList<Object>();
			if(null!=t.getReplyid()){
				sb.append(" and replyid =? ");
				params.add(t.getReplyid());
			}
			if(null!=t.getTopicid()) {
				sb.append(" and topicid =? ");
				params.add(t.getTopicid());
			}
			if(null!=t.getUid()) {
				sb.append(" and u.uid =? ");
				params.add(t.getUid());
			}
		}
		sb.append(" order by modifytime asc ");
		System.out.println(sb.toString());
		return db.findMutipl(sb.toString(),params,ReplyVO.class);
	}
	@Override
	public List<Reply> findByTrem(Reply t) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}
	/**
	 * 修改信息
	 */
	@Override
	public int update(Reply t) throws Exception {
		String sql="update tb_reply set title=?,content=?,modifytime=now() where replyid=? and uid= ? ";
		return db.update(sql,t.getTitle(),t.getContent(),t.getReplyid(),t.getUid());
	}
	/**
	 * 删除回帖信息
	 */
	@Override
	public int delete(Reply t) throws Exception {
		String sql="delete from tb_reply where replyid=? and uid=? ";
		return db.update(sql,t.getReplyid(),t.getUid());
	}

}
