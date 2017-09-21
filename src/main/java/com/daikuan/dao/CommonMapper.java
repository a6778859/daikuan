package com.daikuan.dao;

import com.daikuan.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CommonMapper {
    User selectForUser(@Param("name") String name);


    List<Map> selectForLoanList(@Param("status") String status,@Param("label")String label);


    List<Map> selectForLabelList();

    List<Map> selectForRelation(int loanid);


    int insertByLoanId(@Param("loanid") int loanid,  @Param("label") List<String> label);


    int deleteByLoanid(int loanid);


    int updateByLoanUpdatetime(@Param("loanid") int loanid,@Param("date") Date date);

    List<Map> selectForLoanDetail();

    List<Map> selectForLabelInLoanId(@Param("list") List tmpString);

    List<Map> selectForSiteList();

    int selectByMobileCount(String name);

    void updatePassword(@Param("mobilePhone")String mobilePhone,@Param("md5") String md5);

    List<Map> selectForUserNoAdmin(@Param("phone")String phone);
}