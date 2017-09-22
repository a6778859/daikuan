package com.daikuan.until;

import java.util.Date;

/**
 * 系统常量
 * 
 */
public class Constants {

	public static final boolean TEST=true;

	public static final String TEL="6778869";

	// 非系统文件/图片 临时存放地址
	// public static final String TMPURL =
	// "D:\\usr\\local\\tomcat\\othertemp\\";
	public static final String TMPURL = "/usr/local/tomcat/othertemp/";
	// 系统自动充值返回日志路径
	//public static final String LOGROUTE = "/usr/local/tomcat/webapps/logs/zidongchognzhi" + DateUtil.getDateStrFromDate(new Date()) + ".txt";

	// 加密字段
	public static final String cKey = "923d5f7a90163457";
	// 手机
	public static final String REGEX_MOBILE = "(^0?(13|15|18|17)[0-9]{9}$)|(^0?(147)[0-9]{8}$)";
	// 座机
	public static final String REGEX_PHONE = "(^[0]\\d{2,3}\\-\\d{7,8})|(^[0]\\d{2,3}\\d{7,8})|(^[0-9]{3,8}$)";


}
