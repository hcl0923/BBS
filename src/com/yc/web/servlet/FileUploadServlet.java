package com.yc.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.FileBean;
import com.yc.util.FileUploadUtil;

@WebServlet("/fileUpload.action")
public class FileUploadServlet extends BaseServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		try{
			FileBean bean=FileUploadUtil.parseRequest(request,FileBean.class);
			bean.setUploaded(1);
			bean.setUrl(bean.getUpload());
			toPrintJson(response,bean);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
