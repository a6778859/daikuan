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
                //writeSuccessJson(token);
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
    public String test(String PhoneStr, String Code_, String temptoken) throws Exception {

        String result = smslogService.check(PhoneStr, Code_, temptoken, request, session);
        if (result.equals("")) {
            writeSuccessJson("短信发送成功");
        } else {
            writeError(result);
        }
        return null;
    }


    //登录成功以后

    /**
     * 获取用户信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser() throws Exception {
        JSONObject json = new JSONObject();
        try {
            int id = Integer.parseInt(request.getAttribute("customerid") + "");
            User user = userService.selectByPrimaryKey(id);
            json.put("phone", user.getName());
            json.put("state", "1");
        } catch (Exception e) {
            System.out.println(e.toString());
            json.put("state", "-1");
            json.put("msg", "异常");
        }
        String jsonString = JSON.toJSONString(json);
        System.out.println(jsonString);
        write(jsonString);
        return null;
    }


    /**
     * 获取用户信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public String getUserInfo() throws Exception {
        JSONObject json = new JSONObject();
        User user=null;
        String jsonString="";
        try {
            int id = Integer.parseInt(request.getAttribute("customerid") + "");
            user = userService.selectByPrimaryKey(id);
            jsonString = JSON.toJSONString(user);
            jsonString= jsonString.substring(0,jsonString.length()-1)+",\"state\":\"1\"}";
           // jsonString.replace(jsonString.charAt(jsonString.length()-1)+"",",\"state\":\"1\"}");
        } catch (Exception e) {
            json.put("state", "-1");
            json.put("msg", "异常");
            jsonString = JSON.toJSONString(json);
        }
        System.out.println(jsonString);
        write(jsonString);
        return null;
    }


    /**
     * 修改用户信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(User user) throws Exception {
        JSONObject json = new JSONObject();
        try {
            int id = Integer.parseInt(request.getAttribute("customerid") + "");
            user.setId(id);
            user.setStatus(null);
            user.setPassword(null);
            user.setRole(null);
            user.setName(null);
            userService.updateByPrimaryKeySelective(user);
            json.put("msg", "修改成功");
            json.put("state", "1");
        } catch (Exception e) {
            System.out.println(e.toString());
            json.put("state", "-1");
            json.put("msg", "异常");
        }
        String jsonString = JSON.toJSONString(json);
        System.out.println(jsonString);
        write(jsonString);
        return null;
    }

}
