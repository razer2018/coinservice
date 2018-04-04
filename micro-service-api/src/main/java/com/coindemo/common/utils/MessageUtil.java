package com.coindemo.common.utils;

import java.util.Properties;

import com.coindemo.common.constants.Constants;


public class MessageUtil {
static Properties property = PropertiesUtils.getProperties(Constants.MESSAGE_FILE);
	
	/**
	 * 
	 * @param code  通过编码获取资源
	 * @return
	 */
	public static String getMessageByCode(String code) {
		 return property.getProperty(code);
	}
}
