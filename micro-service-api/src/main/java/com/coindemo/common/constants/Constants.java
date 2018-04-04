package com.coindemo.common.constants;

import java.math.BigDecimal;

public class Constants {
	// 注册时候与ssoserver通讯时加密解密的密钥
	public final static String SECRET_KEY = "2B4eWxHdTaWPRGnN";

	public final static String SESSION_USER_KEY = "galax_session_user";
	
	

	public final static String SESSION_ID_KEY = "sessionId";

	public final static String REQUEST_HEADER_USER_ID_KEY = "guserId";

	

	public final static String SESSOPM_SID_KEY = "sid";

	public final static String REQUEST_URL_USER_ID_KEY = "guid";
	
	public final static String ROOT_PATH = "/";

	public final static String LOGIN_LOGIN = "/login";

	public final static String STATIC_PAGE = "/static/";

	public final static String IS_UP_EMPTY = "0";

	public final static String IS_UP_WRONG = "1";

	public final static String IS_SESSIONID_EMPTY = "2";

	public final static String IS_SESSIONID_EXPIRED = "3";

	public final static String OPTION_SUCCESS = "4";

	public final static String ACCESS_REJECTED = "5";

	public final static String REQUEST_PARAMS_INCOMPLETE = "6";// 请求参数不完整

	public final static String USER_DISABLE = "7"; // 用户被禁用

	public final static String INVALID_SESSIONID = "8"; // sessionId不正确

	public final static int DEFAULT_PAGE_SIZE = 15;

	// mail相关
	public final static String MAIL_CONFIG_FILE = "mail.properties";
	public final static String MAIL_HOST_KEY = "mail.host";
	public final static String MAIL_ADDRESS_KEY = "mail.address";
	public final static String MAIL_USERNAME_KEY = "mail.username";
	public final static String MAIL_PASSWORD_KEY = "mail.password";
	public final static String MAIL_SMTP_AUTH_KEY = "mail.smtp.auth";
	public final static String MAIL_SMTP_TIMEOUT_KEY = "mail.smtp.timeout";
	public final static String MAIL_SMTP_PORT_KEY = "mail.smtp.port";

	public final static String HEADER_REFERER_KEY = "galaxy.header.referer";
	public final static String SAFE_CONFIG_FILE = "core-config.properties";

	public final static String TOKEN_REMOVE_KEY = "token_remove";
	public final static String REDIS_CACHE_BEAN_NAME = "cache";
	public final static String REQUEST_SCOPE_TOKEN_KEY = "galax_requestscope_token_id";
	public final static int TOKEN_IN_REDIS_TIMEOUT_SECONDS = 60 * 60;// 1小时

	public final static String REDIS_SHARDINFO_NAME = "jedis.shardInfo";
	// 邮箱后缀名
	public static final String MAIL_SUFFIX = "@galaxyinternet.com";

	public static final String MAIL_TEMPLATE_FILE = "mail-template.properties";
	
	// 催办模板
	public static final String MAIL_URGE_CONTENT = "mail.urge.content";

	// 催办模板
	public static final String MAIL_URGE_CONTENT_SPECIAL = "mail.urge.content.special";
	// 重置密码模板
	public static final String MAIL_RESTPWD_CONTENT = "mail.restPwd.content";
	public static final String MAIL_INITIALPWD_CONTENT = "mail.initialPwd.content";
	// 共享文件模板
	public static final String MAIL_FILESHARE_CONTENT = "mail.fileShare.content";

	public static final Long UNIT_LONG = new Long(1);
	
	public static final Long DISPOSABLE_PERIOD = 7258003200L;
	
	public static final Long SERVICE_MONTH = 2592000000L;
	
	public static final int GET_ZERO = 0;
	
	public static final BigDecimal UNIT_DISCOUNT = new BigDecimal(10);
	
	public static final BigDecimal ZERO_BIGDECIMAL = new BigDecimal(0);
	
	public static final String GET_DISPOSABLE_PERIOD = "永久";
	
	public static final Long SECOND_UNIT_DAY = new Long(86400000l);
	
	public static final int MINUS_SEVEN = -7;
	
	public static final Long ZERO_LONG = new Long(0);
	
	public static final String REQUEST_TERMINAL_MARK = "gt";// galaxinternet  terminal

	public static final String AJAX_REQUEST_CORE_OBJECT_NAME = "XMLHttpRequest";

	public static final String REQUEST_HEADER_MARK = "X-Requested-With";

	public static final String EXCLUDE_REQUEST_URL = "excludedUrl";

	public static final String INCLUED_REQUEST_URL = "incluedUrl";
	
	public static final String INCLUED_ALL_REQUEST_URL = "*";

	public static final String DECRYP_ENCRYPTION_MARK = "decrypEncryption";
		
	//短信模版
	public static final String SMS_TEMPLATE_FILE = "sms-notice-message.properties";
	public static final String SMS_TEMPLATE_ONENUM_KEY = "one-instance-expired";
	public static final String SMS_TEMPLATE_MORENUM_KEY = "more-instance-expired";
	
	public static final String MESSAGE_FILE = "message.properties";

	public static final String CACHE_PREFIX_DICT = "dict:";
	public static final String CACHE_PREFIX_SMS = "sms:";
	public static final String CACHE_PREFIX_SMS_PASSWORD = "sms_password:";
	public static final String SESSION_SMS_PHONE_KEY = "sms_phone";
	public static final String SESSION_SMS_VERIFY_CODE_KEY = "sms_verify_code";
	public static final String SESSION_SMS_VERIFY_CODE_KEY_PASSWORD = "sms_verify_passcode";

	public static final String REQUIREMENT_QUERY = "REQUIREMENT_QUERY";

	public static final String START = "开始";
	
	public static final String ACCOMPLISH = "完成";
	
	public static final String APPROVAL = "核准";
	
	public static final String APPOINT = "指派";
	
	public static final String NEWBUILT = "新建";
	
	public static final String CLOSED = "关闭";
	
	
	public static final String CALCULATE_REFLECT_PACKAGE = "com.galaxyinternet.api.pulic.price.service.impl";
	
	public static final String REPEAT_PASSWORD_KEY = "backpasswordUserId:";
	
	public static final String REPEAT_PHONE_KEY = "sms_phone:";
	
	
	public static final String HYBRID_USER_IMPORT_KEY = "hybrid_user_import_key";
	
	public static final String KEY_UNIT_PRICE_LIST = "unitPriceList";
	
	public static final String KEY_TOTAL_PRICE_LIST = "totalPriceList";
	
	public static final String QUERY_CLOUD_PRICE = "com.galaxyinternet.api.hybrid.price.service.impl";
	
	public static final String MALL_CALCULATE_REFLECT_PACKAGE = "com.galaxyinternet.api.price.service.impl";

	
}
