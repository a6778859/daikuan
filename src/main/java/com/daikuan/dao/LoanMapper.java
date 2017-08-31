package com.daikuan.dao;

import com.daikuan.entity.Loan;

public interface LoanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Loan record);

    int insertSelective(Loan record);

    Loan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loan record);

    int updateByPrimaryKeyWithBLOBs(Loan record);

    int updateByPrimaryKey(Loan record);
}