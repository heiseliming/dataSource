package com.datasource.server.dao;


import com.datasource.server.pojo.Student_Info;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface Student_InfoMapper {
    int insert(Student_Info record);

    int insertSelective(Student_Info record);

    List<Student_Info>getList();
}