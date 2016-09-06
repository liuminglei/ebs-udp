package com.ebs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.dao.entity.BaseDaoEntity;
import com.ebs.service.iface.BaseService;

/**
 * 工程： EPS 2.1</br>
 * 类名：BaseServiceImpl</br>
 *
 * <p>功能描述：TODO</p>
 *
 * 作者： </br>
 * 创建日期： 2016年2月20日</br>
 * 修改记录：（修改时间、作者、原因）：</br>
 */
@Service("baseService")
public class BaseServiceImpl implements BaseService {
	@Autowired
	protected BaseDaoEntity baseDaoEntity;
	
}
