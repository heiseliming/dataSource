package com.datasource.server.common.dao;


import com.datasource.server.common.pojo.T_Datascore_Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface T_Datascore_ConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(T_Datascore_Config record);

    int insertSelective(T_Datascore_Config record);

    T_Datascore_Config selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T_Datascore_Config record);

    int updateByPrimaryKey(T_Datascore_Config record);
    @Select({"select id,type,url,driver,user_name as userName,password from t_datascore_config"})
    List<T_Datascore_Config> getDatascoreConfig();
}