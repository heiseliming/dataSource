package com.datasource.server.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.datasource.server.common.utils.PassWordUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 数据源配置
 */
@Configuration
@ConditionalOnClass(DriverManager.class)
@Conditional(DruidDataSouceConfigConditon.class)
public class DruidDataSouceConfig {
    private  static Logger logger= LoggerFactory.getLogger(DruidDataSouceConfig.class);
    @Value("${db.datasource.url}")
    private String dbUrl;
    @Value("${db.datasource.username}")
    private String username;
    @Value("${db.datasource.password}")
    private String password;
    @Value("${db.datasource.driverClassName}")
    private String driverClassName;
    @Value("${db.datasource.initialSize:-1}")
    private Integer initialSize;
    @Value("${db.datasource.minIdle:-1}")
    private Integer minIdle;
    @Value("${db.datasource.maxActive:-1}")
    private Integer maxActive;
    @Value("${db.datasource.maxWait:-1}")
    private Integer maxWait;
    @Value("${db.datasource.timeBetweenEvictionRunsMillis:-1}")
    private Integer timeBetweenEvictionRunsMillis;
    @Value("${db.datasource.minEvictableIdleTimeMillis:-1}")
    private Integer minEvictableIdleTimeMillis;
    @Value("${db.datasource.validationQuery:}")
    private String validationQuery;
    @Value("${db.datasource.testWhileIdle:false}")
    private boolean testWhileIdle;
    @Value("${db.datasource.testOnBorrow:false}")
    private boolean testOnBorrow;
    @Value("${db.datasource.testOnReturn:false}")
    private boolean testOnReturn;
    @Value("${db.datasource.poolPreparedStatements:false}")
    private boolean poolPreparedStatements;
    @Value("${db.datasource.maxPoolPreparedStatementPerConnectionSize:-1}")
    private Integer maxPoolPreparedStatementPerConnectionSize;
    @Value("${db.datasource.filters:}")
    private String filters;
    @Value("${db.datasource.connectionProperties:}")
    private String connectionProperties;

    @Value("${db.datasource.removeAbandoned:}")
    private Boolean removeAbandoned;
    @Value("${db.datasource.removeAbandonedTimeout:}")
    private Integer removeAbandonedTimeout;
    @Value("${db.datasource.logAbandoned:}")
    private Boolean logAbandoned;
    
    
    public DruidDataSouceConfig() {

    }

    public DruidDataSouceConfig(String dbUrl, String username, String password, String driverClassName, Integer initialSize,
                                Integer minIdle, Integer maxActive, Integer maxWait, Integer timeBetweenEvictionRunsMillis, Integer minEvictableIdleTimeMillis,
                                String validationQuery, boolean testWhileIdle, boolean testOnBorrow, boolean testOnReturn, boolean poolPreparedStatements,
                                Integer maxPoolPreparedStatementPerConnectionSize, String filters, String connectionProperties) {
        this.dbUrl = dbUrl;
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
        this.initialSize = initialSize;
        this.minIdle = minIdle;
        this.maxActive = maxActive;
        this.maxWait = maxWait;
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
        this.validationQuery = validationQuery;
        this.testWhileIdle = testWhileIdle;
        this.testOnBorrow = testOnBorrow;
        this.testOnReturn = testOnReturn;
        this.poolPreparedStatements = poolPreparedStatements;
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
        this.filters = filters;
        this.connectionProperties = connectionProperties;
    }

    public DruidDataSouceConfig(String dbUrl, String username, String password, String driverClassName, Integer initialSize,
                                Integer minIdle, Integer maxActive, Integer maxWait, Integer timeBetweenEvictionRunsMillis, Integer minEvictableIdleTimeMillis,
                                String validationQuery, boolean testWhileIdle, boolean testOnBorrow, boolean testOnReturn, boolean poolPreparedStatements,
                                Integer maxPoolPreparedStatementPerConnectionSize, String filters, String connectionProperties ,
                                Boolean removeAbandoned , Integer removeAbandonedTimeout , Boolean logAbandoned) {
        
        this(dbUrl, username, password, driverClassName, initialSize,
        minIdle,  maxActive, maxWait, timeBetweenEvictionRunsMillis, minEvictableIdleTimeMillis,
        validationQuery, testWhileIdle, testOnBorrow, testOnReturn, poolPreparedStatements,
        maxPoolPreparedStatementPerConnectionSize, filters, connectionProperties);
        
        this.removeAbandoned = removeAbandoned;
        this.removeAbandonedTimeout = removeAbandonedTimeout;
        this.logAbandoned = logAbandoned;
    }

    /**
     * 数据源配置
     * @return
     */
    @Bean
    @Primary
    public DataSource _DruidDataSouce() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(PassWordUtils.getEnc(dbUrl));
        datasource.setUsername(PassWordUtils.getEnc(username));
        datasource.setPassword(PassWordUtils.getEnc(password));
        datasource.setDriverClassName(driverClassName);
        //configuration
        if(initialSize!=null&& initialSize>0) {
            datasource.setInitialSize(initialSize);
        }
        if(minIdle!=null&& minIdle>0) {
            datasource.setMinIdle(minIdle);
        }
        if(maxActive!=null && maxActive>0) {
            datasource.setMaxActive(maxActive);
        }
        if(maxWait!=null && maxWait>0) {
            datasource.setMaxWait(maxWait);
        }
        if(timeBetweenEvictionRunsMillis!=null && timeBetweenEvictionRunsMillis>0) {
            datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        }
        if(minEvictableIdleTimeMillis!=null && minEvictableIdleTimeMillis>0) {
            datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        }
        if(!StringUtils.isEmpty(validationQuery)) {
            datasource.setValidationQuery(validationQuery);
        }
        if(testWhileIdle) {
            datasource.setTestWhileIdle(testWhileIdle);
        }
        if(testOnBorrow) {
            datasource.setTestOnBorrow(testOnBorrow);
        }
        if(testOnReturn) {
            datasource.setTestOnReturn(testOnReturn);
        }
        if(poolPreparedStatements) {
            datasource.setPoolPreparedStatements(poolPreparedStatements);
        }
        if(maxPoolPreparedStatementPerConnectionSize!=null && maxPoolPreparedStatementPerConnectionSize>0) {
            datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        }
        if(!StringUtils.isEmpty(filters)) {
            try {
                datasource.setFilters(filters);
            } catch (SQLException e) {
                logger.error("druid configuration initialization filter", e);
            }
        }
        if(!StringUtils.isEmpty(connectionProperties)) {
            datasource.setConnectionProperties(connectionProperties);
        }
        if(removeAbandoned!=null) {
           datasource.setRemoveAbandoned(removeAbandoned); 
        }
        if(removeAbandonedTimeout!=null) {
            datasource.setRemoveAbandonedTimeout(removeAbandonedTimeout); 
        }
        if(logAbandoned!=null) {
            datasource.setLogAbandoned(logAbandoned); 
        }
        return datasource;
    }
    
}
