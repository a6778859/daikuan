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

    public  int insertSelective(Loan loan){
        return loanMapper.insertSelective(loan);
    }

    public  int updateByPrimaryKeySelective(Loan loan){
        return loanMapper.updateByPrimaryKeySelective(loan);
    }


}
