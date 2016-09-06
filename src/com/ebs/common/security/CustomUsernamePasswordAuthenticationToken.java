package com.ebs.common.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID = 1L;
    // 签名标识
    private String requestSignature;

    public CustomUsernamePasswordAuthenticationToken(String principal, String credentials, String signature) {
        super(principal, credentials);
        this.requestSignature = signature;
    }

    public void setRequestSignature(String requestSignature) {
        this.requestSignature = requestSignature;
    }

    public String getRequestSignature() {
        return requestSignature;
    }
}
