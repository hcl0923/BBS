package com.yc.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.yc.bean.Board;
import com.yc.biz.BoardBiz;

public class BoardBizTest {
	BoardBiz biz=new BoardBiz();
	@Test
	public void testFindIndex() throws Exception {
		Map<String,Object> map=biz.findIndex();
		//System.out.println(map);
		List<Board> all=(List<Board>)map.get("child");
		for(Board b:all) {
			System.out.println(b);
		}
	}

}
