package com.daikuan.until;

/**
 * 处理各种返回的字符串
 * 
 * @author Administrator
 * 
 */
public class ResultMsg {
	/**
	 * 欧飞充值返回
	 * 
	 * @param result
	 * @return
	 */
	public static String phoneMessage(String result) {
		String fuel_msg = "";
		if (!StringUtil.isBlank(result)) {
			String err_msg = RegexChk.getValueOnly(result, "message=([\\s\\S]*?),");

			if ("成功".equals(err_msg)) {
				fuel_msg="";
			} else {
				fuel_msg = "失败" + err_msg;
			}
		} else {
			fuel_msg = "短信发送失败";
		}
		if (!StringUtil.isBlank(fuel_msg) && fuel_msg.length() > 20) {
			fuel_msg = fuel_msg.substring(0, 20);
		}

		return fuel_msg;
	}



}
