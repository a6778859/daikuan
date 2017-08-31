package com.daikuan.service;

import com.daikuan.dao.CommonMapper;
import com.daikuan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    @Autowired
    CommonMapper commonMapper;

    public User selectForUser(String name) {
        return commonMapper.selectForUser(name);
    }
}
