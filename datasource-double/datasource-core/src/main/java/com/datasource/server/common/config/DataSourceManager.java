package com.datasource.server.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.datasource.server.common.pojo.T_Datascore_Config;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.lang.reflect.Field;

/**
 * @author yangxd
 * @descriptions
 * @date 2020年08月26日
 */
@Component
public class DataSourceManager implements InitializingBean {

    Logger log = LoggerFactory.getLogger(DataSourceManager.class);


    @Resource
    DynamicDataSource dynamicDataSource;
    @Resource
    SqlSessionFactory sqlSessionFactory;


    @Override
    public void afterPropertiesSet() throws Exception {
        //将sqlsession中的默认数据源改为动态数据源
        DefaultSqlSessionFactory defaultSqlSessionFactory = (DefaultSqlSessionFactory) sqlSessionFactory;
        Environment environment = defaultSqlSessionFactory.getConfiguration().getEnvironment();
        Field field = environment.getClass().getDeclaredField("dataSource");

        field.setAccessible(true);
        field.set(environment, dynamicDataSource);
        log.debug("数据源更新为动态数据源成功！");
    }

    /**
     * 根据环境信息初始化生成dataSource.初始化之前需要检查连接是否可用
     * @param data
     * @return
     */
    public DataSource initDataSource(T_Datascore_Config data) {
        //todo  需要添加更多参数,直接使用配置文件中配置还是在页面配置？
        if (StringUtils.isAnyBlank(data.getUrl(), data.getUserName(),
                data.getPassword())) {

        }
        // 需要校验连接是否可用。
//        DataSourceUrlUtils.testUrl(data.getDatasourceType(),data.getDatasourceAddress(),data.getDatasourceUserName(),data.getDatasourcePassword(),data.getDatasourceDriver());
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(DataSourceUrlUtils.getUrl(data.getType(), data.getUrl()));
        druidDataSource.setUsername(data.getUserName());
        druidDataSource.setPassword(data.getPassword());
        String driver = data.getDriver();
        if(StringUtils.isBlank(driver)){
            driver = DataSourceEnum.getEnum(data.getType()).getDriverClass();
        }
        druidDataSource.setDriverClassName(driver);
        return druidDataSource;
    }


    public void addDataSource(T_Datascore_Config data) {
        dynamicDataSource.addDataSource(data.getType()+data.getId(), initDataSource(data));
    }
}
