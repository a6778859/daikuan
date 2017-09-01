package com.daikuan.dao;

import com.daikuan.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommonMapper {
    User selectForUser(@Param("name") String name);


    List<Map> selectForLoanList();


    List<Map> selectForLabelList();

    List<Map> selectForRelation(int loanid);


    int insertByLoanId(@Param("loanid") int loanid,  @Param("label") List<String> label);


    int deleteByLoanid(int loanid);

}