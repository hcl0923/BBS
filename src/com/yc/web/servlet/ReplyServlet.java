package com.yc.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Reply;
import com.yc.bean.ReplyVO;
import com.yc.bean.User;
import com.yc.biz.ReplyBiz;

@WebServlet("/reply.action")
public class ReplyServlet extends BaseServlet {
	ReplyBiz biz = new ReplyBiz() ;
	protected void doGet (HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		String op = request.getParameter("op");
		if("del".equals(op)) {
			doDel(request,response);
		}else if("add".equals(op)){
			doAdd(request, response);
		}else if("update".equals(op)) {
			doUpdate(request, response);
		}else if("findByID".contentEquals(op)){
			doFindByID(request, response);
		}else if("dianzan".equals(op)) {
			doDianZan(request,response);
		}
	}
	/**
	 *  点赞
	 * @param request
	 * @param response
	 */
	private void doDianZan(HttpServletRequest request, HttpServletResponse response) {
		try {
			Reply t =parseRequest(request,Reply.class);
			String info =biz.dianzan(t);
			toPrintJson(response,info);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据回帖编号查看回帖信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doFindByID(HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		try {
		ReplyVO t = parseRequest(request,ReplyVO.class);
		ReplyVO replyVO =biz. findByID(t) ;
		toPrintJson (response, replyVO) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 修改回帖信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doUpdate(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		try {
			User user=(User)request.getSession().getAttribute("user");
			Reply t =parseRequest(request,Reply.class);
			t.setUid(user.getUid());
			int i=biz.updateReply(t);
			toPrintJson (response,i);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 添加回帖信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doAdd (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		try {
			User user=(User)request.getSession().getAttribute("user");
			Reply t=parseRequest(request,Reply.class);
			t.setUid(user.getUid());
			int i=biz.addReply(t);
			toPrintJson(response,i);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/**
	 * 删除回帖信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doDel(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		try {
			//只能删除自己回帖信息
			User user=(User) request.getSession().getAttribute("user");
			Reply reply=parseRequest(request,Reply.class);
			reply.setUid(user.getUid());
			int i = biz.deleteByID(reply);
			toPrintJson(response,i);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
