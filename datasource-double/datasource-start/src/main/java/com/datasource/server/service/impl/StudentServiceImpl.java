package com.datasource.server.service.impl;

import com.datasource.server.common.config.DatasourceSwitch;
import com.datasource.server.dao.Student_InfoMapper;
import com.datasource.server.pojo.Student_Info;
import com.datasource.server.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    DatasourceSwitch datasourceSwitch;
    @Resource
    Student_InfoMapper student_infoMapper;
    @Override
    public List<Student_Info> getList() {

        datasourceSwitch.switchDataSourceByKey("mysql1");
        List<Student_Info> list = student_infoMapper.getList();
        return list;
    }
}
