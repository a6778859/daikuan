package com.daikuan.until;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 公共工具类
 * 
 */
public class CommonUtil {

	private static final Log log = LogFactory.getLog(CommonUtil.class);

	/**
	 * 得到String的MD5码
	 * 
	 * @param srcString
	 *            将要加密码的字符串
	 * @return String 加密后的字符串
	 */
	public static String getMD5(String srcString) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(srcString.getBytes("UTF8"));
			byte s[] = md.digest();
			String result = "";
			for (int i = 0; i < s.length; i++) {
				result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
			}
			return result;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	/**
	 * 格式化文件大小
	 * 
	 * @param dataSize
	 * @return
	 */
	public static String formatDataSize(Long dataSize) {
		double byteSize = dataSize / 1024;
		String suffix = "KB";
		if (byteSize > 1000) {
			byteSize = byteSize / 1024;
			suffix = "MB";
		}
		DecimalFormat format = new DecimalFormat("0.00");
		if ("0.00".equals(format.format(byteSize))) {
			return "0.01KB";
		}
		return format.format(byteSize) + suffix;
	}

	/**
	 * 格式化数字
	 * 
	 * @param number
	 *            原数字
	 * @param fmt
	 *            格式 如 "0.00"
	 * @return
	 */
	public static String formatNumber(double number, String fmt) {
		DecimalFormat format = new DecimalFormat(fmt);
		return format.format(number);
	}

	/**
	 * 随机数
	 * 
	 * @param width
	 *            几位的
	 * @return
	 */
	public static String randomNum(int width) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < width; i++) {
			int n = new Random().nextInt(10);
			sb.append(n);
		}
		return sb.toString();
	}

	/** ================= 转换编码 ======================= **/
	public static String iso2utf8(String str) {
		try {
			return new String(str.getBytes("ISO8859-1"), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException ex) {
		}
		return false;
	}

	// public static String dateToStamp(String s) throws ParseException {
	// String res;
	// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	// Date date = simpleDateFormat.parse(s);
	// long ts = date.getTime();
	// res = String.valueOf(ts);
	// return res;
	// }
	//
	// public static Date stampToDate(String s) throws ParseException {
	// Date date = new Date();
	// DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// date = sdf.parse(s);
	// return date;
	//
	// }

	// 生成uuid
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号
		return s.substring(0, 8) + "-" + s.substring(9, 13) + "-" + s.substring(14, 18) + "-" + s.substring(19, 23) + "-" + s.substring(24);
	}

	public static String sendGet(String url, String coding) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("connection", "keep-alive");
			connection.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
			connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			connection.setRequestProperty("Cache-Control", "max-age=0");
			connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), coding));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			conn.setRequestProperty("Cache-Control", "max-age=0");
			conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);

			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 生成四位随机号码 配合
	 * 
	 * @return
	 */
	public static String getOrderid() {
		int x;// 定义两变量
		Random ne = new Random();// 实例化一个random的对象ne
		x = ne.nextInt(9999 - 1000 + 1) + 1000;
		return x + "";
	}

	// 四舍五入保留两位小数
	public static double formatDouble1(double f) {
		BigDecimal bg = new BigDecimal(f);
		return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 
	 * 取出指定的随机数
	 * 
	 * @param num
	 * @return
	 */
	public static String RecommendCode(int num) {
		String[] strs = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		int length = strs.length;
		for (int i = 0; i < num; i++) {
			sb.append(strs[r.nextInt(length)]);
		}
		return sb.toString();
	}

	/**
	 * 判断是否手机访问
	 * 
	 * @return
	 */

	/*
	 * public static String execute(HttpServletRequest request) { //
	 * HttpServletRequest request = ServletActionContext.getRequest(); boolean
	 * isMoblie = JudgeIsMoblie(request); if (isMoblie) { return "phone"; }
	 * return "pc"; }
	 */

	/*
	 * public static boolean JudgeIsMoblie(HttpServletRequest request) { boolean
	 * isMoblie = false; String[] mobileAgents = { "iphone", "android", "phone",
	 * "mobile", "wap", "netfront", "java", "opera mobi", "opera mini", "ucweb",
	 * "windows ce", "symbian", "series", "webos", "sony", "blackberry",
	 * "dopod", "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu",
	 * "midp", "cldc", "motorola", "foma", "docomo", "up.browser", "up.link",
	 * "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
	 * "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian",
	 * "ericsson", "philips", "sagem", "wellcom", "bunjalloo", "maui",
	 * "smartphone", "iemobile", "spice", "bird", "zte-", "longcos", "pantech",
	 * "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct",
	 * "320x320", "240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi",
	 * "audi", "avan", "benq", "bird", "blac", "blaz", "brew", "cell", "cldc",
	 * "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
	 * "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo",
	 * "midp", "mits", "mmef", "mobi", "mot-", "moto", "mwbp", "nec-", "newt",
	 * "noki", "oper", "palm", "pana", "pant", "phil", "play", "port", "prox",
	 * "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-",
	 * "shar", "sie-", "siem", "smal", "smar", "sony", "sph-", "symb", "t-mo",
	 * "teli", "tim-", "tsm-", "upg1", "upsi", "vk-v", "voda", "wap-", "wapa",
	 * "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
	 * "Googlebot-Mobile" }; if (request.getHeader("User-Agent") != null) { for
	 * (String mobileAgent : mobileAgents) { // <span class="comment" // style=
	 * "margin: 0px; padding: 0px; border: none; color: rgb(0, 130, 0); font-family: Consolas, 'Courier New', Courier, mono, serif; line-height: 18px;"
	 * >//这里本宝宝表示不怎么了解它的内部原理，但是知道个大概意思就得了。</span>
	 * 
	 * if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >=
	 * 0) { isMoblie = true; break; } } } //
	 * System.out.println(request.getHeader("User-Agent").toLowerCase()); return
	 * isMoblie; }
	 */
	public static String isAndroidOriphone(HttpServletRequest request) {
		if (request.getHeader("User-Agent") != null) {
			if (request.getHeader("User-Agent").toLowerCase().indexOf("iphone") >= 0) {
				return "IOS";
			} else if (request.getHeader("User-Agent").toLowerCase().indexOf("android") >= 0) {
				return "Android";
			} else {
				return "";
			}
		} else {
			return "";
		}
	}

	public static String getRealIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP") + "";
		if (!StringUtil.isBlank(ip) && ip.contains(",")) {
			String[] ips = ip.split(",");
			ip = ips[ips.length - 1];
		}
		if (!StringUtil.isBlank(ip)) {
			if (ip.length() > 40) {
				ip = ip.substring(0, 40);
			}
		}
		return ip;
	}

	// 四舍五入doutb=》int
	public static Integer double_int(double d) {
		DecimalFormat df = new DecimalFormat("######0"); // 四色五入转换成整数
		return Integer.parseInt(df.format(d));
	}



	/**
	 * 
	 * 取出指定的随机数
	 * 
	 * @param num
	 * @return
	 */
	public static String RecommendCode2(int num) {
		String[] strs = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		int length = strs.length;
		for (int i = 0; i < num; i++) {
			sb.append(strs[r.nextInt(length)]);
		}
		return sb.toString();
	}

	public static String formatDouble4(double d) {
		DecimalFormat df = new DecimalFormat("0.000");

		return df.format(d);
	}

	/**
	 * 是否是即刻充值
	 */
	public static boolean isImmediately(String remark) {
		String[] isImmediately = remark.split(",");
		if (isImmediately[1] != null && isImmediately[1].equals("1")) {
			return true;
		} else {
			return false;
		}
	}
}
