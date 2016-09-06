package com.ebs.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 工程： e招标</br>
 * 类名：ListUtil</br>
 *
 * <p>功能描述：列表工具类</p>
 *
 * 作者： 刘明磊</br>
 * 创建日期： 2016年2月20日</br>
 * 修改记录：（修改时间、作者、原因）：</br>
 */
public class ListUtil {

    /**
     * 方法名: sortListByIntKey</br>
     * 方法描述: 冒泡法使用整形排序字段进行列表排序</br>
     * </br>
     * 创建时间: 2016年2月20日</br>
     * 修改记录（修改时间、作者、原因）: </br>
     *
     * @param sortList 待排序列表
     * @param key 排序字段
     * @return List<Map<String, Object>>
     * @author 刘明磊
     */
    public static List<Map<String, Object>> sortListByIntKey(List<Map<String, Object>> sortList, String key) {
        if (sortList == null || sortList.isEmpty() || StringUtils.isBlank(key)) {
            return new ArrayList<Map<String, Object>>();
        }

        for (int i = 0; i < sortList.size(); i++) {
            int prevIndex = ConvertUtils.toInt(sortList.get(i).get(key));

            for (int j = i + 1; j < sortList.size(); j++) {
                int nextIndex = ConvertUtils.toInt(sortList.get(j).get(key));

                if (prevIndex > nextIndex) {
                    Map<String, Object> temp = sortList.get(i);
                    sortList.set(i, sortList.get(j));
                    sortList.set(j, temp);
                }
            }
        }
        return sortList;
    }
    
    /**
     * 方法名: sortListByLongIndex</br>
     * 方法描述: 冒泡法使用整形排序字段进行列表排序</br>
     * </br>
     * 创建时间: 2016年2月20日</br>
     * 修改记录（修改时间、作者、原因）: </br>
     *
     * @param sortList 待排序列表
     * @param key 排序字段
     * @return List<Map<String, Object>>
     * @author 刘明磊
     */
    public static List<Map<String, Object>> sortListByLongIndex(List<Map<String, Object>> sortList, String key) {
        if (sortList == null || sortList.isEmpty() || StringUtils.isBlank(key)) {
            return new ArrayList<Map<String, Object>>();
        }

        for (int i = 0; i < sortList.size(); i++) {
            long prevIndex = ConvertUtils.createLong(sortList.get(i).get(key));

            for (int j = i + 1; j < sortList.size(); j++) {
                long nextIndex = ConvertUtils.createLong(sortList.get(j).get(key));

                if (prevIndex > nextIndex) {
                    Map<String, Object> temp = sortList.get(i);
                    sortList.set(i, sortList.get(j));
                    sortList.set(j, temp);
                }
            }
        }
        return sortList;
    }
    
}
