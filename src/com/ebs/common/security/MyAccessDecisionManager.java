package com.ebs.common.security;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 自定义资源与权限校验管理器
 *
 * @工程： 中招联合电子采购平台
 * @模块： 公共-安全
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年12月10日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class MyAccessDecisionManager implements AccessDecisionManager {
    private static Log log = LogFactory.getLog(MyAccessDecisionManager.class);
    
    /**
     * 校验资源与权限关系
     *
     * @作者： 刘明磊
     * @创建日期：2015年12月10日
     *
     * @参数: authentication 用户所拥有的权限
     * @参数: object 拦截对象
     * @参数: configAttributes 访问所请求资源所需要的权限
     * @返回值: 
     *
     * @修改记录（修改时间、作者、原因）：
     */
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if(configAttributes == null) {
            return;
        }
        //所请求的资源拥有的权限(一个资源对多个权限)
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while(iterator.hasNext()) {
            ConfigAttribute configAttribute = iterator.next();
            //访问所请求资源所需要的权限
            String needPermission = configAttribute.getAttribute();
            
            //用户所拥有的权限
            for(GrantedAuthority ga : authentication.getAuthorities()) {
                if(needPermission.equals(ga.getAuthority())) {
                    return;
                }
            }
        }
        
        //没有权限
        throw new AccessDeniedException(" 没有权限访问！ ");
    }

    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }
    
}