package com.daikuan.service;

import com.daikuan.dao.LoanMapper;
import com.daikuan.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    @Autowired
    LoanMapper loanMapper;
    public Loan selectByPrimaryKey(int id){
        return  loanMapper.selectByPrimaryKey(id);
    }

}
