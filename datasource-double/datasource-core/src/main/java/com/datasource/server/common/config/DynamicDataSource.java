package com.datasource.server.common.config;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicCustomerContextHolder.getContextKey();
    }
    public DynamicDataSource(){
    }

    public DynamicDataSource(DataSource dataSource){
        Map<String,DataSource> dataSourceMap = new ConcurrentHashMap<>(8);
        dataSourceMap.put(DynamicCustomerContextHolder.DEFAULT, dataSource);
        this.seteRolvedDataSources(dataSourceMap);
        this.setDefaultResolvedDefaultDataSource(dataSource);
    }

}