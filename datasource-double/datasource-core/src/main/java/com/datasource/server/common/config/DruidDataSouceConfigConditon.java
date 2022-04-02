package com.datasource.server.common.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

/**
 * 加载数据源选项
 */
@Configuration
public class DruidDataSouceConfigConditon implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment=conditionContext.getEnvironment();
        String ha=environment.getProperty("db.datasource.url");
        if(StringUtils.isEmpty(ha)){
            return false;
        }else{
            return true;
        }
    }
}
