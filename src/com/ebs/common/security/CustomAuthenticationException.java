package com.ebs.common.security;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义身份认证异常
 *
 * @工程： 中招联合电子采购平台
 * @模块： 公共-安全
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年12月10日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class CustomAuthenticationException extends AuthenticationException {

    public final static int CODE_JYM = 1;

    public final static int CODE_CA = 2;

    public final static int CODE_SSO = 3;

    public final static int CODE_LDAP = 4;

    public final static int CODE_IP = 5;

    private int excCode;
    private Integer errtype;

    public CustomAuthenticationException(String msg, int excCode) {
        super(msg);
        this.excCode = excCode;
    }

    public CustomAuthenticationException(String msg, int excCode, Integer errtype) {
        this(msg, excCode);
        this.errtype = errtype;
    }

    public int getExcCode() {
        return excCode;
    }

    public Integer getErrtype() {
        return errtype;
    }

}
