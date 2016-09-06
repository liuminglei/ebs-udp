package com.ebs.dao.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ebs.common.SplitPageInfo;
import com.ebs.common.util.SplitPageUtil;

@Repository("jdbcSplitEntity")
public class JdbcSplitEntity {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private NamedParameterJdbcTemplate paraJdbcTemplate;

    /**
     * 查询分页列表
     *
     * @作者： 刘明磊
     * @创建日期：2015年12月14日
     *
     * @参数: list 不带分页列表
     * @参数: splitPageInfo 分页对象
     * @返回值: List<Map<String, Object>>
     *
     * @修改记录（修改时间、作者、原因）：
     */
    public List<Map<String, Object>> selectSplit(String sql, SplitPageInfo splitPageInfo) {
        String sqlTemp = sql;
        
        if (StringUtils.isNotEmpty(splitPageInfo.getSbSqlWhere())) {
            sqlTemp = sqlTemp + " where " + splitPageInfo.getSbSqlWhere();
        }
        
        StringBuffer strCountSql = new StringBuffer("select count(*) from (" + sqlTemp + ") total");
        
        int count = queryForInt(strCountSql.toString(), new HashMap<String, Object>());
        
        splitPageInfo.setTotalRowsAmount(count);
        
        String strSql = SplitPageUtil.getLimitString(sqlTemp, splitPageInfo.getPageRowBegin(), splitPageInfo.getPageSize());
        
        return paraJdbcTemplate.queryForList(strSql, new HashMap<String, Object>());
    }

    /**
     * 查询分页列表
     *
     * @作者： 刘明磊
     * @创建日期：2015年12月14日
     *
     * @参数: list 不带分页列表
     * @参数: paramMap 查询参数
     * @参数: splitPageInfo 分页对象
     * @返回值: List<Map<String, Object>>
     *
     * @修改记录（修改时间、作者、原因）：
     */
    public List<Map<String, Object>> selectSplit(String sql, Map<String, Object> paramMap, SplitPageInfo splitPageInfo) {
        String sqlTemp = sql;
        
        if (StringUtils.isNotEmpty(splitPageInfo.getSbSqlWhere())) {
            sqlTemp = sqlTemp + " where " + splitPageInfo.getSbSqlWhere();
        }
        
        StringBuffer strCountSql = new StringBuffer("select count(*) from (" + sqlTemp + ") total");
        
        int count = queryForInt(strCountSql.toString(), paramMap);
        
        splitPageInfo.setTotalRowsAmount(count);
        
        String strSql = SplitPageUtil.getLimitString(sqlTemp, splitPageInfo.getPageRowBegin(), splitPageInfo.getPageSize());
        
        return paraJdbcTemplate.queryForList(strSql, paramMap);
    }
    
    /**
     * 查询分页列表
     *
     * @作者： 刘明磊
     * @创建日期：2015年12月14日
     *
     * @参数: list 不带分页列表
     * @参数: parameterSource 查询参数
     * @参数: splitPageInfo 分页对象
     * @返回值: List<Map<String, Object>>
     *
     * @修改记录（修改时间、作者、原因）：
     */
    public List<Map<String, Object>> selectSplit(String sql, SqlParameterSource parameterSource, SplitPageInfo splitPageInfo) {
        String sqlTemp = sql;
        
        if (StringUtils.isNotEmpty(splitPageInfo.getSbSqlWhere())) {
            sqlTemp = sqlTemp + " where " + splitPageInfo.getSbSqlWhere();
        }
        
        StringBuffer strCountSql = new StringBuffer("select count(*) from (" + sqlTemp + ") total");
        
        int count = queryForInt(strCountSql.toString(), parameterSource);
        
        splitPageInfo.setTotalRowsAmount(count);
        
        String strSql = SplitPageUtil.getLimitString(sqlTemp, splitPageInfo.getPageRowBegin(), splitPageInfo.getPageSize());
        
        return paraJdbcTemplate.queryForList(strSql, parameterSource);
    }

    /**
     * 查询分页列表
     *
     * @作者： 刘明磊
     * @创建日期：2015年12月14日
     *
     * @参数: list 不带分页列表
     * @参数: splitPageInfo 分页对象
     * @返回值: List<Map<String, Object>>
     *
     * @修改记录（修改时间、作者、原因）：
     */
    public List<Map<String, Object>> selectSplit(List<Map<String, Object>> list, SplitPageInfo splitPageInfo) {
        splitPageInfo.setTotalRowsAmount(list == null ? 0 : list.size());
        
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        
        if (list == null) {
            return null;
        } else {
            for (int i = splitPageInfo.getPageRowBegin() - 1; 0 <= i && i < splitPageInfo.getPageRowEnd(); i++) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    /**
     * 获取int类型字段值
     *
     * @作者： 刘明磊
     * @创建日期：2015年12月14日
     *
     * @参数: sql sql语句
     * @参数: paramMap 查询参数
     * @返回值: int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    private int queryForInt(String sql, Map<String, Object> paramMap) {
        return queryForInt(sql, new MapSqlParameterSource(paramMap));
    }
    
    /**
     * 获取int类型字段值
     *
     * @作者： 刘明磊
     * @创建日期：2015年12月14日
     *
     * @参数: sql sql语句
     * @参数: parameterSource 查询参数
     * @返回值: int
     *
     * @修改记录（修改时间、作者、原因）：
     */
    private int queryForInt(String sql, SqlParameterSource parameterSource) {
        Integer resultInt = this.paraJdbcTemplate.queryForObject(sql, parameterSource, Integer.class);
        
        return resultInt == null ? 0 : resultInt.intValue();
    }
    
}
