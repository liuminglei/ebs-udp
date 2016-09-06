package com.ebs.controller.xt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebs.service.xt.iface.LoginService;

/**
 * 工程： EPS 2.1</br>
 * 类名：LoginController</br>
 *
 * <p>功能描述：TODO</p>
 *
 * 作者： </br>
 * 创建日期： 2016年2月20日</br>
 * 修改记录：（修改时间、作者、原因）：</br>
 */
@Controller
@RequestMapping("login/")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("main.do")
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException {
		Authentication au = null;
		if (SecurityContextHolder.getContext() != null) {
			au = SecurityContextHolder.getContext().getAuthentication();
		}
		
		if ((au == null) || (au.getName() == null) || (au.getName().length() == 0) || au.getName().equals("anonymousUser")) {
			//SecurityContextHolder.clearContext();
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			return "SysMainHome";
		} else {
//			GG_CZYB czyb = loginService.getCzybByDlh(au.getName());
//			GG_JGXX jgxx = loginService.getJgxx(czyb.getJgbh());
			System.out.println("login username:>>>>>>>>>>"+au.getName());
//			//将当前操作员，所属机构，是否超管信息存入SESSION
//			request.getSession().setAttribute(Constants_xt.SESSION_USER, czyb);
//			request.getSession().setAttribute(Constants_xt.SESSION_JGXX, jgxx);
//			request.getSession().setAttribute(Constants_xt.SESSION_ISSUPERADMIN, czyb.getDlh().equals("superadmin"));
//			request.getSession().setAttribute("curMenu", "");
			return "SysMainHome";
		}
	}
	
	@RequestMapping("menu.do")
	public String tree(HttpServletRequest request, ModelMap model) {
//		GG_CZYB czyb = (GG_CZYB)request.getSession().getAttribute(Constants_xt.SESSION_USER);
		model.addAttribute("listXtgn", loginService.listXtgn());
		return "Menu";
	}
	
	@RequestMapping("desk.do")
	public String toDesk(HttpServletRequest request, ModelMap model) {
		return "desk/DefaultDesk";
	}
	
}
