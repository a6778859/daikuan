package com.daikuan.until.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//初始化 全局变量
public class ServletContextLoaderListener implements ServletContextListener {

    @SuppressWarnings("unchecked")
    public void contextInitialized(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        ServletContext servletContext = sce.getServletContext();
        // 网站名
        servletContext.setAttribute("TMP","/adminlte/");

    }

    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

}
