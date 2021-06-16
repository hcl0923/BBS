package com.yc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.yc.bean.Topic;
import com.yc.dao.TopicDAO;

public class TopicDAOTest {
	TopicDAO dao=new TopicDAO();
	@Test
	public void testFindbyBoardid() throws Exception {
		Topic t=new Topic();
		t.setBoardid(8);
		List<Topic> list=dao.findbyBoardid(t, 1, 2);
		System.out.println(list.size());
		for(Topic tt:list) {
			System.out.println(tt);
		}
	}

}
