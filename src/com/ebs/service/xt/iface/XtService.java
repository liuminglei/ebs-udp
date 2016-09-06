package com.ebs.service.xt.iface;

import java.util.List;
import java.util.Map;

import com.ebs.service.iface.BaseService;

/**
 * 工程： EPS 2.1</br>
 * 类名：XtService</br>
 *
 * <p>功能描述：TODO</p>
 *
 * 作者： </br>
 * 创建日期： 2016年2月20日</br>
 * 修改记录：（修改时间、作者、原因）：</br>
 */
public interface XtService extends BaseService {
	
	/**
	 * 方法名: listXtgnParent</br>
	 * 方法描述: TODO 请填写方法描述</br>
	 * </br>
	 * 创建时间: 2016年2月20日</br>
	 * 修改记录（修改时间、作者、原因）: </br>
	 *
	 * @param xtgnList
	 * @return
	 * @author 
	 */
	public List<Map<String, Object>> listXtgnParent(List<Map<String, Object>> xtgnList);
	
}
