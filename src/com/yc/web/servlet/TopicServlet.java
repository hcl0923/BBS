package com.yc.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Topic;
import com.yc.bean.TopicVO;
import com.yc.bean.User;
import com.yc.biz.TopicBiz;
import com.yc.util.LogUtil;

@WebServlet("/topic.action")
public class TopicServlet extends BaseServlet {
	TopicBiz biz=new TopicBiz();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String op=request.getParameter("op");
		if("findByid".equals(op)) {
			doFindById(request,response);
		}else if("add".equals(op)){
			doAdd(request, response);
		}else if("findPage".equals(op)) {
			doFindPage(request,response);
		}
	}
	/**
	 *  查看主题信息以及回帖数量
	 * @param request
	 * @param response
	 */
	private void doFindPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			TopicVO t=parseRequest(request, TopicVO.class);
			String pageInfo=request.getParameter("page");
			String rowsInfo=request.getParameter("rows");
			Map<String,Object> map=null;
			if (null==pageInfo||"".equals(pageInfo)||null==rowsInfo||"".equals(rowsInfo) ) {
				//如果页码或每页显示行数为空则不进行分页查询
				map =biz.findByPageVO(t,null,null);
			} else{
				map =biz.findByPageVO(t, Integer.parseInt(pageInfo),Integer.parseInt(rowsInfo));
			}
			toPrintJson(response,map);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 添加主题信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doAdd (HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException {
		try {
			User user =(User)request.getSession().getAttribute("user");
			Topic t =parseRequest(request,Topic.class);
			t.setUid(user.getUid());
			int i =biz.add(t) ;
			toPrintJson(response,i);
		}catch(Exception e){
		e.printStackTrace();
		}
	}
	
	/**
	 * 根据主题编号查询主题信息以及回帖信息
	 * @param request
	 * @param response
	 */
	private void doFindById(HttpServletRequest request, HttpServletResponse response){
		try {
			TopicVO vo=parseRequest(request, TopicVO.class);
			Map<String,Object> map=biz.findByTopicid(vo);
			toPrintJson(response, map);
		}catch(Exception e){
			LogUtil.log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
