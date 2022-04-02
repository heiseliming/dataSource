package com.datasource.server.common.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author yangxd
 * @descriptions
 * @date 2020年08月26日
 */
@Configuration
@Import({
        DruidDataSouceConfig.class
})
public class DynamicDataSourceConfig {

    @Bean
    public DynamicDataSource dynamicDataSource(DataSource dataSource) {
        return new DynamicDataSource(dataSource);
    }
    @Bean
    @ConditionalOnBean(name="dynamicDataSource")
    public DataSourceTransactionManager dynamicTransactionManager(@Qualifier("dynamicDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
