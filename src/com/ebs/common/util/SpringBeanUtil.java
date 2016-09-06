package com.ebs.common.util;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanUtil implements ApplicationContextAware {
    private static ApplicationContext staticContext;
    
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        staticContext = context;
    }

    public static Object getBean(String strBeanName) {
        return staticContext.getBean(strBeanName);
    }

    public static Map getBeansOfType(Class<?> classx) {
        return staticContext.getBeansOfType(classx);
    }
}
