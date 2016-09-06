package com.ebs.common.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.ebs.dao.iface.SecurityDao;

/**
 * 加载资源与权限的对应关系
 *
 * @工程： 中招联合电子采购平台
 * @模块： 公共-安全
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年12月10日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	private SecurityDao securityDao;
    
    // 构造方法，由spring调用
    public MySecurityMetadataSource(SecurityDao securityDao) {
        this.securityDao = securityDao;
        loadResourceDefine();
    }
     
    private static transient Map<String, Collection<ConfigAttribute>> resourceMap = null;

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }

    /**
     * 加载所有资源与权限的关系缓存
     *
     * @作者： 刘明磊
     * @创建日期：2015年12月10日
     *
     * @参数: 
     * @返回值: 
     *
     * @修改记录（修改时间、作者、原因）：
     */
    private synchronized void loadResourceDefine() {
        if (resourceMap == null) {
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
            List<Map<String, Object>> resources = this.securityDao.getResources();
            for (Map<String, Object> resource : resources) {
                String url = "/" + resource.get("gndz").toString();
                ConfigAttribute configAttribute = new SecurityConfig(resource.get("lbbh").toString());
                if (resourceMap.containsKey(url)) {
                    resourceMap.get(url).add(configAttribute);
                } else {
                    Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
                    configAttributes.add(configAttribute);
                    resourceMap.put("/" + resource.get("gndz").toString(), configAttributes);
                }
            }
        }
    }

    // 重置功能授权信息
    public void clearResourceMap() {
        setResourceMap(null);
    }

    /**
     * 返回所请求资源所需要的权限
     *
     * @作者： 刘明磊
     * @创建日期：2015年月日
     *
     * @参数: object 拦截对象
     * @返回值: Collection<ConfigAttribute>
     *
     * @修改记录（修改时间、作者、原因）：
     */
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        if (resourceMap == null) {
            loadResourceDefine();
        }
        return resourceMap.get(requestUrl);
    }

    public static Map<String, Collection<ConfigAttribute>> getResourceMap() {
        return resourceMap;
    }

    public static void setResourceMap(Map<String, Collection<ConfigAttribute>> resourceMap) {
        MySecurityMetadataSource.resourceMap = resourceMap;
    }

	public SecurityDao getSecurityDao() {
		return securityDao;
	}

	public void setSecurityDao(SecurityDao securityDao) {
		this.securityDao = securityDao;
	}

}