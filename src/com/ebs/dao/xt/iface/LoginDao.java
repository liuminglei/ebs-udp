package com.ebs.dao.xt.iface;

import java.util.List;
import java.util.Map;

import com.ebs.dao.iface.BaseDao;

/**
 * 工程： EPS 2.1</br>
 * 类名：LoginDao</br>
 *
 * <p>功能描述：TODO</p>
 *
 * 作者： </br>
 * 创建日期： 2016年2月20日</br>
 * 修改记录：（修改时间、作者、原因）：</br>
 */
public interface LoginDao extends BaseDao {
	
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
	public List<Map<String, Object>> listXtgn();
}
