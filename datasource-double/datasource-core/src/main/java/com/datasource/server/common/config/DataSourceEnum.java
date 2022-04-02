package com.datasource.server.common.config;

/**
 * @author yangxd
 * @descriptions
 * @date 2020年08月25日
 */
public enum  DataSourceEnum {

    /**
     * default。防止报错
     */
    DEFAULT("",""),
    /**
     * mysql
     */
    MYSQL("mysql","com.mysql.cj.jdbc.Driver"),
    /**
     * oracle
     */
    ORACLE("oracle","oracle.jdbc.driver.OracleDriver"),
    /**
     * postgresql
     */
    POSTGRESQL("postgresql","org.postgresql.Driver"),
    /**
     * sqlserver
     */
    SQLSERVER("sqlserver","com.microsoft.sqlserver.jdbc.SQLServerDriver");


    private String dbType;
    private String driverClass;

    DataSourceEnum(String dbType, String driverClass) {
        this.dbType = dbType;
        this.driverClass = driverClass;
    }


    public String getDbType() {
        return dbType;
    }


    public void setDbType(String dbType) {
        this.dbType = dbType;
    }


    public String getDriverClass() {
        return driverClass;
    }


    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }


    public static DataSourceEnum getEnum(String dbType) {
        for (DataSourceEnum dataSourceEnum : DataSourceEnum.values()) {
            if (dataSourceEnum.getDbType().equals(dbType)) {
                return dataSourceEnum;
            }
        }
        return DEFAULT;
    }
}
