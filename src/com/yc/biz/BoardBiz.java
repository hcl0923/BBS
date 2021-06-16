package com.yc.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yc.bean.Board;
import com.yc.dao.BoardDAO;

public class BoardBiz {
	BoardDAO dao=new BoardDAO();
	/**
	 * 首页显示  分版块统计以及筛选出最新的主题信息
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> findIndex() throws Exception{
		List<Board> parent =new ArrayList<Board>();
		List<Board> child =new ArrayList<Board>();
		List<Board> all = dao.findIndex();
		Map<String,Object> map = new HashMap<String,Object> () ;
		for(int i =0;i<all.size();i++) {
			Board board =all .get (i);
			if(board.getParentid()==0){
				parent.add(board); //顶级版块信息存在parent
			}else{
				child.add(board);
			}
		}
		map.put("parent",parent);
		map.put("child",child);
		return map;
	}
}
