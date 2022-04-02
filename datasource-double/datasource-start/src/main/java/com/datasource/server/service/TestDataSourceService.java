package com.datasource.server.service;

import com.alibaba.fastjson.JSONObject;
import com.datasource.server.common.config.DatasourceSwitch;
import com.datasource.server.common.utils.Result;
import com.datasource.server.dao.TestDataSourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestDataSourceService {


    @Autowired
    TestDataSourceMapper testMapper;
    @Autowired
    DatasourceSwitch datasourceSwitch;

    public Result query() {
        List<Map<String, Object>> list = testMapper.queryForListMysql();
        String list1 = JSONObject.toJSONString(list);
        datasourceSwitch.switchToConfigurationDataSource();
        List<Map<String, Object>> list2 = testMapper.queryForListOracle();
        String list3 = JSONObject.toJSONString(list2);
        datasourceSwitch.switchToDefaultDataSource();
        Result result = new Result();
        Map<String, String> map = new HashMap<>();
        map.put("list1", list1);
        map.put("list3", list3);
        result.setData(map);
        return result;
    }

}
