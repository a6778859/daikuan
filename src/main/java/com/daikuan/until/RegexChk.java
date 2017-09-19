package com.daikuan.until;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * 
 * @author admin
 * 
 */
public class RegexChk {

	public static boolean startCheck(String reg, String string) {
		boolean tem = false;

		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(string);

		tem = matcher.matches();
		return tem;
	}

	/**
	 * 是否全是字母
	 * 
	 * @param letter
	 * @return
	 */
	public static boolean checkLetter(String letter) {
		String reg = "^[A-Za-z]+$";
		return startCheck(reg, letter);
	}

	/***
	 * 检验正整数
	 * 
	 * @param letter
	 * @return
	 */
	public static boolean checkNum(String letter) {
		String reg = "^[0-9]+$";
		return startCheck(reg, letter);
	}

	/**
	 * 检验整数,适用于正整数、负整数、0，负整数不能以-0开头, 正整数不能以0开头
	 * 
	 * */
	public static boolean checkNr(String nr) {
		String reg = "^(-?)[1-9]+\\d*|0";
		return startCheck(reg, nr);
	}

	/**
	 * 手机号码验证,11位，不知道详细的手机号码段，只是验证开头必须是1和位数
	 * */
	public static boolean checkCellPhone(String cellPhoneNr) {
		if (StringUtil.isBlank(cellPhoneNr)) {
			return false;
		}
		String reg = Constants.REGEX_MOBILE;
		return startCheck(reg, cellPhoneNr);
	}

	/**
	 * 检验空白符
	 * */
	public static boolean checkWhiteLine(String line) {
		String regex = "(\\s|\\t|\\r)+";

		return startCheck(regex, line);
	}

	/**
	 * 检查EMAIL地址 用户名和网站名称必须>=1位字符
	 * 地址结尾必须是以com|cn|com|cn|net|org|gov|gov.cn|edu|edu.cn结尾
	 * */
	public static boolean checkEmailWithSuffix(String email) {
		String regex = "\\w+\\@\\w+\\.(com|cn|com.cn|net|org|gov|gov.cn|edu|edu.cn)";
		return startCheck(regex, email);
	}

	/**
	 * 检查EMAIL地址 用户名和网站名称必须>=1位字符 地址结尾必须是2位以上，如：cn,test,com,info
	 * */
	public static boolean checkEmail(String email) {
		String regex = "\\w+\\@\\w+\\.\\w{2,}";
		return startCheck(regex, email);
	}

	/**
	 * 检查邮政编码(中国),6位，第一位必须是非0开头，其他5位数字为0-9
	 * */
	public static boolean checkPostcode(String postCode) {
		String regex = "^[1-9]\\d{5}";
		return startCheck(regex, postCode);
	}

	/**
	 * 检验用户名 取值范围为a-z,A-Z,0-9,"_",汉字，不能以"_"结尾 用户名有最小长度和最大长度限制，比如用户名必须是4-20位
	 * */
	public static boolean checkUsername(String username, int min, int max) {
		String regex = "[\\w\u4e00-\u9fa5]{" + min + "," + max + "}(?<!_)";
		return startCheck(regex, username);
	}

	/**
	 * 检验用户名 取值范围为a-z,A-Z,0-9,"_",汉字，不能以"_"结尾 有最小位数限制的用户名，比如：用户名最少为4位字符
	 * */
	public static boolean checkUsername(String username, int min) {
		// [\\w\u4e00-\u9fa5]{2,}?
		String regex = "[\\w\u4e00-\u9fa5]{" + min + ",}(?<!_)";
		return startCheck(regex, username);
	}

	/**
	 * 检验用户名 取值范围为a-z,A-Z,0-9,"_",汉字 最少一位字符，最大字符位数无限制，不能以"_"结尾
	 * */
	public static boolean checkUsername(String username) {
		String regex = "[\\w\u4e00-\u9fa5]+(?<!_)";
		return startCheck(regex, username);
	}

	/**
	 * 查看IP地址是否合法
	 * */
	public static boolean checkIP(String ipAddress) {
		String regex = "(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\." + "(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\." + "(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\." + "(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])";
		return startCheck(regex, ipAddress);
	}

	/**
	 * 验证国内电话号码 格式：010-67676767，区号长度3-4位，必须以"0"开头，号码是7-8位
	 * */
	public static boolean checkPhoneNr(String phoneNr) {
		String regex = Constants.REGEX_PHONE;
		return startCheck(regex, phoneNr);
	}

	/**
	 * 验证国内电话号码 格式：6767676, 号码位数必须是7-8位,头一位不能是"0"
	 * */
	public static boolean checkPhoneNrWithoutCode(String phoneNr) {
		String reg = "^[1-9]\\d{6,7}";
		return startCheck(reg, phoneNr);
	}

	/**
	 * 验证国内电话号码 格式：1开头的11位号
	 * */
	public static boolean checkPhoneNrWithoutLine(String phoneNr) {
		String reg = "^[1]\\d{10}";
		return startCheck(reg, phoneNr);
	}

	/**
	 * 验证国内身份证号码：15或18位，由数字组成，不能以0开头
	 * */
	public static boolean checkIdCard(String idNr) {
		String reg = "^[1-9](\\d{14}|\\d{17})";
		return startCheck(reg, idNr);
	}

	/**
	 * 网址验证<br>
	 * 符合类型：<br>
	 * http://www.test.com<br>
	 * http://163.com
	 * */
	public static boolean checkWebSite(String url) {
		// http://www.163.com
		String reg = "^(http)\\://(\\w+\\.\\w+\\.\\w+|\\w+\\.\\w+)";
		return startCheck(reg, url);
	}

	/** ====================== 提取信息 ============================= **/

	public final static String REG_NUM = "\\D*?(\\d+)";

	/**
	 * 提取数字
	 * 
	 * @param str
	 * @return
	 */
	public static String getNum(String str) {
		return getValueOnly(str, REG_NUM);
	}

	public static List<String> getNumList(String str) {
		return getValue(str, REG_NUM);
	}

	/**
	 * 提取信息
	 * 
	 * @param str
	 * @param reg
	 * @return
	 */
	public static List<String> getValue(String str, String reg) {
		return getValue(str, reg, 1);
	}

	/**
	 * 提取信息
	 * 
	 * @param str
	 * @param reg
	 * @return
	 */
	public static List<String> getValue(String str, String reg, int i) {
		List<String> dataList = new ArrayList<String>();
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		String res = "";
		while (m.find()) {
			res = m.group(i);
			dataList.add(res);
		}
		return dataList;
	}

	/**
	 * 提取信息 第一条
	 * 
	 * @param str
	 * @param reg
	 * @return
	 */
	public static String getValueOnly(String str, String reg) {
		List<String> dataList = getValue(str, reg);
		if (dataList.size() > 0) {
			return dataList.get(0);
		}
		return "";
	}

	public static int matchesPhoneNumber(String phone_number) {
		if (StringUtil.isBlank(phone_number)) {
			return 0;
		}

		String cm = "^((13[4-9])|(147)|(15[0-2,7-9])|(18[2-3,7-8]))\\d{8}$";
		String cu = "^((13[0-2])|(145)|(15[5-6])|(186))\\d{8}$";
		String ct = "^((133)|(153)|(18[0,9]))\\d{8}$";

		int flag = 0;
		if (phone_number.matches(cm)) {
			// 移动
			flag = 1;
		} else if (phone_number.matches(cu)) {
			// 联通
			flag = 2;
		} else if (phone_number.matches(ct)) {
			// 电信
			flag = 3;
		} else {
			flag = 0;
		}
		return flag;

	}

	public static String whichOperator(int x) {
		switch (x) {
		case 1:
			return "中国移动";
		case 2:
			return "中国联通";
		case 3:
			return "中国电信";
		}
		return "";
	}
}
