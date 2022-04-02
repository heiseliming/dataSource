package com.datasource.server.common.config;

public class DynamicCustomerContextHolder {
    public static final String DEFAULT = "_DruidDataSouceDefault";
    private static final ThreadLocal<String> CONTEXT_HODLER = new InheritableThreadLocal<>();

    public static void setContextKey(String key) {
        CONTEXT_HODLER.set(key);
    }

    /**
     * 获取数据源名称
     */
    public static String getContextKey() {
        String key = CONTEXT_HODLER.get();
        return key == null ? DEFAULT : key;
    }


    /**
     * 清除线程变量
     */
    public static void remove() {
        CONTEXT_HODLER.remove();
    }

}