package com.ebs.common.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * 自定义安全过滤器（ajaxUpload上传有问题，可能是Spring security过滤导致，所以重载该过滤器）
 *
 * @工程： 中招联合电子采购平台
 * @模块： 公共-安全
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年12月10日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class MyDelegatingFilterProxy extends DelegatingFilterProxy {
    private static final Logger logger = LoggerFactory.getLogger(MyDelegatingFilterProxy.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request instanceof HttpServletRequest && (((HttpServletRequest) request).getRequestURI().endsWith(":upload")||((HttpServletRequest) request).getRequestURI().endsWith("downloadfile.file"))) {
            // logger.error("-------------uploadURL:" + ((HttpServletRequest) request).getRequestURI());
            filterChain.doFilter(request, response);
        } else {
            super.doFilter(request, response, filterChain);
        }
    }
}
