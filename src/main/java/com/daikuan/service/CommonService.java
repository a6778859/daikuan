package com.daikuan.service;

import com.daikuan.dao.CommonMapper;
import com.daikuan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommonService {
    @Autowired
    CommonMapper commonMapper;

    public User selectForUser(String name) {
        return commonMapper.selectForUser(name);
    }

    public List<Map> selectForLoanList() {
        return commonMapper.selectForLoanList();
    }

    public List<Map> selectForLabelList() {
        return commonMapper.selectForLabelList();
    }

    public List<Map> selectForRelation(int loanid) {
        return commonMapper.selectForRelation(loanid);
    }

    public int insertByLoanId(int loanid, List<String> label){
        return commonMapper.insertByLoanId(loanid,label);
    }

    public int deleteByLoanid(int loanid){

        return commonMapper.deleteByLoanid(loanid);
    }
}
