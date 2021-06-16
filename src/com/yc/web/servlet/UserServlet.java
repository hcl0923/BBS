package com.yc.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.util.LogUtil;

/**
 * �û�������
 * @author hp
 *
 */
@WebServlet("/user.action")
public class UserServlet extends BaseServlet {
	UserBiz biz=new UserBiz();
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String op=request.getParameter("op");
		if("reg".equals(op)) {
			doReg(request,response);
		}else if("login".equals(op)) {
			doLogin(request,response);
		}else if("check".equals(op)){
			doCheck(request,response);
		}else {
			//��������һ������ҳ��
			response.sendRedirect("404.html");
		}
	}
	
	private void doCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user=(User) request.getSession().getAttribute("user");
		if(null==user) {
			toPrintJson(response,0);
		}else {
			toPrintJson(response,user);
		}
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user=parseRequest(request, User.class);
			User bean=biz.login(user);
			System.out.println(bean==null);
			if(null==bean){
				toPrintJson(response,0);
			}else{
				request.getSession().setAttribute("user", bean);
				toPrintJson(response,user);
			}
		}catch(Exception e) {
			LogUtil.log.error(new Date()+e.getMessage()+"�û���¼����");
		}
		
	}
	private void doReg(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user=parseRequest(request,User.class);
			int i=biz.register(user);
			toPrintJson(response,i);
		}catch(Exception e){
			LogUtil.log.error(new Date()+e.getMessage());
		}
	}
}
