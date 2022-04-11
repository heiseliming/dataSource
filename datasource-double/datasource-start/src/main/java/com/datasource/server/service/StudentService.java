package com.datasource.server.service;

import com.datasource.server.pojo.Student_Info;
import com.datasource.server.pojo.T_Card;

import java.util.List;

public interface StudentService {
    public List<Student_Info> getList();
}
