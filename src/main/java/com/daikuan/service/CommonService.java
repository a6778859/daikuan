package com.daikuan.service;

import com.daikuan.dao.CommonMapper;
import com.daikuan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommonService {
    @Autowired
    CommonMapper commonMapper;

    public User selectForUser(String name) {
        return commonMapper.selectForUser(name);
    }

    public List<Map> selectForLoanList(String status) {
        return commonMapper.selectForLoanList(status);
    }

    public List<Map> selectForLabelList() {
        return commonMapper.selectForLabelList();
    }

    public List<Map> selectForRelation(int loanid) {
        return commonMapper.selectForRelation(loanid);
    }

    public int insertByLoanId(int loanid, List<String> label) {
        return commonMapper.insertByLoanId(loanid, label);
    }

    public int deleteByLoanid(int loanid) {
        return commonMapper.deleteByLoanid(loanid);
    }

    public int updateByLoanUpdatetime(int loanid, Date date) {
        return commonMapper.updateByLoanUpdatetime(loanid, date);
    }


    public List<Map> selectForLoanDetail() {
        return commonMapper.selectForLoanDetail();
    }

    public List<Map> selectForLabelInLoanId(List tmpString) {
        return commonMapper.selectForLabelInLoanId(tmpString);
    }


    public List<Map> selectForSiteList() {
        return commonMapper.selectForSiteList();
    }



}
