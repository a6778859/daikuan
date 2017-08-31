package com.daikuan.dao;

import com.daikuan.entity.User;
import org.apache.ibatis.annotations.Param;

public interface CommonMapper {
    User selectForUser(@Param("name") String name);
}