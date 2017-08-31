package com.daikuan.controller;

import com.daikuan.entity.User;
import com.daikuan.until.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/home/login.jsp";
    }

    /**
     * 退出登录
     * @param modelMap
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public String out(ModelMap modelMap) throws IOException {
        SecurityUtils.getSubject().logout();
        return "redirect:/home/login";
    }



    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login_(User user) throws IOException {
        try  {
        SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getName(), MD5Util.MD5(user.getPassword())));
        }catch (UnknownAccountException e){
            writeErrorJson("账号或密码错误");
            return null;
        }catch (Exception e){
            writeErrorJson("异常");
            return null;
        }
        writeSuccessJson("成功");
        return null;
    }


    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
       // System.out.println("121");
        return "/home/index.jsp";
    }







}
