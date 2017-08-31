package com.daikuan.until;


import com.daikuan.entity.User;
import com.daikuan.service.CommonService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class MyShiro extends AuthorizingRealm {

    private String myshiro_lock = "myShiro_lock_";
    @Autowired
    CommonService commonService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录时输入的用户名
        String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
        //到数据库查是否有此对象
        User user = commonService.selectForUser(loginName);
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            Set<String> set = new HashSet<String>();
            set.add(user.getRole());
            info.setRoles(set);
            return info;
        }
        return null;
    }

    /**
     * 登陆认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        synchronized (token.getUsername()) {
//            //查出是否有此用户
            User user = commonService.selectForUser(token.getUsername());
            if (user == null) {
                throw new UnknownAccountException();
            }
            //密码错误
            if (!user.getPassword().equals(String.valueOf(token.getPassword()))) {
                throw new UnknownAccountException();
            }
            return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
        }


    }
}
