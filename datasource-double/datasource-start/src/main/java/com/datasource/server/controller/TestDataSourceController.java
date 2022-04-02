package com.datasource.server.controller;

import com.datasource.server.common.utils.Result;
import com.datasource.server.common.utils.ResultUtil;
import com.datasource.server.service.TestDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1")
public class TestDataSourceController {

    @Autowired
    TestDataSourceService testDataSourceService;

    @RequestMapping("/test1")
    public Result test1(){

        return ResultUtil.success(testDataSourceService.query());
    }
}
