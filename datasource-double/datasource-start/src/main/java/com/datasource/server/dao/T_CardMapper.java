package com.datasource.server.dao;


import com.datasource.server.pojo.T_Card;

public interface T_CardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_Card record);

    int insertSelective(T_Card record);

    T_Card selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T_Card record);

    int updateByPrimaryKey(T_Card record);
}