package com.daikuan.service;

import com.daikuan.dao.TestMapper;
import com.daikuan.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    TestMapper testDao;

    /**
     *
     * @param id
     * @return
     */
     public Test selectByPrimaryKey(Integer id){
        return testDao.selectByPrimaryKey(id);
    }



}
