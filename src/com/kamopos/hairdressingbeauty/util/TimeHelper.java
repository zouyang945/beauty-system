package com.kamopos.hairdressingbeauty.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间帮助类
 * 
 * @author
 */
public class TimeHelper {

	/**
	 * 缺省的日期显示格式： yyyy/MM/dd
	 */
	public static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd";

	/**
	 * 英文日期缺省的日期显示格式： MM/dd/yyyy
	 */
	public static final String DEFAULT_DATE_FORMAT_EN = "MM/dd/yyyy";

	/**
	 * <code>DEFAULT_PAGE_TIME_FORMAT</code> - 中英文时间显示格式
	 */
	public static final String DEFAULT_PAGE_TIME_FORMAT = "HH:mm:ss";

	/**
	 * 缺省的日期时间显示格式：yyyy/MM/dd HH:mm
	 */
	public static final String DEFAULT_DATETIME_FORMAT = "yyyy/MM/dd HH:mm";

	/**
	 * 英文缺省的日期时间显示格式：MM/dd/yyyy HH:mm
	 */
	public static final String DEFAULT_DATETIME_FORMAT_EN = "HH:mm MM dd,yyyy ";

	/**
	 * 缺省的日期时间显示格式：yyyy/MM/dd HH:mm:ss
	 */
	public static final String DEFAULT_DATETIME_14_FORMAT = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 英文缺省的日期时间显示格式：yyyy-MM-dd HH:mm:ss
	 */
	public static final String DEFAULT_DATETIME_14_FORMAT_EN = "MM/dd/yyyy HH:mm:ss";

	/**
	 * 后台业务层用到的日期时间格式:yyyyMMddHHmm
	 */
	public static final String DEFAULT_PAGE_FORMAT = "yyyyMMddHHmm";

	/**
	 * 后台业务层用到的日期时间格式:yyyyMMddHH
	 */
	public static final String DEFAULT_DATE_FORMAT_HOUR = "yyyyMMddHH";

	/**
	 * 后台业务层用到的日期时间格式:yyyyMMddHHmmss
	 */
	public static final String DEFAULT_PAGE_14_FORMAT = "yyyyMMddHHmmss";

	/**
	 * 后台业务层用到的时间格式:HHmmss
	 */
	public static final String DEFAULT_SYSTEM_TIME_FORMAT = "HHmmss";

	/**
	 * 后台业务层用到的日期格式:yyyyMMdd
	 */
	public static final String DEFAULT_SYSTEM_DATE_FORMAT = "yyyyMMdd";
	/**
	 * 后台业务层用到的时间格式:HHMM
	 */
	public static final String DEFAULT_USER_TIME_FORMAT = "HH:mm";

	/**
	 * 私有构造方法，禁止对该类进行实例化
	 */
	private TimeHelper() {

	}

	/**
	 * 得到系统当前日期时间
	 * 
	 * @return 当前日期时间
	 */
	public static Date getNow() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 得到当前时间
	 * 
	 * @return 当前时间
	 */
	public static String getTime() {
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat dt = new SimpleDateFormat(DEFAULT_USER_TIME_FORMAT);
		return dt.format(date);
	}

	/**
	 * 得到用缺省方式格式化的当前日期
	 * 
	 * @return 当前日期
	 */
	public static String getDate() {

		Locale locale = Locale.getDefault();
		if (locale.getLanguage().toLowerCase().equals("zh")) {
			return getDateTime(DEFAULT_DATE_FORMAT);
		} else if (locale.getLanguage().toLowerCase().equals("en")) {
			return getDateTime(DEFAULT_DATE_FORMAT_EN);
		} else {
			return getDateTime(DEFAULT_DATE_FORMAT);
		}
	}

	/**
	 * 得到用缺省方式格式化的当前日期及时间
	 * 
	 * @return 当前日期及时间
	 */
	public static String getDateTime() {
		Locale locale = Locale.getDefault();
		if (locale.getLanguage().toLowerCase().equals("zh")) {
			return getDateTime(DEFAULT_DATETIME_FORMAT);
		} else if (locale.getLanguage().toLowerCase().equals("en")) {
			return getDateTime(DEFAULT_DATETIME_FORMAT_EN);
		} else {
			return getDateTime(DEFAULT_DATETIME_FORMAT);
		}

	}

	/**
	 * 得到系统当前日期及时间，并用指定的方式格式化
	 * 
	 * @param pattern
	 *            显示格式
	 * @return 当前日期及时间
	 */
	public static String getDateTime(String pattern) {
		Date datetime = Calendar.getInstance().getTime();
		return getDateTime(datetime, pattern);

	}

	/**
	 * 得到用指定方式格式化的日期
	 * 
	 * @param date
	 *            需要进行格式化的日期
	 * @param pattern
	 *            显示格式
	 * @return 日期时间字符串
	 */
	public static String getDateTime(Date date, String pattern) {
		if (null == pattern || "".equals(pattern)) {
			pattern = DEFAULT_DATETIME_FORMAT;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	/**
	 * 得到用指定方式格式化的日期
	 * 
	 * @param date
	 *            需要进行格式化的日期
	 * @param pattern
	 *            显示格式
	 * @return 日期时间字符串
	 */
	public static String getDateTime(long date, String pattern) {
		if (null == pattern || "".equals(pattern)) {
			pattern = DEFAULT_DATETIME_FORMAT;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(new Date(date));
	}

	/**
	 * 得到用指定方式格式化的日期
	 * 
	 * @param date
	 *            需要进行格式化的日期
	 * @param pattern
	 *            显示格式
	 * @return 日期时间字符串
	 */
	public static String getDate(Date date, String pattern, Locale locale) {
		if (null == locale) {
			locale = Locale.getDefault();
		}
		if (null == pattern || "".equals(pattern)) {
			if (locale.getLanguage().toLowerCase().equals("zh")) {
				pattern = DEFAULT_DATE_FORMAT;
			} else if (locale.getLanguage().toLowerCase().equals("en")) {
				pattern = DEFAULT_DATE_FORMAT_EN;
			}
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);

	}

	/**
	 * 得到用指定方式格式化的日期
	 * 
	 * @param date
	 *            需要进行格式化的日期
	 * @param pattern
	 *            显示格式
	 * @return 日期时间字符串
	 */
	public static String getDateTime(Date date, String pattern, Locale locale) {
		if (null == locale) {
			locale = Locale.getDefault();
		}
		if (null == pattern || "".equals(pattern)) {
			if (locale.getLanguage().toLowerCase().equals("zh")) {
				pattern = DEFAULT_DATETIME_FORMAT;
			} else if (locale.getLanguage().toLowerCase().equals("en")) {
				pattern = DEFAULT_DATETIME_FORMAT_EN;
			}
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	/**
	 * 得到当前年份
	 * 
	 * @return 当前年份
	 */
	public static int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**
	 * 得到当前月份
	 * 
	 * @return 当前月份
	 */
	public static int getCurrentMonth() {
		// 用get得到的月份数比实际的小1，需要加上
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}

	/**
	 * 得到当前日
	 * 
	 * @return 当前日
	 */
	public static int getCurrentDay() {
		return Calendar.getInstance().get(Calendar.DATE);
	}

	/**
	 * 得到当前日的开始时间
	 * 
	 * @return Date
	 */
	public static Date getCurrentDayStart() {
		Date todayDate = new Date();
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(todayDate);

		calendar.set(Calendar.AM_PM, Calendar.HOUR);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DATE, 0);
		Date todayDateStart = calendar.getTime();
		return todayDateStart;
	}

	/**
	 * 取得当前日期以后若干天的日期。如果要得到以前的日期，参数用负数。 例如要得到上星期同一天的日期，参数则为-7
	 * 
	 * @param days
	 *            增加的日期数
	 * @return 增加以后的日期
	 */
	public static Date addDays(int days) {
		return add(getNow(), days, Calendar.DATE);
	}

	/**
	 * 取得指定日期以后若干天的日期。如果要得到以前的日期，参数用负数。
	 * 
	 * @param date
	 *            基准日期
	 * @param days
	 *            增加的日期数
	 * @return 增加以后的日期
	 */
	public static Date addDays(Date date, int days) {
		return add(date, days, Calendar.DATE);
	}

	/**
	 * 取得当前日期以后某月的日期。如果要得到以前月份的日期，参数用负数。
	 * 
	 * @param months
	 *            增加的月份数
	 * @return 增加以后的日期
	 */
	public static Date addMonths(int months) {
		return add(getNow(), months, Calendar.MONTH);
	}

	/**
	 * 取得指定日期以后某月的日期。如果要得到以前月份的日期，参数用负数。 注意，可能不是同一日子，例如2003-1-31加上一个月是2003-2-28
	 * 
	 * @param date
	 *            基准日期
	 * @param months
	 *            增加的月份数
	 * @return 增加以后的日期
	 */
	public static Date addMonths(Date date, int months) {
		return add(date, months, Calendar.MONTH);
	}

	/**
	 * 内部方法。为指定日期增加相应的天数或月数
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增加的数量
	 * @param field
	 *            增加的单位，年，月，日，分钟，小时,Calendar类的常量值
	 * @return 增加以后的日期
	 */
	public static Date add(Date date, int amount, int field) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.add(field, amount);

		return calendar.getTime();
	}

	/**
	 * 计算两个日期相差天数。 用第一个日期减去第二个。如果前一个日期小于后一个日期，则返回负数
	 * 
	 * @param one
	 *            第一个日期数，作为基准
	 * @param two
	 *            第二个日期数，作为比较
	 * @return 两个日期相差天数
	 */
	public static long diffDays(Date one, Date two) {
		return (one.getTime() - two.getTime()) / (24 * 60 * 60 * 1000);
	}

	/**
	 * 计算两个日期相差月份数 如果前一个日期小于后一个日期，则返回负数
	 * 
	 * @param one
	 *            第一个日期数，作为基准
	 * @param two
	 *            第二个日期数，作为比较
	 * @return 两个日期相差月份数
	 */
	public static int diffMonths(Date one, Date two) {

		Calendar calendar = Calendar.getInstance();

		// 得到第一个日期的年分和月份数
		calendar.setTime(one);
		int yearOne = calendar.get(Calendar.YEAR);
		int monthOne = calendar.get(Calendar.MONTH);

		// 得到第二个日期的年份和月份
		calendar.setTime(two);
		int yearTwo = calendar.get(Calendar.YEAR);
		int monthTwo = calendar.get(Calendar.MONTH);

		return (yearOne - yearTwo) * 12 + (monthOne - monthTwo);
	}

	/**
	 * 将一个字符串用给定的格式转换为日期类型。 <br>
	 * 注意：如果返回null，则表示解析失败
	 * 
	 * @param datestr
	 *            需要解析的日期字符串
	 * @param pattern
	 *            日期字符串的格式，默认为“yyyy-MM-dd”的形式
	 * @return 解析后的日期
	 */
	public static Date parse(String datestr, String pattern) {
		Date date = null;

		if (null == pattern || "".equals(pattern)) {
			pattern = DEFAULT_DATE_FORMAT;
		}

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			date = dateFormat.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 按照默认的格式将字符串的时间转换成日期
	 * 
	 * @param datestr
	 * @return Date
	 */
	public static Date parse(String datestr) {

		try {
			if (null != datestr && !"".equals(datestr)) {
				if (datestr.length() == 12) {// 分钟
					return TimeHelper.parse(datestr, "yyyyMMddHHmm");
				} else if (datestr.length() == 10) {// 小时
					return TimeHelper.parse(datestr, "yyyyMMddHH");
				} else if (datestr.length() == 8) {// 天
					return TimeHelper.parse(datestr, "yyyyMMdd");
				} else if (datestr.length() == 6) {// 月
					return TimeHelper.parse(datestr, "yyyyMM");
				} else if (datestr.length() == 4) {// 年
					return TimeHelper.parse(datestr, "yyyy");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 返回本月的最后一天
	 * 
	 * @return 本月最后一天的日期
	 */
	public static Date getMonthLastDay() {
		return getMonthLastDay(getNow());
	}

	/**
	 * 返回给定日期中的月份中的最后一天
	 * 
	 * @param date
	 *            基准日期
	 * @return 该月最后一天的日期
	 */
	public static Date getMonthLastDay(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		// 将日期设置为下一月第一天
		calendar.set(calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH) + 1, 1);

		// 减去1天，得到的即本月的最后一天
		calendar.add(Calendar.DATE, -1);

		return calendar.getTime();
	}

	/**
	 * 获得某一个时间所处周的起始日期
	 * 
	 * @param time
	 *            -时间,"yyyyMMddHHmm";
	 * @return time所处周的起始日期的"yyyyMMdd"
	 */
	public static String startWeekDate(String time) {

		if (null == time || "".equals(time)) {
			time = getDateTime("yyyyMMddHHmm");
		}
		try {

			Date t_d_time = parse(time, "yyyyMMddHHmm");
			// 转换成Calendar
			Calendar t_c_time = Calendar.getInstance();
			t_c_time.setTime(t_d_time);

			// 获得time是当周的第几天,如果是周日=1,周一=2,依此类推,周六=7
			int t_i_day_week = t_c_time.get(Calendar.DAY_OF_WEEK) - 1;

			if (t_i_day_week > 0) {// 如果>0则表示不是周日
				String t_s_day_week = "-"
						+ new Integer(t_i_day_week).toString();

				Date t_rtn = addDays(t_d_time,
						new Integer(t_s_day_week).intValue());
				t_c_time.setTime(t_rtn);
				t_c_time.set(Calendar.AM_PM, Calendar.HOUR);
				t_c_time.set(Calendar.HOUR_OF_DAY, 0);
				t_c_time.set(Calendar.MINUTE, 0);
				t_c_time.set(Calendar.SECOND, 0);

				String returnString = TimeHelper.getDateTime(
						t_c_time.getTime(), "yyyyMMdd");

				return returnString;

			} else {// 当前的时间为周日
				String returnString = TimeHelper.getDateTime(t_d_time,
						"yyyyMMdd");

				return returnString;
			}

		} catch (NumberFormatException nfe) {
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 获得某一个时间所处周的结束日期
	 * 
	 * @param time
	 *            - 时间,必须以毫秒
	 * @return time所处周的结束日期的"yyyyMMdd"
	 */
	public static String endWeekDate(String time) {
		if (null == time || "".equals(time)) {
			time = getDateTime("yyyyMMddHHmm");
		}
		try {
			Date t_d_time = parse(time, "yyyyMMddHHmm");
			// 转换成Calendar
			Calendar t_c_time = Calendar.getInstance();
			t_c_time.setTime(t_d_time);

			// 获得time是当周的第几天
			int t_s_day_week = t_c_time.get(Calendar.DAY_OF_WEEK);

			if (7 - t_s_day_week != 0) {
				t_d_time = addDays(t_d_time, (7 - t_s_day_week));
			}
			t_c_time.setTime(t_d_time);
			t_c_time.set(Calendar.AM_PM, Calendar.HOUR);
			t_c_time.set(Calendar.HOUR_OF_DAY, 23);
			t_c_time.set(Calendar.MINUTE, 59);
			t_c_time.set(Calendar.SECOND, 59);
			String returnString = TimeHelper.getDateTime(t_c_time.getTime(),
					"yyyyMMdd");
			return returnString;
		} catch (NumberFormatException nfe) {
		} catch (Exception e) {
		}

		return null;
	}

	/**
	 * 去当前时间给要返回的时间类型得到年、月、日、小时方法的详细描述
	 * 
	 * @param timeType
	 *            时间类型如：Calendar.YEAR
	 * @return
	 */
	public static int dateNum(int timeType) {
		return dateNum(null, timeType);
	}

	/**
	 * 给一个时间和要返回的时间类型得到年、月、日、小时方法的详细描述
	 * 
	 * @param date
	 *            时间
	 * @param field
	 *            时间类型如：Calendar.YEAR
	 * @return
	 */
	public static int dateNum(Date date, int field) {
		int t_temp = 100;
		Calendar calendar = Calendar.getInstance();

		if (null == date)
			date = getNow();
		calendar.setTime(date);
		t_temp = calendar.get(field);
		return t_temp;
	}

	/**
	 * 获得某一个时间所处周的起始日期
	 * 
	 * @param time
	 *            -时间,"yyyyMMddHHmm";
	 * @param pattern
	 *            显示格式
	 * @return date
	 */
	public static Date startWeekDate(String time, String pattern) {
		if (null == pattern || "".equals(pattern)) {
			pattern = DEFAULT_PAGE_FORMAT;
		}
		if (null == time || "".equals(time)) {
			time = getDateTime(pattern);
		}
		try {

			Date t_d_time = parse(time, pattern);
			// 转换成Calendar
			Calendar t_c_time = Calendar.getInstance();
			t_c_time.setTime(t_d_time);

			// 获得time是当周的第几天,如果是周日=1,周一=2,依此类推,周六=7
			int t_i_day_week = t_c_time.get(Calendar.DAY_OF_WEEK) - 1;

			if (t_i_day_week > 0) {// 如果>0则表示不是周日
				String t_s_day_week = "-"
						+ new Integer(t_i_day_week).toString();

				Date t_rtn = addDays(t_d_time,
						new Integer(t_s_day_week).intValue());
				t_c_time.setTime(t_rtn);
				t_c_time.set(Calendar.AM_PM, Calendar.HOUR);
				t_c_time.set(Calendar.HOUR_OF_DAY, 0);
				t_c_time.set(Calendar.MINUTE, 0);
				t_c_time.set(Calendar.SECOND, 0);
				Date returnDate = t_c_time.getTime();
				return returnDate;

			} else {// 当前的时间为周日
				return t_d_time;
			}

		} catch (NumberFormatException nfe) {
		} catch (Exception e) {
		}

		return null;
	}

	/**
	 * 获得某一个时间所处周的结束日期
	 * 
	 * @param time
	 *            - 时间,"yyyyMMddHHmm"
	 * @param pattern
	 *            显示格式
	 * @return time所处周的结束日期的"yyyyMMdd"
	 */
	public static Date endWeekDate(String time, String pattern) {

		if (null == pattern || "".equals(pattern)) {
			pattern = DEFAULT_PAGE_FORMAT;
		}
		if (null == time || "".equals(time)) {
			time = getDateTime(pattern);
		}
		try {
			Date t_d_time = parse(time, pattern);
			// 转换成Calendar
			Calendar t_c_time = Calendar.getInstance();
			t_c_time.setTime(t_d_time);

			// 获得time是当周的第几天
			int t_s_day_week = t_c_time.get(Calendar.DAY_OF_WEEK);

			if (7 - t_s_day_week != 0) {
				t_d_time = addDays(t_d_time, (7 - t_s_day_week));
			}
			t_c_time.setTime(t_d_time);
			t_c_time.set(Calendar.AM_PM, Calendar.HOUR);
			t_c_time.set(Calendar.HOUR_OF_DAY, 23);
			t_c_time.set(Calendar.MINUTE, 59);
			t_c_time.set(Calendar.SECOND, 59);
			Date returnDate = t_c_time.getTime();

			return returnDate;
		} catch (NumberFormatException nfe) {
		} catch (Exception e) {
		}

		return null;
	}

	/**
	 * 将yyyyMMddHHmm转换为yyyy-MM-dd HH:mm格式数据
	 * 
	 * @param time
	 *            时间字符串
	 * @return String 或 null
	 */
	public static String switchFormat(String time) {
		return switchFormat(time, null);
	}

	/**
	 * 将yyyyMMddHHmm转换为如（yyyy-MM-dd HH:mm）这种的标准格式数据
	 * 
	 * @param time
	 *            时间字符串
	 * @param pattern
	 *            显示格式
	 * @return String 或 null
	 */
	public static String switchFormat(String time, String pattern) {
		String t_date = null;
		if (null != time) {
			if (null != pattern)
				t_date = getDateTime(parse(time, DEFAULT_PAGE_FORMAT), pattern);
			else
				t_date = getDateTime(parse(time, DEFAULT_PAGE_FORMAT),
						DEFAULT_DATETIME_FORMAT);
		}
		return t_date;

	}

	public static String getSpecData() {
		Date data = Calendar.getInstance().getTime();
		SimpleDateFormat temp = new SimpleDateFormat("MM dd");
		String tempdata = temp.format(data);
		String tempDay = "";
		switch (data.getDay()) {
		case 0:
			tempDay = "周日";
			break;
		case 1:
			tempDay = "周一";
			break;
		case 2:
			tempDay = "周二";
			break;
		case 3:
			tempDay = "周三";
			break;
		case 4:
			tempDay = "周四";
			break;
		case 5:
			tempDay = "周五";
			break;
		case 6:
			tempDay = "周六";
			break;

		default:
			break;
		}
		return tempDay + " " + tempdata;

	}

	public static String getSpecDataAndTime() {
		Date data = Calendar.getInstance().getTime();
		SimpleDateFormat temp = new SimpleDateFormat("MM月dd日  yyyy");
		String tempdata = temp.format(data);
		String tempDay = "";
		switch (data.getDay()) {
		case 0:
			tempDay = "周日";
			break;
		case 1:
			tempDay = "周一";
			break;
		case 2:
			tempDay = "周二";
			break;
		case 3:
			tempDay = "周三";
			break;
		case 4:
			tempDay = "周四";
			break;
		case 5:
			tempDay = "周五";
			break;
		case 6:
			tempDay = "周六";
			break;

		default:
			break;
		}
		return tempDay + " " + tempdata;
	}

	public static String getHour() {
		String temetime = getTime();
		String[] temp = temetime.split(":");
		String finatemp = "";
		if (temp.length != 0) {
			finatemp = temp[0];
		}
		return finatemp;
	}

	public static String getMinus() {
		Date data = Calendar.getInstance().getTime();
		String mm = "";
		if (data.getMinutes() < 10) {
			mm = "0" + data.getMinutes();
		} else {
			mm = "" + data.getMinutes();
		}
		return mm;
	}

	/**
	 * 将服务器时间转化为时间（服务器时间以秒为单位，必须乘1000）
	 * 
	 * @param millis
	 * @return
	 */
	public static String GetStringFromLong(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		Date dt = new Date(millis * 1000);
		return sdf.format(dt);
	}

	/**
	 * 将服务器时间转化为时间（服务器时间以毫秒为单位）
	 * 
	 * @param millis
	 * @return
	 */
	public static String GetFromLong(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		Date dt = new Date(millis);
		return sdf.format(dt);
	}
}
