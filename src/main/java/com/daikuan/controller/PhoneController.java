package com.daikuan.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import javax.validation.*;

import com.daikuan.entity.User;
import com.daikuan.until.AESUtil;
import com.daikuan.until.CommonUtil;
import com.daikuan.until.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * ios处理 返回json字段 不需要要判断登陆
 *
 * @author admin
 */
@Controller
@RequestMapping("Phone")
public class PhoneController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(PhoneController.class);


    @RequestMapping(value = "/APPLogin", method = RequestMethod.POST)
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

    /**
     * 注册用户
     *
     * @param user
     * @param CodePhone
     * @param
     * @param UMENG_CHANNEL
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String Register(@Valid User user, BindingResult result, String CodePhone, String UMENG_CHANNEL) throws Exception {
        if (!result.hasErrors()) {
            String wrong = userService.save(user, CommonUtil.getRealIp(request), session, CodePhone, request, UMENG_CHANNEL);
            if (!wrong.equals("")) {
                writeError(wrong);
            } else {
                writeSuccessJson("/");
            }
        } else {
            // 失败
            writeError(getErrors(result));
        }
        return null;
    }


    @RequestMapping(value = "/ForgetPassword")
    public String ForgetPassword(String CodePhone, String MobilePhone, String Password) throws Exception {
        String result = commonService.checkMobileVcode(MobilePhone, CodePhone);
        if (!result.equals("")) {
            writeError(result);
            return null;
        }
        // 更改密码
        commonService.updatePassword(MobilePhone, CommonUtil.getMD5(Password));
        session.setAttribute("PhoneCode", null);
        session.setAttribute("Phone", null);
        writeSuccessJson("操作成功请重新登陆");
        return null;
    }


    /**
     * 获取临时的token
     *
     * @throws IOException
     */
    @RequestMapping(value = "/getTemptoke")
    public String getTemptoke() throws IOException {
        // CommonUtil.getUUID();
        writeSuccessJson(CommonUtil.getUUID());
        return null;
    }


    /**
     * 发送短信
     *
     * @param PhoneStr
     * @param Code_
     * @param temptoken
     * @return
     * @throws IOException
     * @throws ParseException
     */
    @RequestMapping(value = "/Vcode", method = RequestMethod.GET)
    public String test(String PhoneStr, String Code_, String temptoken) throws IOException, ParseException {

        String result = smslogService.check(PhoneStr, Code_, temptoken, request, session);
        if (result.equals("")) {
            writeSuccessJson("短信发送成功");
        } else {
            writeError(result);
        }
        return null;
    }






}
