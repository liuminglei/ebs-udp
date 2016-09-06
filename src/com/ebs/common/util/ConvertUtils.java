package com.ebs.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ebs.common.MisException;

/**
 * 工程： e招标</br> 类名：ConvertUtils</br>
 * 
 * <p>
 * 功能描述：TODO
 * </p>
 * 
 * 作者： </br> 创建日期： 2016年2月20日</br> 修改记录：（修改时间、作者、原因）：</br>
 */
public class ConvertUtils {
	public static int toInt(Object obj) {
		return toInt(obj, 0);
	}

	public static int toInt(Object obj, int defaultValue) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return defaultValue;
		}
		return Integer.parseInt(obj.toString());
	}

	public static long toLong(Object obj) {
		return toLong(obj, 0L);
	}

	public static long toLong(Object obj, long defaultValue) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return defaultValue;
		}
		return Long.parseLong(obj.toString());
	}

	public static float toFloat(Object obj) {
		return toFloat(obj, 0.0f);
	}

	public static float toFloat(Object obj, float defaultValue) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return defaultValue;
		}
		return Float.parseFloat(obj.toString());
	}

	public static double toDouble(Object obj) {
		return toDouble(obj, 0.0d);
	}

	public static double toDouble(Object obj, double defaultValue) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return defaultValue;
		}
		return Double.parseDouble(obj.toString());
	}

	public static Float createFloat(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return Float.valueOf(obj.toString());
	}

	public static Double createDouble(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return Double.valueOf(obj.toString());
	}

	public static Integer createInteger(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return Integer.valueOf(obj.toString());
	}

	public static Long createLong(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return Long.valueOf(obj.toString());
	}

	public static BigInteger createBigInteger(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return new BigInteger(obj.toString());
	}

	public static BigDecimal createBigDecimal(Object obj) {
		if (obj == null || StringUtils.isBlank(obj.toString())) {
			return null;
		}
		return new BigDecimal(obj.toString());
	}

	public static String createString(Object obj) {
		if (obj == null) {
			return null;
		}
		return obj.toString();
	}

	public static Number min(Number... array) {
		Number min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i].doubleValue() < min.doubleValue()) {
				min = array[i];
			}
		}
		return min;
	}

	public static Number max(Number... array) {
		Number max = array[0];
		for (int j = 1; j < array.length; j++) {
			if (array[j].doubleValue() > max.doubleValue()) {
				max = array[j];
			}
		}
		return max;
	}

	public static Calendar string2Date(String format, Long value) throws ParseException {
		Date date = new SimpleDateFormat(format).parse(String.valueOf(value));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static String list2SqlInString(List<Map> list, String key) {
		if (list != null && list.size() > 0) {
			StringBuffer inString = new StringBuffer(" ");
			for (Map map : list) {
				if (map.containsKey(key)) {
					inString.append("'");
					inString.append(map.get(key) == null ? "" : map.get(key)
							.toString());
					inString.append("',");
				} else {
					throw new MisException("not contains key" + key);
				}
			}
			String in = inString.toString();
			in = StringUtils.equals(in, "") ? "''"
					: (in.endsWith(",") ? StringUtils.removeEnd(in, ",") : in);
			return "(" + in + ")";
		}
		return "(' ')";
	}
}
