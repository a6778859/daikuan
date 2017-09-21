package com.daikuan.service;

import com.daikuan.dao.UserMapper;
import com.daikuan.entity.User;
import com.daikuan.until.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

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
           user.setStatus("1");
           user.setAddtime(new Date());
           user.setPassword(CommonUtil.getMD5(user.getPassword()));// 密码加密
           userMapper.insertSelective(user);
       }
       return "";
    }

    public User selectByPrimaryKey(int id) {
       return userMapper.selectByPrimaryKey(id);
    }


    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    public void updateByPrimaryKeySelective(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
