package com.ebs.common.security;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

import com.ebs.common.util.ConvertUtils;
import com.ebs.dao.iface.SecurityDao;

/**
 * 身份认证工具
 *
 * @工程： 中招联合电子采购平台
 * @模块： 公共-安全
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年12月10日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class DaoAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	private PasswordEncoder passwordEncoder = new PlaintextPasswordEncoder();
	private SaltSource saltSource;
	private UserDetailsService userDetailsService;
	private SecurityDao securityDao;
	
	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	    Object salt = null;

        if (this.saltSource != null) {
            salt = this.saltSource.getSalt(userDetails);
        }

        if (authentication.getCredentials() == null) {
            this.logger.debug("Authentication failed: no credentials provided");

            throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"), userDetails);
        }

        String presentedPassword = authentication.getCredentials().toString();

        if (!this.passwordEncoder.isPasswordValid(userDetails.getPassword(), presentedPassword, salt)) {
            this.logger.debug("Authentication failed: password does not match stored value");

            throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"), userDetails);
        }
	}

	protected void doAfterPropertiesSet() throws Exception {
		Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
	}

	protected final UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		UserDetails loadedUser;
		try {
			if (authentication instanceof CustomUsernamePasswordAuthenticationToken) {
				CustomUsernamePasswordAuthenticationToken response = (CustomUsernamePasswordAuthenticationToken) authentication;
				loadedUser = getUserDetailsByCaid(response.getRequestSignature());
			} else {
				loadedUser = getUserDetailsService().loadUserByUsername(username);
				if (!loadedUser.isEnabled()) {
					throw new UsernameNotFoundException("该帐号未启用或被列入黑名单！");
				}
			}

		} catch (UsernameNotFoundException notFound) {
			throw notFound;
		} catch (Exception repositoryProblem) {
			throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
		}

		if (loadedUser == null) {
			throw new AuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
		}

		return loadedUser;
	}

	/**
	 * 身份认证
	 *
	 * @作者： 刘明磊
	 * @创建日期：2015年12月10日
	 *
	 * @参数: authentication 认证信息对象
	 * @返回值: Authentication
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	/**	if (!supports(authentication.getClass())) {
			return null;
		}
		if ((authentication instanceof CustomUsernamePasswordAuthenticationToken)) {
			CustomUsernamePasswordAuthenticationToken response = (CustomUsernamePasswordAuthenticationToken) authentication;
			UserDetails loadedUser = getUserDetailsByCaid(response.getRequestSignature());

			Authentication resut = createSuccessAuthentication(loadedUser.getUsername(), authentication, loadedUser);
			SecurityContextHolder.getContext().setAuthentication(resut);
			return resut;
		} else {
			Authentication resut = SecurityContextHolder.getContext().getAuthentication();
			return resut.isAuthenticated() ? resut : super.authenticate(resut);
		}**/
	    
		// Determine username
        String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();

        boolean cacheWasUsed = true;
        
        //从缓存中获取当前用户详细信息对象
        UserDetails user = this.getUserCache().getUserFromCache(username);

        if (user == null) {
            cacheWasUsed = false; 

            try {
                //根据用户名获取用户详细信息
            	user = this.userDetailsService.loadUserByUsername(username);
            } catch (UsernameNotFoundException notFound) {
                logger.debug("用户'" + username + "'在系统中未找到");

                if (hideUserNotFoundExceptions) {
                    throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
                } else {
                    throw notFound;
                }
            }

            Assert.notNull(user, "retrieveUser returned null - a violation of the interface contract");
        }

        try {
            getPreAuthenticationChecks().check(user);
            additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
        } catch (AuthenticationException exception) {
            if (cacheWasUsed) {
                // There was a problem, so try again after checking
                // we're using latest data (i.e. not from the cache)
                cacheWasUsed = false;
                
                //发生异常时，再次获取用户详细信息并校验
                user = this.userDetailsService.loadUserByUsername(username);
                
                getPreAuthenticationChecks().check(user);
                additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
            } else {
                throw exception;
            }
        }

        getPostAuthenticationChecks().check(user);

        //用户缓存开启时，将当前用户信息放入缓存
        if (!cacheWasUsed) {
            this.getUserCache().putUserInCache(user);
        }

        Object principalToReturn = user;

        if (isForcePrincipalAsString()) {
            principalToReturn = user.getUsername();
        }

        //返回认证通过信息
        return createSuccessAuthentication(principalToReturn, authentication, user);
	}
	
	/**
	 * 通过CA号获取用户详细信息
	 *
	 * @作者： 刘明磊
	 * @创建日期：2015年12月10日
	 *
	 * @参数: caid CA号
	 * @返回值: UserDetails
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	protected UserDetails getUserDetailsByCaid(String caid) {
		UserDetails loadedUser;
		
		Map<String, Object> czyMap = this.securityDao.getCzyByCaid(caid);
		
		if (czyMap == null || czyMap.isEmpty()) {
            throw new CustomAuthenticationException("该证书未绑定帐号！", CustomAuthenticationException.CODE_CA, -2);
        }
		
		String gg_czyb_id = ConvertUtils.createString(czyMap.get("id"));
		String gg_czyb_dlh = ConvertUtils.createString(czyMap.get("dlh"));
        Integer gg_czyb_cabz = ConvertUtils.createInteger(czyMap.get("cabz"));
		
		if (StringUtils.isBlank(gg_czyb_id)) {
			throw new CustomAuthenticationException("该证书未绑定帐号！", CustomAuthenticationException.CODE_CA, -2);
		} else {
		    if (gg_czyb_cabz == null || gg_czyb_cabz == 2) {
		        throw new CustomAuthenticationException("该证书绑定帐号未启用或被列入黑名单！", CustomAuthenticationException.CODE_CA, -1);
		    }
		    
			if (gg_czyb_cabz == 0) {
				throw new CustomAuthenticationException("该证书绑定帐号只允许账号登录！", CustomAuthenticationException.CODE_CA, -1);
			}
			
			loadedUser = getUserDetailsService().loadUserByUsername(gg_czyb_dlh);
		}
		
		return loadedUser;
	}

	public void setSaltSource(SaltSource saltSource) {
		this.saltSource = saltSource;
	}

	protected SaltSource getSaltSource() {
		return this.saltSource;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	protected UserDetailsService getUserDetailsService() {
		return this.userDetailsService;
	}

    public PasswordEncoder getPasswordEncoder() {
        return this.passwordEncoder;
    }
    
    public void setPasswordEncoder(Object passwordEncoder) {
        Assert.notNull(passwordEncoder, "passwordEncoder cannot be null");

        if (passwordEncoder instanceof PasswordEncoder) {
            this.passwordEncoder = (PasswordEncoder) passwordEncoder;
            return;
        }

        if (passwordEncoder instanceof org.springframework.security.crypto.password.PasswordEncoder) {
            final org.springframework.security.crypto.password.PasswordEncoder delegate = (org.springframework.security.crypto.password.PasswordEncoder) passwordEncoder;
            this.passwordEncoder = new PasswordEncoder() {
                private void checkSalt(Object salt) {
                    Assert.isNull(salt, "Salt value must be null when used with crypto module PasswordEncoder");
                }

                public String encodePassword(String rawPass, Object salt) {
                    checkSalt(salt);
                    return delegate.encode(rawPass);
                }

                public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
                    checkSalt(salt);
                    return delegate.matches(rawPass, encPass);
                }
            };

            return;
        }

        throw new IllegalArgumentException("passwordEncoder must be a PasswordEncoder instance");
    }

	public SecurityDao getSecurityDao() {
		return securityDao;
	}

	public void setSecurityDao(SecurityDao securityDao) {
		this.securityDao = securityDao;
	}
    
}
