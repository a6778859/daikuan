package com.daikuan.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.daikuan.entity.Loan;
import com.daikuan.entity.User;
import com.daikuan.until.AESUtil;
import com.daikuan.until.CommonUtil;
import com.daikuan.until.PageLimit;
import com.daikuan.until.StringUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.ParseException;


@Controller
@RequestMapping("/logged")
public class LoggedController extends BaseController {


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() throws IOException {

        String Password = (String) request.getParameter("Password");
        String PhoneNum = (String) request.getParameter("PhoneNum");
        if (StringUtil.isBlank(Password) || StringUtil.isBlank(PhoneNum)) {
            writeErrorJson("密码或账号不能为空");
            return null;
        }
        if (AESUtil.AESDecode(Password) == null) {
            Password = CommonUtil.getMD5(Password);
        } else {
            Password = AESUtil.AESDecode(Password);
        }
        User user = commonService.selectForUser(PhoneNum);
        if (user != null) {
            if (user.getPassword().equals(Password)) {
                String token = AESUtil.AESEncode(user.getId() + "");
                writeSuccessJson(java.net.URLEncoder.encode(token, "utf-8"));
            } else {
                writeErrorJson("账号或密码错误");
            }
        } else {
            writeErrorJson("账号或密码错误");
        }


        return null;
    }


    @RequestMapping(value = "/Vcode", method = RequestMethod.GET)
    public String test(String PhoneStr, String Code_,String temptoken) throws Exception {

        String result = smslogService.check(PhoneStr, Code_, temptoken, request, session);
        if (result.equals("")) {
            writeSuccessJson("短信发送成功");
        } else {
            writeErrorJson(result);
        }
        return null;
    }









    //








}
