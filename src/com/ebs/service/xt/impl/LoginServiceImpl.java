package com.ebs.service.xt.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.dao.xt.iface.LoginDao;
import com.ebs.service.xt.iface.LoginService;

/**
 * 工程： e招标</br>
 * 类名：LoginServiceImpl</br>
 *
 * <p>功能描述：TODO</p>
 *
 * 作者： </br>
 * 创建日期： 2016年2月20日</br>
 * 修改记录：（修改时间、作者、原因）：</br>
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	/**
	 * 方法名: listXtgn</br>
	 * 方法描述: TODO 请填写方法描述</br>
	 * </br>
	 * 创建时间: 2016年2月20日</br>
	 * 修改记录（修改时间、作者、原因）: </br>
	 *
	 * @return
	 * @author 
	 */
	public List<Map<String, Object>> listXtgn() {
		return loginDao.listXtgn();
	}
	
}
