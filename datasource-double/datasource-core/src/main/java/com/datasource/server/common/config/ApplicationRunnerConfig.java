package com.datasource.server.common.config;

import com.datasource.server.common.dao.T_Datascore_ConfigMapper;
import com.datasource.server.common.pojo.T_Datascore_Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

//注意：类必须交由spring管理，且可以成功创建成一个bean
@Component
public class ApplicationRunnerConfig implements ApplicationRunner {
    @Resource
    T_Datascore_ConfigMapper t_datascore_configMapper;
    @Autowired
    protected DataSourceManager dataSourceManager;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<T_Datascore_Config> datascoreConfig = t_datascore_configMapper.getDatascoreConfig();
        System.out.println("datascoreConfig" + datascoreConfig);
        for(T_Datascore_Config datascore:datascoreConfig){
            dataSourceManager.addDataSource(datascore);
        }
    }
}
