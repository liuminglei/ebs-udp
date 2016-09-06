package com.ebs.common.util;

/**
 * 分页对象工具类
 *
 * @工程： eps-core-4.0
 * @模块： 工具
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年10月29日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class SplitPageUtil {
    
    /**
     * 获取分页sql语句
     *
     * @作者： 刘明磊
     * @创建日期：2015年10月29日
     *
     * @参数: sql 待显示页查询的sql语句
     * @参数: currentPage 当前页码
     * @参数: pageRowBegin 待显示页起始记录号
     * @参数: pageRowEnd 待显示页终止记录号
     * @返回值: String
     *
     * @修改记录（修改时间、作者、原因）：
     */
    public static String getLimitString(String sql, int currentPage, int pageRowBegin, int pageRowEnd) {
        StringBuffer pagingSelect = new StringBuffer();
        
        pagingSelect.append("select total.* from (" + sql + ")");
        
        if (currentPage != 1) {
            pagingSelect.append(" total limit " + pageRowBegin + ", " + pageRowEnd);
        } else {
            pagingSelect.append(" total limit 0, " + pageRowEnd);
        }
        return pagingSelect.toString();
    }
    
    /**
     * 获取分页sql语句
     *
     * @作者： 刘明磊
     * @创建日期：2015年10月29日
     *
     * @参数: sql 待显示页查询的sql语句
     * @参数: pageRowBegin 待显示数据起始行数
     * @参数: pageSize 待显示行数
     * @返回值: String
     *
     * @修改记录（修改时间、作者、原因）：
     */
    public static String getLimitString(String sql, int pageRowBegin, int pageSize) {
        StringBuffer pagingSelect = new StringBuffer();
        
        pagingSelect.append("select total.* from (" + sql + ")");
        
        pagingSelect.append(" total limit " + (pageRowBegin == 0 ? 0 : pageRowBegin - 1) + ", " + pageSize);
        
        return pagingSelect.toString();
    }
    
}
