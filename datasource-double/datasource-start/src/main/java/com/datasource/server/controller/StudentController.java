package com.datasource.server.controller;

import com.datasource.server.pojo.Student_Info;
import com.datasource.server.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StudentController {
    @Resource
    StudentService studentService;
    @RequestMapping("getList")
    public List<Student_Info> getList(){
        List<Student_Info> list = studentService.getList();
        return list;
    }
}
