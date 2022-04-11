package com.datasource.server.common.config;

import com.datasource.server.common.pojo.T_Datascore_Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatasourceSwitch {

	@Autowired
    protected DataSourceManager dataSourceManager;

	/**
	 * switchToConfigurationDataSource: 切换到配置的动态数据源--非默认数据源
	 * void
	*/
	public void switchToConfigurationDataSource() {
		T_Datascore_Config t_datascore_config = new T_Datascore_Config();
		dataSourceManager.addDataSource(t_datascore_config);
		System.out.println("切换新的数据源=============>");
        DynamicCustomerContextHolder.setContextKey(t_datascore_config.getType()+t_datascore_config.getId());
	}

	/**
	 * switchToSpecifiedDataSource: 切换到指定数据源；数据源由开发人员赋值 EcasEvnInfoPo 后传入
	 * @param evnInfo 动态数据源信息对象
	 * void
	*/
	public void switchToSpecifiedDataSource(EcasEnvInfoPo evnInfo) {
		T_Datascore_Config t_datascore_config = new T_Datascore_Config();
		dataSourceManager.addDataSource(t_datascore_config);
        DynamicCustomerContextHolder.setContextKey(evnInfo.getEnvNo());
	}
	
	/**
	 * switchToDefaultDataSource: 切换到默认数据源
	 * void
	*/
	public void switchToDefaultDataSource() {
		DynamicCustomerContextHolder.remove();
	}

	/**
	 * 根据
	 * @param key
	 */
	public void  switchDataSourceByKey(String key){
		DynamicCustomerContextHolder.setContextKey(key);
	}

}
