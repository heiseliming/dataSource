package com.datasource.server.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatasourceSwitch {
	
	@Autowired
    EcasEnvInfoPo ecasEnvInfoPo;
	@Autowired
    protected DataSourceManager dataSourceManager;

	/**
	 * switchToConfigurationDataSource: 切换到配置的动态数据源--非默认数据源
	 * void
	*/
	public void switchToConfigurationDataSource() {
		dataSourceManager.addDataSource(ecasEnvInfoPo);
		System.out.println("切换新的数据源=============>");
        DynamicCustomerContextHolder.setContextKey(ecasEnvInfoPo.getEnvNo());
	}

	/**
	 * switchToSpecifiedDataSource: 切换到指定数据源；数据源由开发人员赋值 EcasEvnInfoPo 后传入
	 * @param evnInfo 动态数据源信息对象
	 * void
	*/
	public void switchToSpecifiedDataSource(EcasEnvInfoPo evnInfo) {
		dataSourceManager.addDataSource(evnInfo);
        DynamicCustomerContextHolder.setContextKey(evnInfo.getEnvNo());
	}
	
	/**
	 * switchToDefaultDataSource: 切换到默认数据源
	 * void
	*/
	public void switchToDefaultDataSource() {
		DynamicCustomerContextHolder.remove();
	}

}
