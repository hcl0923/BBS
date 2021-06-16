package com.yc;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.yc.bean.TopicVO;
import com.yc.biz.TopicBiz;

public class TopicBizTest {
	TopicBiz biz=new TopicBiz();
	@Test
	public void testFindByTopicid() throws Exception {
		TopicVO vo=new TopicVO();
		vo.setTopicid(1);
		Map<String,Object> map=biz.findByTopicid(vo);
		System.out.println(map);
	}

}
