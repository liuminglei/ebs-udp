package com.ebs.common.jdbcspy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Spy日志
 *
 * @工程： 核心4.0
 * @模块： 核心-常用-jdbcspy
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年11月7日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class SpyLog {
    private static Log log = LogFactory.getLog(SpyLog.class);

    public static void info(Object obj, String category, Object[] info) {
        if (SpyConfiguration.isCategoryEnabled(category)) {
            String temp = "";
            if (info != null) {
                for (int i = 0; i < info.length; ++i) {
                    if (i > 0) {
                        temp = temp + "|";
                    }
                    temp = temp + info[i];
                }
            }
            log.info(category + "|" + temp);
            if (SpyConfiguration.isStackTraceEnabled())
                log.error("Stack trace", new Exception("Stack trace"));
        }
    }
}