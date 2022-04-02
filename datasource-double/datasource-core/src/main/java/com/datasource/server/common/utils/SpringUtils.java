package com.datasource.server.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public SpringUtils() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> Map<String, T> getBeanOfType(Class<T> clazz) {
        return applicationContext.getBeansOfType(clazz);
    }

    public static String getProperty(String property) {
        return applicationContext.getEnvironment().getProperty(property);
    }

    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
        if (servletRequestAttributes == null) {
            return null;
        }
        return servletRequestAttributes.getRequest();
    }

    public static HttpServletResponse getResponse() {
        return getServletRequestAttributes().getResponse();
    }

    public static String getHeader(String headerKey) {
        if (StringUtils.isBlank(headerKey)) {
            return null;
        }

        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }

        return request.getHeader(headerKey);
    }


    /**
     * 获取String参数
     */
    public static String getParameter(String name) {
        return getParameter(name, null);
    }

    /**
     * 获取String参数
     */
    public static String getParameter(String name, String defaultValue) {
        String val = getRequest().getParameter(name);
        return StringUtils.defaultIfBlank(val, defaultValue);
    }
}
