package com.ebs.service.xt.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ebs.common.util.ConvertUtils;
import com.ebs.common.util.ListUtil;
import com.ebs.service.impl.BaseServiceImpl;
import com.ebs.service.xt.iface.XtService;

/**
 * 工程： EPS 2.1</br>
 * 类名：XtServiceImpl</br>
 *
 * <p>功能描述：TODO</p>
 *
 * 作者： </br>
 * 创建日期： 2016年2月20日</br>
 * 修改记录：（修改时间、作者、原因）：</br>
 */
@Service("xtService")
public class XtServiceImpl extends BaseServiceImpl implements XtService {
	
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
	public List<Map<String, Object>> listXtgnParent(List<Map<String, Object>> xtgnList) {
		//结果列表
        List<Map<String, Object>> resultList = new ArrayList<>();
        
        if (xtgnList == null) {
            return new ArrayList<Map<String, Object>>();
        }
        
        //子模块缓存Map
        Map<String, List<Map<String, Object>>> mkMap = new HashMap<String, List<Map<String, Object>>>();
        
        //子功能缓存Map
        Map<String, List<Map<String, Object>>> gnMap = new HashMap<String, List<Map<String, Object>>>();
        
        String sql = "select id, jdmc, fid, jdlb, sxh from gg_xtgn where id = :gg_xtgn_id order by sxh";
        
        Map<String, Object> paramMap = new HashMap<String, Object>();
        
        //模块节点id
        String mkjd_id = null;
        
        //循环组织子功能缓存Map，键为子功能对应的上级子模块id，值为该上级子模块下属的所有子功能
        for (Map<String, Object> tempGnMap : xtgnList) {
            mkjd_id = ConvertUtils.createString(tempGnMap.get("fid")); 
            
            //当前子功能对应的上级子模块id在子功能缓存中已放入的值列表
            List<Map<String, Object>> tempGnList = gnMap.get(mkjd_id);
            
            if (tempGnList == null) {
                tempGnList = new ArrayList<Map<String, Object>>();
            }
            
            tempGnList.add(tempGnMap);
            gnMap.put(mkjd_id, tempGnList);
        }
        
        //子模块节点缓存
        Map<String, Object> mkjdCache = new HashMap<String, Object>();
        
        //系统节点id
        String xtjd_id = null;
        
        //循环组织子功能缓存Map，键为子功能对应的上级子模块id，值为该上级子模块下属的所有子功能
        for (Map<String, Object> xtgnMap : xtgnList) {
            mkjd_id = ConvertUtils.createString(xtgnMap.get("fid"));
            
            //当前子模块未被查询过
            if (!mkjdCache.containsKey(mkjd_id)) {
                paramMap.put("gg_xtgn_id", mkjd_id);
                
                Map<String, Object> mkjdMap = this.baseDaoEntity.selectSingleMap(sql, paramMap);
                
                //当前子功能对应的子模块不存在时，跳过
                if (mkjdMap == null || mkjdMap.isEmpty()) {
                    continue;
                }
                
                xtjd_id = ConvertUtils.createString(mkjdMap.get("fid"));
                
                //当前子模块对应的上级子系统id在子模块缓存中已放入的值列表
                List<Map<String, Object>> tempMkList = mkMap.get(xtjd_id);
                
                if (tempMkList == null) {
                    tempMkList = new ArrayList<Map<String, Object>>();
                }
                
                mkjdMap.put("nocheck", true);   //ztree时，不允许选择
                tempMkList.add(mkjdMap);
                
                mkMap.put(xtjd_id, tempMkList);
                
                //加入模块节点id缓存
                mkjdCache.put(mkjd_id, mkjd_id);
            }
        }
        
        //循环组织子系统、子模块、子功能列表
        for (String xtjdxh : mkMap.keySet()) {
            Map<String, Object> xtjdMap = new HashMap<>();
            
            //组织当前子系统级功能节点信息
            sql = "select id, jdmc, fid, jdlb, sxh from gg_xtgn where id = :gg_xtgn_id order by sxh";
            
            paramMap.put("gg_xtgn_id", xtjdxh);
            
            Map<String, Object> xtjdMap_temp = this.baseDaoEntity.selectSingleMap(sql, paramMap);
            
            //当前子系统不存在时，跳过
            if (xtjdMap_temp == null || xtjdMap_temp.isEmpty()) {
                continue;
            }
            
            xtjdMap.put("id", xtjdMap_temp.get("id"));
            xtjdMap.put("fid", xtjdMap_temp.get("fid"));
            xtjdMap.put("jdmc", xtjdMap_temp.get("jdmc"));
            xtjdMap.put("jdlb", xtjdMap_temp.get("jdlb"));
            xtjdMap.put("sxh", xtjdMap_temp.get("sxh"));
            xtjdMap.put("nocheck", true);
            
            //从子模块缓存中获取当前子系统下属的子模块列表
            List<Map<String, Object>> tempMkList = mkMap.get(xtjdxh);
            
            if (tempMkList == null) {
                tempMkList = new ArrayList<Map<String, Object>>();
            } else {
                for (Map<String, Object> tempMkMap : tempMkList) {
                    mkjd_id = ConvertUtils.createString(tempMkMap.get("id"));
                    
                    //从子功能缓存中获取当前子模块下属的子功能列表
                    List<Map<String, Object>> tempGnList = gnMap.get(mkjd_id);
                    
                    if (tempGnList == null) {
                        tempGnList = new ArrayList<Map<String, Object>>();
                    }
                    
                    //放入当前子模块下属的子功能列表
                    tempMkMap.put("gnList", ListUtil.sortListByIntKey(tempGnList, "sxh"));
                }
            }
            
            xtjdMap.put("mkList", ListUtil.sortListByIntKey(tempMkList, "sxh"));
            resultList.add(xtjdMap);
        }
        
        return ListUtil.sortListByIntKey(resultList, "sxh");
	}
	
}
