package com.datasource.server.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class EcasEnvInfoPo {
	
	private static final long serialVersionUID = 1L;


	/**
     * envNo       db_column: ENV_NO 
     */
	private String envNo;
    /**
     * datasourceAddress       db_column: DATASOURCE_ADDRESS 
     */
	private String datasourceAddress;
    /**
     * datasourceType       db_column: DATASOURCE_TYPE 
     */
	private String datasourceType;
    /**
     * datasourceDriver       db_column: DATASOURCE_DRIVER 
     */
	private String datasourceDriver;
    /**
     * datasourceUserName       db_column: DATASOURCE_USER_NAME 
     */
	private String datasourceUserName;
    /**
     * datasourcePassword       db_column: DATASOURCE_PASSWORD 
     */
	private String datasourcePassword;

	
	
	public String getEnvNo() {
		return this.envNo;
	}
	
	public void setEnvNo(String value) {
		this.envNo = value;
	}
	
	public String getDatasourceAddress() {
		return this.datasourceAddress;
	}
	
	public void setDatasourceAddress(String value) {
		this.datasourceAddress = value;
	}
	
	
	public String getDatasourceType() {
		return this.datasourceType;
	}
	
	public void setDatasourceType(String value) {
		this.datasourceType = value;
	}
	
	
	public String getDatasourceDriver() {
		return this.datasourceDriver;
	}
	
	public void setDatasourceDriver(String value) {
		this.datasourceDriver = value;
	}
	
	
	public String getDatasourceUserName() {
		return this.datasourceUserName;
	}
	
	public void setDatasourceUserName(String value) {
		this.datasourceUserName = value;
	}
	
	
	public String getDatasourcePassword() {
		return this.datasourcePassword;
	}
	
	public void setDatasourcePassword(String value) {
		this.datasourcePassword = value;
	}
}

