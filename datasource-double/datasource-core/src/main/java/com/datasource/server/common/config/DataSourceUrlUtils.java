package com.datasource.server.common.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;

/**
 * @author liuwuzhou
 * @descriptions
 * @date 2020年08月26日
 */
@Slf4j
public class DataSourceUrlUtils {

    private static String URL_PRE = "jdbc";

    private static String getMysqlUrl(String url) {
        if (!url.startsWith(URL_PRE)) {
            url = "jdbc:mysql://" + url;
        }

        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }

        if (url.split("\\?").length < 2) {
            url = url + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Hongkong";
        } else if (!url.contains("serverTimezone")) {
            url = url + "&serverTimezone=HongKong";
        }
        return url;
    }

    private static String getOracleUrl(String url) {
        if (!url.startsWith(URL_PRE)) {
            url = "jdbc:oracle:thin:@" + url;
        }

        return url;
    }

    private static String getPostgreSqlUrl(String url) {
        if (!url.startsWith(URL_PRE)) {
            url = "jdbc:postgresql://" + url;
        }
        return url;
    }


    private static String getSqlServerUrl(String url) {
        if (!url.startsWith(URL_PRE)) {
            url = "jdbc:sqlserver://" + url;
        }
        return url;
    }


    /**
     * 根据数据库类型获取对应数据库需要的连接地址。
     * @param datasourceType
     * @param datasourceAddress
     * @return
     */
    public static String getUrl(String datasourceType, String datasourceAddress) {
        switch (DataSourceEnum.getEnum(datasourceType)) {
        case MYSQL:
            return getMysqlUrl(datasourceAddress);
        case SQLSERVER:
            return getSqlServerUrl(datasourceAddress);
        case POSTGRESQL:
            return getPostgreSqlUrl(datasourceAddress);
        case ORACLE:
            return getOracleUrl(datasourceAddress);
        default:
            return datasourceAddress;
        }
    }


    /**
     * 如果驱动类为空或有明显错误，根据数据库类型获取默认驱动类。
     * @param type
     * @param driver
     * @return
     */
    public static String getDriver(String type, String driver) {
        if (StringUtils.isNotBlank(driver) && driver.contains("Driver")){
            return driver;
        }
        DataSourceEnum dataSourceEnum = DataSourceEnum.getEnum(type);
        if (!DataSourceEnum.DEFAULT.equals(dataSourceEnum)){
            return dataSourceEnum.getDriverClass();
        }
        return driver;
    }


    /**
     * 检查数据库连接是否可用
     * @param type
     * @param url
     * @param userName
     * @param passwd
     * @param driver
     * @return
     */
    public static boolean testUrl(String type, String url, String userName, String passwd, String driver) {
        Connection connection = null;
        // 预执行加载
        PreparedStatement preparedStatement = null;
        // 结果集
        ResultSet resultSet = null;
        String result = null;
        try {
            connection = getConnection(type, url, userName, passwd, driver);
            String sqlString = "select 1 from dual";

            preparedStatement = connection.prepareStatement(sqlString);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getString(1);
                return "1".equals(result);
            }
        } catch (Exception e) {
            log.error("测试连接失败！", e);
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                log.error("", e);
            }
        }
        return true;
    }


    private static Connection getConnection(String type, String url, String userName,String passwd, String driver) throws Exception{
        // 定义连接
        Connection connection = null;

        // 加载驱动
        Class.forName(getDriver(type, driver));
        connection = DriverManager.getConnection(getUrl(type, url), userName, passwd);
        return connection;
    }


}
