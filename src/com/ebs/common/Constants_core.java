package com.ebs.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 工程： e招标</br> 类名：Constants_core</br>
 * 
 * <p>
 * 功能描述：TODO
 * </p>
 * 
 * 作者： </br> 创建日期： 2016年2月20日</br> 修改记录：（修改时间、作者、原因）：</br>
 */
public class Constants_core {
	// 非结构换文档起始路径
	public static String FILEPATH;

	// 系统处理非结构化文档的临时目录
	public static String GG_TEMP_PATH;

	// 校验码的存储标识
	public final static String RANDOM_CHECKCODE = "RANDOM_CHECKCODE_GENERATER";

	// 有效的操作员标识
	public final static int OPERATOR_VALID_BZ = 1;

	// 分页常量
	private static final Map<Integer, Integer> PageSizeOptions = new LinkedHashMap<Integer, Integer>();
	static {
		for (int i = 1; i <= 24; i++) {
			PageSizeOptions.put(i, i);
		}
		for (int i = 25; i <= 50; i += 5) {
			PageSizeOptions.put(i, i);
		}
		PageSizeOptions.put(100, 100);
	}

	public static Map<Integer, Integer> getPageSizeOptions() {
		return PageSizeOptions;
	}
}
