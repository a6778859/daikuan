package com.daikuan.interceptor;

import com.daikuan.until.AESUtil;
import com.daikuan.until.StringUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggedInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // url
        boolean flag = false;
        String token = request.getParameter("token");
        if (!StringUtil.isBlank(request.getParameter("token")) && request.getParameter("test8859") != null) {
            token = java.net.URLEncoder.encode(request.getParameter("token"), "utf-8");
        }
        String customerid = "";
        if (!StringUtil.isBlank(token)) {
            customerid = AESUtil.AESDecode(java.net.URLDecoder.decode(token, "utf-8"));
        }
        if (!StringUtil.isBlank(customerid)) {
            // 登录成功
            request.setAttribute("customerid", customerid);
            flag = true;
        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("{\"state\":\"0\",\"msg\":\"" + "请先登录" + "\"}");
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
