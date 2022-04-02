package com.datasource.server.common.utils;

public enum ResultEnum {
	
	/**
	 * 成功
	 */
	SUCCESS(200, "SUCCESS");




    private int code;
    private String message;

    public int getCode()
    {
        return code;
    }
    
    public String getMessage() {
		return message;
	}

	ResultEnum(int code, String message)
    {
        this.code = code;
        this.message = message;
    }
}
