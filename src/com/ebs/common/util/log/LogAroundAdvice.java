package com.ebs.common.util.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志切入类
 *
 * @工程： 核心包4.0版
 * @模块： 公共-工具
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年10月30日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class LogAroundAdvice {
	Logger logger = LoggerFactory.getLogger(LogAroundAdvice.class);

	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info(">>>> {}.{}(..) start...", new Object[] { joinPoint.getSignature().getDeclaringType(), joinPoint.getSignature().getName() });
		long t = System.currentTimeMillis();
		Object retVal = joinPoint.proceed();

		logger.info("<<<< {}.{}(..) end... {}ms", new Object[] { joinPoint.getSignature().getDeclaringType(), joinPoint.getSignature().getName(), System.currentTimeMillis() - t });
		return retVal;
	}
}
