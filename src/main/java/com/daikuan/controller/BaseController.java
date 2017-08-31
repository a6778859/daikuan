package com.daikuan.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.InvalidSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 控制器基类
 * Created by ZhangShuzheng on 2017/2/4.
 */
public abstract class BaseController {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;




	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();

	}


	private final static Logger _log = LoggerFactory.getLogger(BaseController.class);

//	/**
//	 * 统一异常处理
//	 * @param request
//	 * @param response
//	 * @param exception
//	 */
//	@ExceptionHandler
//	public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
//		_log.error("统一异常处理：", exception);
//		request.setAttribute("ex", exception);
//		if (null != request.getHeader("X-Requested-With") && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
//			request.setAttribute("requestHeader", "ajax");
//		}
//		// shiro没有权限异常
//		if (exception instanceof UnauthorizedException) {
//			return "/403.jsp";
//		}
//		// shiro会话已过期异常
//		if (exception instanceof InvalidSessionException) {
//			return "/error.jsp";
//		}
//		return "/error.jsp";
//	}



	public void write(String str) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(str);
	}

	/***
	 * 向客户端写入json格式信息
	 *
	 * @param str
	 * @throws IOException
	 */
	public void writeErrorJson(String str) throws IOException {
		write("{\"state\":\"0\",\"msg\":\"" + str + "\"}");
	}

	/***
	 * 向客户端写入json格式信息
	 *
	 * @param str
	 * @throws IOException
	 */
	public void writeSuccessJson(String str) throws IOException {
		write("{\"state\":\"1\",\"msg\":\"" + str + "\"}");
	}

}
