package com.yc.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.biz.BoardBiz;
import com.yc.util.LogUtil;

@WebServlet("/board.action")
public class BoardServlet extends BaseServlet {
	BoardBiz biz=new BoardBiz();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String op=request.getParameter("op");
		if("find".equals(op)) {
			doFind(request,response);
		}else {
		}
	}
	
	/**
	 * ÏÔÊ¾Ê×Ò³
	 * @param request
	 * @param response
	 */
	private void doFind(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, Object> map=biz.findIndex();
			toPrintJson(response, map);
		}catch(Exception e) {
			LogUtil.log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
