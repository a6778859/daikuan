package com.daikuan.service;

import com.daikuan.dao.SmslogMapper;
import com.daikuan.dao.UserMapper;
import com.daikuan.entity.Smslog;
import com.daikuan.entity.User;
import com.daikuan.until.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    CommonService commonService;


    public String save(User user, String realIp, HttpSession session, String codePhone, HttpServletRequest request, String umeng_channel) {
       synchronized (user.getName()) {
            //判断手机是否唯一
           if (commonService.selectByMobileCount(user.getName())>0) {
               return "该手机号码已被注册";
           }
           String result = commonService.checkMobileVcode(user.getName(), codePhone);
           if (!result.equals("")) {
               return result;
           }

           user.setAddtime(new Date());
           user.setPassword(CommonUtil.getMD5(user.getPassword()));// 密码加密
           userMapper.insertSelective(user);
       }
       return "";
    }
}
