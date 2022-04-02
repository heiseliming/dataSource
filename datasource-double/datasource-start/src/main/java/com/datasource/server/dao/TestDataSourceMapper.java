package com.datasource.server.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestDataSourceMapper {



    @Select({"select * from t_config_user where 1=1"})
    List<Map<String, Object>> queryForListMysql();


    @Select({"select * from T_SEQ_TEMPLATE_RULE where 1=1"})
    List<Map<String, Object>> queryForListOracle();
}
