package com.daikuan.dao;

import com.daikuan.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommonMapper {
    User selectForUser(@Param("name") String name);


    List<Map> selectForLoanList();


    List<Map> selectForLabelList();

}