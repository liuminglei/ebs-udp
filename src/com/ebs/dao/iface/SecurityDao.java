package com.ebs.dao.iface;

import java.util.List;
import java.util.Map;

/**
 * 工程： e招标</br>
 * 类名：SecurityDao</br>
 *
 * <p>功能描述：安全机制数据库层接口</p>
 *
 * 作者： 刘明磊</br>
 * 创建日期： 2016年2月20日</br>
 * 修改记录：（修改时间、作者、原因）：</br>
 */
public interface SecurityDao extends BaseDao {

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
    public List<Map<String, Object>> getResources();
    
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
    public List<Map<String, Object>> getRoleByUser(String gg_czyb_id);
    
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
    public Map<String, Object> getCzyById(String gg_czyb_id);
    
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
    public Map<String, Object> getCzyByDlh(String gg_czyb_dlh);
    
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
    public Map<String, Object> getCzyByCaid(String gg_czyb_caid);
    
}
