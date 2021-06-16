package com.yc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yc.bean.Topic;
import com.yc.bean.TopicVO;
import com.yc.commons.DbHelper;

public class TopicDAO implements BaseDao<Topic>{
	DbHelper db=new DbHelper();
	@Override
	public int add(Topic t) throws Exception {
		String sql="insert into tb_topic values(null,?,?,now(),now(),?,?)";
		return db.update(sql,t.getTitle(),t.getContent(),t.getUid(),t.getBoardid());
	}

	@Override
	public List<Topic> findByTrem(Topic t) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}
	/**
	 * 分页时总条数
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public int findByPageTotal (TopicVO t) throws SQLException{
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from ( ");
		sb.append("select tb_reply.topicid,count(*) as total from tb_reply left join tb_topic ") ;
		sb.append(" on tb_topic.topicid =tb_reply.topicid group by tb_reply.topicid ) a right join( ");
		sb.append(" select topicid,title,content,DATE_FORMAT(publishtime,'%Y-%m-%d %H:%i' ) as publishtime, ");
		sb.append(" DATE_FORMAT(modifytime,'%Y-%m-%d %H:%i') as modifytime,t.uid,b.boardid,boardname,");
		sb.append(" parentid,uname,upass,head,DATE_FORMAT(regtime,'%Y-%m-%d %H:%i') as regtime, gender ");
		sb.append(" from tb_topic t LEFT join tb_board b on t.boardid =b.boardid ");
		sb.append(" left join tb_user u on u.uid =t.uid) b on a.topicid =b.topicid where 1=1 ");
		List<Object> params =null;
		if(null!=t) {
			params = new ArrayList<Object>();
			if (null!=t.getBoardid()){
				sb.append(" and b.boardid =?");
				params.add(t.getBoardid());//根据版块查看
			}
		}
		return (int)db.getPolymer(sb.toString(),params);
	}
	
	/**
	 * 主题信息
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public List<TopicVO> findByPage (TopicVO t) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("select topicid,title,content,DATE_FORMAT(publishtime,'%Y-%m-%d %H:%i') as publishtime,");
		sb.append(" DATE_FORMAT(modifytime,'%Y-%m-%d %H:%i') as modifytime,t.uid,b.boardid,boardname, ");
		sb.append(" parentid,uname,upass,head,DATE_FORMAT(regtime,'%Y-%m-%d %H:%i') as regtime,gender ");
		sb.append(" from tb_topic t LEFT join tb_board b on t.boardid=b.boardid ");
		sb.append(" left join tb_user u on u.uid=t.uid where 1=1 ");
		List<Object> params=null;
		if (null!=t) {
			params =new ArrayList<Object>();
			if (null!=t.getBoardid()) {
				sb.append(" and b.boardid=? ");
				params.add(t.getBoardid());
			}
			if(null!=t.getTopicid()) {
				sb.append(" and t. topicid=? ");
				params.add(t.getTopicid());
			}
			if(null!=t.getUid()) {
				sb.append(" and u.uid =? ");
				params.add(t.getUid());
			}
		}
		sb.append(" order by t.topicid desc ");
		System.out.println(sb.toString());
		return db.findMutipl(sb.toString(),params,TopicVO.class);
	}
	@Override
	public int update(Topic t) throws Exception {
		// TODO 自动生成的方法存根
		return 0;
	}
	/**
	 * 分页显示主题信息以及回帖数量
	 * @param t
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<TopicVO> findByPageVO (TopicVO t, Integer pageNum, Integer pageSize) throws Exception{
		StringBuffer sb = new StringBuffer() ;
		sb.append("select b.*,a.total from (");
		sb.append("select tb_reply.topicid,count(*) as total from tb_reply left join tb_topic ") ;
		sb.append(" on tb_topic.topicid =tb_reply.topicid group by tb_reply.topicid ) a right join( ");
		sb.append(" select topicid,title,content,DATE_FORMAT(publishtime,'%Y-%m-%d %H:%i' ) as publishtime, ");
		sb.append(" DATE_FORMAT(modifytime,'%Y-%m-%d %H:%i') as modifytime,t.uid,b.boardid,boardname,");
		sb.append(" parentid,uname,upass,head,DATE_FORMAT(regtime,'%Y-%m-%d %H:%i') as regtime, gender ");
		sb.append(" from tb_topic t LEFT join tb_board b on t.boardid =b.boardid ");
		sb.append(" left join tb_user u on u.uid =t.uid) b on a.topicid =b.topicid where 1=1 ");
		List<Object> params =null;
		if(null!=t) {
			params=new ArrayList<Object>();
			if(null!=t.getBoardid()) {
				sb.append(" and b.boardid =? ");
				params.add(t.getBoardid());//根据版块查看
			}
		}
		sb.append(" order by b.modifytime desc ");
		if(null!=pageNum &&null!=pageSize) {
			sb.append(" limit "+(pageNum-1)*pageSize+","+pageSize);
		}
		return db.findMutipl(sb.toString(),params,TopicVO.class);
	}
	@Override
	public int delete(Topic t) throws Exception {
		// TODO 自动生成的方法存根
		return 0;
	}
	/**
	 * 查看某个板块下的主题信息在主题信息中的统计回贴数量
	 * @param t
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Topic> findbyBoardid (Topic t,Integer pageNum, Integer pageSize) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("select a.topicid,title,content,publishtime,modifytime,uid,uname,boardid,replycount from ") ;
		sb.append(" (select topicid,title,content,DATE_FORMAT(publishtime,'%Y-%m-%d %H:%i:%s') as publishtime,DATE_FORMAT(modifytime,'%Y-%m-%d %H:%i:%s') as modifytime,");
		String sql="t.uid,uname,boardid from tb_topic t inner join tb_user u on t.uid=u.uid where boardid=? limit "+(pageNum-1)*pageSize+","+pageSize+" ) a";
		sb.append(sql);
		sb.append(" left join ( select topicid,count(*) as replycount from tb_reply group by topicid ) b on b.topicid=a.topicid ");
		List<Object> params =new ArrayList<Object>();
		params.add(t.getBoardid());
		System.out.println(sb.toString());
		return db.findMutipl(sb.toString(),params,Topic.class);
	}
}
