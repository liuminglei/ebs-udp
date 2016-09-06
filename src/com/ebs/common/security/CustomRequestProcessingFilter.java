package com.ebs.common.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.ebs.common.Constants_core;

public class CustomRequestProcessingFilter extends
		AbstractAuthenticationProcessingFilter {
	public static final String ACEGI_SECURITY_FORM_CHECKCODE_KEY = "j_checkcode";
	public static final String usernameHeader = "j_username";
	public static final String pasHeader = "j_password";
	public static final String signatureHeader = "j_signature";
	public static final String LOGINFAIL = "loginfail";
	public static final String LOGINFAILCODE = "1";
	public static final Integer CHECKCODE = 4;

	private String authenticationCaFaileUrl;

	public String getAuthenticationCaFaileUrl() {
		return authenticationCaFaileUrl;
	}

	public void setAuthenticationCaFaileUrl(String authenticationCaFaileUrl) {
		this.authenticationCaFaileUrl = authenticationCaFaileUrl;
	}

	protected CustomRequestProcessingFilter() {
		super("/j_spring_security_check");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rqt = (HttpServletRequest) req;
		HttpServletResponse rps = (HttpServletResponse) res;
		rqt.setCharacterEncoding("UTF-8");
		
		super.doFilter(req, res, chain);
//		if (rqt.getRequestURI().indexOf("j_spring_security_check") >= 0 && req.getParameter(LOGINFAIL).equals(LOGINFAILCODE)) {
//			String caid = obtainCaid(rqt);
//			if ((caid == null || caid.equals(""))) {
//				String checkcode = rqt
//						.getParameter(ACEGI_SECURITY_FORM_CHECKCODE_KEY);
//				if (checkcode == null) {
//					checkcode = "";
//				}
//				String sessionCode = (String) rqt.getSession(true)
//						.getAttribute(Constants_core.RANDOM_CHECKCODE);
//				if (sessionCode == null) {
//					sessionCode = "";
//				}
//				if (checkcode.equals("") || sessionCode.equals("")
//						|| !sessionCode.equals(checkcode)) {
//					rqt.getSession().setAttribute(
//							"SPRING_SECURITY_LAST_EXCEPTION",
//							new Exception("校验码不正确，登录失败！"));
//					rps.sendRedirect(rqt.getContextPath() + "/Index/"+CHECKCODE);
//				} else {
//					super.doFilter(req,res, chain); 
//				} 
//			} else { 
//				super.doFilter(req,res, chain); 
//			 } 
//		}else {
//			super.doFilter(req, res, chain);
//		}

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException,
			IOException, ServletException {
		String username = request.getParameter(usernameHeader);
		String password = request.getParameter(pasHeader);
		String caid = obtainCaid(request);
		String signature = "".equals(caid) ? null : caid;

		UsernamePasswordAuthenticationToken authRequest;
		if (signature != null) {
			authRequest = new CustomUsernamePasswordAuthenticationToken(null,
					null, signature);
			authRequest.setDetails(authenticationDetailsSource
					.buildDetails(request));

			return getAuthenticationManager().authenticate(authRequest);
		} else {
			authRequest = new UsernamePasswordAuthenticationToken(username,
					password);
			authRequest.setDetails(authenticationDetailsSource
					.buildDetails(request));
			return authRequest;
			// return getAuthenticationManager().authenticate(authRequest);
		}
	}

	public String obtainCaid(HttpServletRequest request) {
		// 直接从request中获取，避免session一直记录是ca登陆导致账户登陆报错
		String caid = (String) request.getAttribute(signatureHeader);
		// request.getSession(true).removeAttribute(signatureHeader);
		return caid;
	}

	protected final void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		SecurityContextHolder.getContext().setAuthentication(authResult);
		chain.doFilter(request, response);
	}

	protected void unsuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException failed)
			throws IOException, ServletException {
		SecurityContextHolder.clearContext();
		if (failed instanceof CustomAuthenticationException) {
			CustomAuthenticationException exception = (CustomAuthenticationException) failed;
			if (exception.getExcCode() == CustomAuthenticationException.CODE_CA) {
				request.setAttribute("errtype",
						String.valueOf(exception.getErrtype()));
				request.setAttribute("info", failed.getMessage());
				request.getRequestDispatcher(this.getAuthenticationCaFaileUrl())
						.forward(request, response);
			}
		} else {
			super.unsuccessfulAuthentication(request, response, failed);
		}
	}

}
