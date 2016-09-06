package com.ebs.model;

import java.util.Map;

/**
 * sql语句模板接口
 * 
 * @author 李小江
 * 
 */
public interface ISqlTemplate {
    /**
     * 获取数据表名
     *  
     * @return 数据表名
     */
    public String getStrTableName();

    /**
     * 获取数据表别名
     * 
     * @return 数据表别名
     */
    public String getStrAliasName();

    /**
     * 获取数据表主键值
     * 
     * @return 数据表主键值
     */
    public StringBuffer getStrPKValues();

    /**
     * 获取数据表主键字段名称
     * 
     * @return 主键字段名称
     */
    public StringBuffer getStrPrimaryKeys();

    /**
     * 获取数据表字段名称列表,用","分隔。例如:id, name, sex
     * 
     * @return 数据表字段名称列表
     */
    public StringBuffer getStrFields();

    /**
     * 获取数据表精确查询条件
     * 
     * @return 精确查询条件
     */
    public StringBuffer getStrExactWhere();

    /**
     * 获取数据表主键查询条件
     * 
     * @return 数据表主键查询条件
     */
    public StringBuffer getStrKeyWhere();

    /**
     * 获取数据表模糊查询条件
     * 
     * @return 数据表模糊查询条件
     */
    public StringBuffer getStrWhere();

    /**
     * 获取数据表更新字段值sql片段,例如:id = 1, name = 'jack', sex = '女'
     * 
     * @return 数据表更新字段值sql片段
     */
    public StringBuffer getStrUpdValues();

    /**
     * 获取数据表新增字段值sql片段,例如:1, 'jack', '女'
     * 
     * @return 新增字段值sql片段
     */
    public StringBuffer getStrInsValues();
    
    //构建带参数的插入语句；例如：“id, sxh”
    public StringBuffer getStrInsFields();
    
    //构建带参数的插入语句；例如：“：id, :sxh”
    public StringBuffer getStrInsParFields();
    
    //构建带参数的更新语句；例如："sxh=:sxh, rybh=:rybh"
    public StringBuffer getStrUpdParFields();

    //构建传参式的条件语句；例如："id=：idWhy"
    public StringBuffer getStrKeyParWhere();
    
    //构建传入参数式插入的值Map。返回Map<String, Object>
    public Map<String, Object> getMapInsParValues();
    
    //构建传入参数式更新的值Map。返回Map<String, Object>
    public Map<String, Object> getMapUpdParValues();
    
}
