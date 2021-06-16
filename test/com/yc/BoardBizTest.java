package com.yc;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.yc.biz.BoardBiz;

public class BoardBizTest {
	BoardBiz biz=new BoardBiz();
	@Test
	public void testFindIndex() throws Exception {
		Map<String,Object> map=biz.findIndex();
		System.out.println(map);
	}

}
