package com.ebs.model;

import java.io.Serializable;

/**
 * 所有值对象的超类
 * 
 * @author 李小江
 * 
 */
public abstract class BasePO implements ISqlTemplate, Serializable {
    /**
     * 数字类型标识
     */
    public static final String KEY_TYPE_INT = "INTEGER";

    /**
     * 字符类型标识
     */
    public static final String KEY_TYPE_STRING = "STRING";

    /**
     * 长整型类型标识
     */
    public static final String KEY_TYPE_LONG = "LONG";

    /**
     * 精度类型标识
     */
    public static final String KEY_TYPE_DOUBLE = "DOUBLE";

    // 整形数据初始化值
    protected static final int INT_INIT_VALUE = Integer.MAX_VALUE;

    // 长整形数值初始化值
    protected static final long LONG_INIT_VALUE = Long.MAX_VALUE;

    // 双精度数值初始化值
    protected static final double DOUBLE_INIT_VALUE = Double.parseDouble(Double.toString(Double.MAX_VALUE));

    protected BasePO() {
        initialize();
    }

    protected void initialize() {
    }

    /**
     * 获取PO所对应数据表的别名
     */
    public String getStrAliasName() {
        String strAliasName = "";
        String strTableName = this.getStrTableName();
        if (strTableName.length() > 1) {
            strAliasName = strTableName.substring(0, 1).toLowerCase() + strTableName.substring(1, strTableName.length());
        }
        return strAliasName;
    }

}
