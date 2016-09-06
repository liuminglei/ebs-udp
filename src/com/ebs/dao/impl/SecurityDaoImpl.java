package com.ebs.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.ebs.dao.iface.SecurityDao;

/**
 * 工程： e招标</br>
 * 类名：SecurityDaoImpl</br>
 *
 * <p>功能描述：安全机制数据库层实现</p>
 *
 * 作者： 刘明磊</br>
 * 创建日期： 2016年2月20日</br>
 * 修改记录：（修改时间、作者、原因）：</br>
 */
@Service("securityDao")
public class SecurityDaoImpl extends BaseDaoImpl implements SecurityDao {
	
	/**
     * 方法名: getResources</br>
     * 方法描述: 获取系统资源信息</br>
     * </br>
     * 创建时间: 2016年2月20日</br>
     * 修改记录（修改时间、作者、原因）: </br>
     *
     * @return List<Map<String, Object>>
     * @author 刘明磊
     */
    public List<Map<String, Object>> getResources() {
    	String sql = "select gn.gndz, lbgn.lbbh\n" +
                "  from gg_lbgn lbgn, gg_xtgn gn\n" + 
                " where gn.id = lbgn.gnbh\n" + 
                "   and gn.kzinfo is null\n" + 
                "   and gn.jdlb = 2 order by gndz";

        return this.baseDaoEntity.queryForList(sql, new HashMap<String, Object>());
    }
    
    /**
     * 方法名: getRoleByUser</br>
     * 方法描述: 通过操作员ID获取操作员角色信息</br>
     * </br>
     * 创建时间: 2016年2月20日</br>
     * 修改记录（修改时间、作者、原因）: </br>
     *
     * @param gg_czyb_id 操作员id
     * @return Map<String, Object>
     * @author 刘明磊
     */
    public List<Map<String, Object>> getRoleByUser(String gg_czyb_id) {
    	String sql = "select distinct lbbh from gg_czylb where rybh = :gg_czyb_id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("gg_czyb_id", gg_czyb_id);
        return this.baseDaoEntity.getParaJdbcTemplate().queryForList(sql, parameterSource);
    }
    
    /**
     * 方法名: getCzyById</br>
     * 方法描述: 通过操作员ID获取操作员信息</br>
     * </br>
     * 创建时间: 2016年2月20日</br>
     * 修改记录（修改时间、作者、原因）: </br>
     *
     * @param gg_czyb_id 操作员id
     * @return Map<String, Object>
     * @author 刘明磊
     */
    public Map<String, Object> getCzyById(String gg_czyb_id) {
    	String sql = "select id, mm, sybz from gg_czyb where dlh = :gg_czyb_id";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gg_czyb_id", gg_czyb_id);
        
        return this.baseDaoEntity.queryForMap(sql, paramMap);
    }
    
    /**
     * 方法名: getCzyByDlh</br>
     * 方法描述: 通过登录号获取操作员信息</br>
     * </br>
     * 创建时间: 2016年2月20日</br>
     * 修改记录（修改时间、作者、原因）: </br>
     *
     * @param gg_czyb_dlh 操作员CA序号
     * @return Map<String, Object>
     * @author 刘明磊
     */
    public Map<String, Object> getCzyByDlh(String gg_czyb_dlh) {
    	String sql = "select id, dlh, mm, sybz from gg_czyb where dlh = :gg_czyb_dlh";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gg_czyb_dlh", gg_czyb_dlh);
        
        return this.baseDaoEntity.selectSingleMap(sql, paramMap);
    }
    
    /**
     * 方法名: getCzyByCaid</br>
     * 方法描述: 通过CA号获取操作员信息</br>
     * </br>
     * 创建时间: 2016年2月20日</br>
     * 修改记录（修改时间、作者、原因）: </br>
     *
     * @param gg_czyb_caid 操作员CA序号
     * @return Map<String, Object>
     * @author 刘明磊
     */
    public Map<String, Object> getCzyByCaid(String gg_czyb_caid) {
    	String sql = "select id, dlh, mm, cabz from gg_czyb where czid = :gg_czyb_caid";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gg_czyb_caid", gg_czyb_caid);
        
        return this.baseDaoEntity.queryForMap(sql, paramMap);
    }
	
}
