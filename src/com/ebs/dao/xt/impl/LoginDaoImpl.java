package com.ebs.dao.xt.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebs.dao.impl.BaseDaoImpl;
import com.ebs.dao.xt.iface.LoginDao;
import com.ebs.service.xt.iface.XtService;

/**
 * 工程： EPS 2.1</br>
 * 类名：LoginDaoImpl</br>
 *
 * <p>功能描述：TODO</p>
 *
 * 作者： </br>
 * 创建日期： 2016年2月20日</br>
 * 修改记录：（修改时间、作者、原因）：</br>
 */
@Repository("loginDao")
public class LoginDaoImpl extends BaseDaoImpl implements LoginDao {

	@Autowired
	private XtService xtService;
	
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
		List<Map<String, Object>> gnList = new ArrayList<>();
		
		String sql = "";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		//查询功能列表
        sql = "select gg_xtgn.id,\n" +
            "       gg_xtgn.jdmc,\n" + 
            "       gg_xtgn.gnsm,\n" + 
            "       gg_xtgn.gndz,\n" + 
            "       gg_xtgn.fid,\n" + 
            "       gg_xtgn.jdlb,\n" + 
            "       gg_xtgn.sxh\n" + 
            "  from gg_xtgn, gg_lbgn\n" + 
            " where gg_xtgn.id = gg_lbgn.gnbh\n" + 
            "   and gg_xtgn.jdlb = :gg_xtgn_jdlb\n" + 
            "   and gg_lbgn.lbbh = :gg_czlb_id\n" + 
            " order by sxh";
        
        paramMap.put("gg_xtgn_jdlb", 2);
        paramMap.put("gg_czlb_id", "1");
        
        gnList = this.baseDaoEntity.queryForList(sql, paramMap);
        
        gnList = xtService.listXtgnParent(gnList);
        
        return gnList;
	}
	
}
