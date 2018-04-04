package com.coindemo.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {

	public static final String MOBILE = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(147))\\d{8}$";

	public static final String EMAIl = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

	public static final String PASSWORD = "^[0-9a-zA-Z@\\-_*%#]{6,20}$";
	

	public static final String NICKNAME = "^[0-9a-zA-Z_-]{6,}$";

	public static final String ENV_NAME = "^[A-Za-y0-9\\u4e00-\\u9fa5]{5,}$";

	public static final String CODE_NAME = "^[0-9a-zA-Z_-]{5,}$";

	public static final String IS_CE = "^[\u4e00-\u9fa5a-zA-Z][\u4e00-\u9fa5a-zA-Z_][\u4e00-\u9fa5a-zA-Z\\d][\u4e00-\u9fa5a-zA-Z\\d_]+$";

	public static final String IS_ZM = "^[\u9fa5a-zA-Z][\u9fa5a-zA-Z\\d\\.\\_\\-]+$";
	
	public static final String SG_NAME = "^[\\W\\w]{2,128}$";
	
	public static final String URL = "^(?!(http://|https://)).+$";
	
	public static final String ID_NUM = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";

	// 验证手机号
	public static boolean matchesMobile(String mobile) {
		Pattern p = Pattern.compile(MOBILE);
		Matcher m = p.matcher(mobile);
		return m.matches();
	}

	// 验证邮箱
	public static boolean matchesEmail(String email) {
		Pattern p = Pattern.compile(EMAIl);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	// 验证密码
//	public static boolean matchesPassword(String password) {
//		Pattern p = Pattern.compile(PASSWORD);
//		Matcher m = p.matcher(password);
//		return m.matches();
//	}
	public static boolean matchesPassword(String pass){
    	if(pass.length() < 6 && pass.length() > 20){
    		return false;
    	}
        Pattern p1= Pattern.compile("[a-z]+");
        Pattern p2= Pattern.compile("[A-Z]+");
        Pattern p3= Pattern.compile("[0-9]+");
        Matcher m=p1.matcher(pass);
        if(!m.find())
            return false;
        else{
            m.reset().usePattern(p2);
            if(!m.find())
                return false;
            else{
                m.reset().usePattern(p3);
                if(!m.find())
                    return false;
                else{
                    return true;
                }
            }
        }
	}

	// 验证账号
	public static boolean matchesNickName(String nickName) {
		Pattern p = Pattern.compile(NICKNAME);
		Matcher m = p.matcher(nickName);
		return m.matches();
	}

	public static boolean matchesEnvName(String envName) {
		Pattern p = Pattern.compile(ENV_NAME);
		Matcher m = p.matcher(envName);
		return m.matches();
	}

	public static boolean matchesCodeName(String codeName) {
		Pattern p = Pattern.compile(CODE_NAME);
		Matcher m = p.matcher(codeName);
		return m.matches();
	}

	// 验证是否是中文或英文
	public static boolean matchesIsCECode(String codeName) {
//		非法的交换机名称！必须以中文或英文字母开头，可包含数字！
		char c = codeName.charAt(0); 
		if(isEnglishWord(c) || isChinese(c)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isEnglishWord(char c) {
		int i = (int) c;
		if ((i >= 65 && i <= 90) || (i >= 97 && i <= 122)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isChinese(char c) {
	      return c >= 0x4E00 &&  c <= 0x9FA5;// 根据字节码判断
	}

	public static boolean matchesIsZMCode(String codeName) {
		Pattern p = Pattern.compile(IS_ZM);
		Matcher m = p.matcher(codeName);
		return m.matches();
	}
	
	// 校验安全组长度
	public static boolean matchesSgNameLength(String codeName) {
		Pattern p = Pattern.compile(SG_NAME);
		Matcher m = p.matcher(codeName);
		return m.matches();
	}
	
	// 校验是否已http/https开头
	public static boolean matchesUrl(String codeName) {
		Pattern p = Pattern.compile(URL);
		Matcher m = p.matcher(codeName);
		return m.matches();
	}
	
	public static boolean matchsRepositoryName(String repositoryName){
    	if(repositoryName.length() < 8 && repositoryName.length() > 30){
    		return false;
    	}
        Pattern p1= Pattern.compile("[a-z]+");
        Pattern p2= Pattern.compile("[A-Z]+");
        Pattern p3= Pattern.compile("[0-9]+");
        Matcher m1 = p1.matcher(repositoryName);
        Matcher m2 = p2.matcher(repositoryName);
        Matcher m3 = p3.matcher(repositoryName);
        if((!m1.find() && !m2.find() && !m3.find())){
        	return false;
        }else{
        	String passStartWord = repositoryName.substring(0,1);
        	m1 = p1.matcher(passStartWord);
        	if(!m1.find()){
        		return false;
        	}
        	return true;
        }
	}	
	
	
	/**
	 * 功能：验证字符串长度是否符合要求，一个汉字等于两个字符
	 * 
	 * @param strParameter
	 *            要验证的字符串
	 * @param limitLength
	 *            验证的长度
	 * @return 符合长度ture 超出范围false
	 */
	public static boolean validateStrByLength(String strParameter, int limitLength) {
		int temp_int = 0;
		byte[] b = strParameter.getBytes();

		for (int i = 0; i < b.length; i++) {
			if (b[i] >= 0) {
				temp_int = temp_int + 1;
			} else {
				temp_int = temp_int + 2;
				i++;
			}
		}

		if (temp_int > limitLength) {
			return false;
		} else {
			return true;
		}
	}
	
	// 验证身份证号
	public static boolean matchesIdNum(String idNum) {
		Pattern p = Pattern.compile(ID_NUM);
		Matcher m = p.matcher(idNum);
		return m.matches();
	}
	
	public static boolean matchsUrlHostPasswd(String pass){
    	if(pass.length() < 8 && pass.length() > 30){
    		return false;
    	}
        Pattern p1= Pattern.compile("[a-z]+");
        Pattern p2= Pattern.compile("[A-Z]+");
        Pattern p3= Pattern.compile("[0-9]+");
        Matcher m=p1.matcher(pass);
        if(!m.find())
            return false;
        else{
            m.reset().usePattern(p2);
            if(!m.find())
                return false;
            else{
                m.reset().usePattern(p3);
                if(!m.find())
                    return false;
                else{
                    return true;
                }
            }
        }
	}	
	
	/**
	 * 判断是否输入字符串是否只含有大写字母
	 * @param s
	 * @return
	 */
	public static boolean isLower(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!Character.isUpperCase(c)) {
				return false;
			}
		}
		return true;
	}
}
