package com.daikuan.until;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/***
 * 时间处理
 * 
 * @author 彭军
 * 
 */
public class DateUtil {

	public static Date getDateFromString(String dateStr) {
		return getDateFromString(dateStr, null);
	}

	public static Date getDateFromString(String dateStr, String pattern) {
		if (pattern == null || "".equals(pattern)) {
			pattern = "yyyy-MM-dd";
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = format.parse(dateStr);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String getStrFromDate(Date date, String pattern) {
		java.text.DateFormat df = new SimpleDateFormat(pattern);
		String s = df.format(date);
		return s;
	}

	public static String getLongStrFromDate(Date date) {
		return getStrFromDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getDateStrFromDate(Date date) {
		return getStrFromDate(date, "yyyy-MM-dd");
	}

	/**
	 * 加减时间
	 * 
	 * @param date
	 * @param field
	 *            Calendar
	 * @param minutes
	 * @return
	 */
	public static Date optTime(Date date, int field, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 时间差 second - first 秒
	 * 
	 * @return
	 */
	public static int distanceSec(Date first, Date second) {
		Long sec = (second.getTime() - first.getTime()) / 1000;
		return sec.intValue();
	}

	/**
	 * 时间差 second - first 分
	 * 
	 * @return
	 */
	public static int distanceMin(Date first, Date second) {
		return distanceSec(first, second) / 60;
	}

	/**
	 * 时间差 second - first 时
	 * 
	 * @return
	 */
	public static int distanceHour(Date first, Date second) {
		return distanceMin(first, second) / 60;
	}

	/**
	 * 时间差 second - first 天
	 * 
	 * @return
	 */
	public static int distanceDay(Date first, Date second) {
		return distanceHour(first, second) / 24;
	}

	/**
	 * 一年中的第几天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfYesr(Date date) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		return c1.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 星期几
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfWeek(Date date) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		return c1.get(Calendar.DAY_OF_WEEK);
	}

	/***
	 * 根据日期获取一年中的第几周
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekofYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

	public static String getDayOfWeekStr(Date date) {
		int d = getDayOfWeek(new Date());
		String msg = null;
		switch (d) {
		case 1:
			msg = "星期天";
			break;
		case 2:
			msg = "星期一";
			break;
		case 3:
			msg = "星期二";
			break;
		case 4:
			msg = "星期三";
			break;
		case 5:
			msg = "星期四";
			break;
		case 6:
			msg = "星期五";
			break;
		case 7:
			msg = "星期六";
			break;
		default:
			break;
		}
		return msg;
	}

	/**
	 * 方法描述:与当前时间的间隔
	 * 
	 * @param date
	 *            必须不能大于当前时间
	 * @return
	 */
	public static String getTimeInterval(Date compDate) {
		long curTime = new Date().getTime();
		long compTime = compDate.getTime();
		double diffTime = (curTime - compTime) / 1000.0;
		if (diffTime >= 0) {
			if (diffTime / (60 * 60 * 24 * 30.0) > 1) {
				return "1月前";
			} else if (diffTime / (60 * 60 * 24 * 7.0) > 1) {
				return "7天前";
			} else if (diffTime / (60 * 60 * 24 * 7.0) <= 1 && diffTime / (60 * 60 * 24.0) >= 1) {
				return (int) diffTime / (60 * 60 * 24) + "天前";
			} else if (diffTime / (60 * 60 * 24.0) < 1 && diffTime / (60 * 60.0) >= 1) {
				return (int) diffTime / (60 * 60) + "小时前";
			} else if (diffTime < (60 * 60.0) && diffTime >= 60) {
				return (int) diffTime / 60 + "分钟前";
			} else {
				return "当前";
			}
		} else {
			// Assert.state(false, "比较时间不能大于当前时间");
			return "当前";
		}
	}

	/**
	 * 计算时间差 date1 < date2
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static String getOddTime(Date date1, Date date2) {
		StringBuilder result = new StringBuilder();
		int min = distanceMin(date1, date2);
		int hour = min / 60;
		int day = hour / 24;
		if (day > 0) {
			result.append(day).append("天").append(hour % 24).append("小时");
		} else {
			result.append(hour).append("小时").append(min % 60).append("分");
		}
		return result.toString();
	}

	/**
	 * 根据Date获取整型年份
	 * 
	 * @param d
	 * @return
	 */
	public static Integer getIntYear(Date d) {
		if (d == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int year = c.get(Calendar.YEAR);
		return year;
	}

	/**
	 * 根据Date取得Integer型的月份
	 * 
	 * @return
	 */
	public static Integer getIntMonth(Date d) {
		if (d == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int month = c.get(Calendar.MONTH) + 1; // Calendar的月从0 开始
		return month;
	}

	/**
	 * 根据Date获取整型 day
	 * 
	 * @param d
	 * @return
	 */
	public static Integer getIntDay(Date d) {
		if (d == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int day = c.get(Calendar.DAY_OF_MONTH);
		return day;
	}

	/***
	 * 获取两个整型日期之间的天数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static List<Date> betweenDate(Date beginDate, Date endDate) {
		Calendar c_begin = new GregorianCalendar();
		c_begin.set(getIntYear(beginDate), (getIntMonth(beginDate) - 1), getIntDay(beginDate));
		Calendar c_end = new GregorianCalendar();
		c_end.set(getIntYear(endDate), (getIntMonth(endDate) - 1), getIntDay(endDate));
		c_end.add(Calendar.DAY_OF_YEAR, 1); // 结束日期下滚一天是为了包含最后一天
		List<Date> dates = new ArrayList<Date>();
		while (c_begin.before(c_end)) {
			Date date = new java.sql.Date(c_begin.getTime().getTime());
			dates.add(date);
			c_begin.add(Calendar.DAY_OF_YEAR, 1);
		}
		return dates;
	}

	public static Date monthFirstDay(Date nowDate) {
		Calendar calendar = Calendar.getInstance();
		calendar = setCalendar(calendar, nowDate);
		Date sdate = calendar.getTime();
		return sdate;
	}

	public static Date monthLastDay(Date nowDate) {
		Calendar calendar = Calendar.getInstance();
		calendar = setCalendar(calendar, nowDate);
		calendar.add(Calendar.MONTH, 1);
		// 在当前月的下一月基础上减去1毫秒
		calendar.add(Calendar.MILLISECOND, -1);
		Date edate = calendar.getTime();
		return edate;
	}

	public static Calendar setCalendar(Calendar calendar, Date nowDate) {
		calendar.setTime(nowDate);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		// 将小时至0
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		// 将分钟至0
		calendar.set(Calendar.MINUTE, 0);
		// 将秒至0
		calendar.set(Calendar.SECOND, 0);
		// 将毫秒至0
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	/**
	 * 
	 * @param time1
	 *            比较时间
	 * @param time2
	 *            当前时间
	 * @return
	 */
	public static int checkTimeOut(Timestamp time1, Timestamp time2) {
		if (time1.getTime() > time2.getTime()) {
			return 1;
		} else {
			return 0;
		}

	}

	// public static int getDay(Date date) {
	// Calendar calendar = Calendar.getInstance();
	// calendar.setTime(date);
	// return calendar.get(Calendar.DATE);
	// }

	// public static int getMonth(Date date) {
	// Calendar calendar = Calendar.getInstance();
	// calendar.setTime(date);
	// return calendar.get(Calendar.MONTH) + 1;
	// }

}
