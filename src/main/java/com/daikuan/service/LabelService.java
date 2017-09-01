package com.daikuan.service;

import com.daikuan.dao.LabelMapper;
import com.daikuan.dao.LoanMapper;
import com.daikuan.entity.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelService {
    @Autowired
    LabelMapper labelMapper;

    public Label selectByPrimaryKey(int id){
        return labelMapper.selectByPrimaryKey(id);
    }

    public  int insertSelective(Label label){
        return labelMapper.insertSelective(label);
    }

    public  int updateByPrimaryKeySelective(Label label){
        return labelMapper.updateByPrimaryKeySelective(label);
    }
}
