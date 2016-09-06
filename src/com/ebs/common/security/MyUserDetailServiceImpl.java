package com.ebs.common.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ebs.common.Constants_core;
import com.ebs.common.util.ConvertUtils;
import com.ebs.dao.iface.SecurityDao;

/**
 * 用户详细信息服务实现
 *
 * @工程： 中招联合电子采购平台
 * @模块： 公共-安全
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年12月10日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class MyUserDetailServiceImpl implements UserDetailsService {
    private SecurityDao securityDao;
    
    /**
     * 通过用户名加载用户信息
     *
     * @作者： 刘明磊
     * @创建日期：2015年12月10日
     *
     * @参数: username 用户名
     * @返回值: UserDetails
     *
     * @修改记录（修改时间、作者、原因）：
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //获取操作员实体
        Map<String, Object> czyMap = this.securityDao.getCzyByDlh(username);
        
        if (czyMap == null || czyMap.isEmpty()) {
            throw new UsernameNotFoundException("系统中找不到该用户：" + username);
        }
        
        String gg_czyb_id = ConvertUtils.createString(czyMap.get("id"));
        String gg_czyb_mm = ConvertUtils.createString(czyMap.get("mm"));
        Integer gg_czyb_sybz = ConvertUtils.createInteger(czyMap.get("sybz"));
        
        if (StringUtils.isBlank(gg_czyb_id)) {
            throw new UsernameNotFoundException("系统中找不到该用户：" + username);
        } else {
            Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(gg_czyb_id);

            // 是否开启
            boolean enables = gg_czyb_sybz == null ? false : gg_czyb_sybz == Constants_core.OPERATOR_VALID_BZ ? true : false;
            
            // 帐号未过期
            boolean accountNonExpired = true;
            
            // 凭证未过期
            boolean credentialsNonExpired = true;
            
            // 帐号未锁定
            boolean accountNonLocked = gg_czyb_sybz == null ? false : gg_czyb_sybz == Constants_core.OPERATOR_VALID_BZ ? true : false;

            // 验证用户名和密码是否正确，以及是否权限正确
            User userdetail = new User(username, gg_czyb_mm, enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
            
            return userdetail;
        }
    }

    /**
     * 取得用户的权限
     *
     * @作者： 刘明磊
     * @创建日期：2015年月日
     *
     * @参数: gg_czyb 操作员实体
     * @返回值: Set<GrantedAuthority>
     *
     * @修改记录（修改时间、作者、原因）：
     */
    private Set<GrantedAuthority> obtionGrantedAuthorities(String gg_czyb_id) {
        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();

        List<Map<String, Object>> list = this.securityDao.getRoleByUser(gg_czyb_id);

        for (Map<String, Object> map : list) {
            authSet.add(new GrantedAuthorityImpl(map.get("lbbh").toString()));
        }
        return authSet;
    }

	public SecurityDao getSecurityDao() {
		return securityDao;
	}

	public void setSecurityDao(SecurityDao securityDao) {
		this.securityDao = securityDao;
	}

}