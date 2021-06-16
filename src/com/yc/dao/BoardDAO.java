package com.yc.dao;

import java.util.List;

import com.yc.bean.Board;
import com.yc.commons.DbHelper;

public class BoardDAO implements BaseDao<Board> {
	DbHelper db=new DbHelper();
	@Override
	public int add(Board t) throws Exception {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public List<Board> findByTrem(Board t) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int update(Board t) throws Exception {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int delete(Board t) throws Exception {
		// TODO 自动生成的方法存根
		return 0;
	}
	/**
	 * 显示在首页的数据
	 * @return
	 * @throws Exception
	 */
	public List<Board> findIndex() throws Exception{
		StringBuffer sb=new StringBuffer();
		sb.append("select a.boardid,boardname,parentid,total,topicid,title,");
		sb.append("date_format(modifytime,'%Y-%m-%d %H:%I:%S') as recentmodifytime,uname from ");
		sb.append(" (select tb_board.boardid,boardname,parentid,count(topicid) as total from");
		sb.append(" tb_board LEFT join tb_topic on tb_board.boardid=tb_topic.boardid group by tb_board.boardid,boardname,parentid) a");
		sb.append(" left join (select topicid,title,a.modifytime,a.uname,a.boardid from ");
		sb.append(" (select boardid,topicid,title,modifytime,uname from tb_topic left join tb_user on tb_topic.uid=tb_user.uid)a,");
		sb.append(" (select boardid,max(modifytime) as modifytime from tb_topic group by boardid ) b where a.boardid =b.boardid and a.modifytime =b.modifytime ) b ");
		sb.append(" on a.boardid =b.boardid ");
		System.out.println(sb.toString());
		return db.findMutipl(sb.toString(),null,Board.class);
	}
}
