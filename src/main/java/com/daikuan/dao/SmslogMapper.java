package com.daikuan.dao;

import com.daikuan.entity.Smslog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SmslogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Smslog record);

    int insertSelective(Smslog record);

    Smslog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Smslog record);

    int updateByPrimaryKeyWithBLOBs(Smslog record);

    int updateByPrimaryKey(Smslog record);

    int countSqlQueryResult(@Param("phone") String phone,@Param("begin") String begin,@Param("end")  String end);

    List<Map> findMapBySQL(String phoneStr);

    List<Map> getByPhone(@Param("phone") String phone,@Param("date") String date);

    void setCount(String id);
}