package com.ebs.common.jdbcspy;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Spy驱动
 *
 * @工程： 核心4.0
 * @模块： 核心-常用-jdbcspy
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年11月7日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class SpyDriver implements Driver {
    private static final String SPY = "spy:";

    static {
        try {
            //注册驱动
            DriverManager.registerDriver(new SpyDriver());
            try {
                for (String driverClassName : SpyConfiguration.getRealDriverClassNames())
                    Class.forName(driverClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new RuntimeException("com.zzxy.common.jdbcspy.SpyDriver does not support getParentLogger()");
    }

    public boolean acceptsURL(String url) throws SQLException {
        SpyLog.info(this, "acceptsURL", new Object[] { url + " : return " + url.startsWith("spy:") });
        return url.startsWith("spy:");
    }

    public Connection connect(String url, Properties info) throws SQLException {
        SpyLog.info(this, "connect", new Object[] { url });
        if (acceptsURL(url)) {
            return new SpyConnection(DriverManager.getDriver(getRealUrl(url)).connect(getRealUrl(url), info));
        }
        return DriverManager.getDriver(getRealUrl(url)).connect(url, info);
    }

    public int getMajorVersion() {
        throw new RuntimeException("com.zzxy.common.jdbcspy.SpyDriver does not support getMajorVersion()");
    }

    public int getMinorVersion() {
        throw new RuntimeException("com.zzxy.common.jdbcspy.SpyDriver does not support getMinorVersion()");
    }

    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        throw new RuntimeException("com.zzxy.common.jdbcspy.SpyDriver does not support getPropertyInfo(String url, Properties info)");
    }

    public boolean jdbcCompliant() {
        throw new RuntimeException("com.zzxy.common.jdbcspy.SpyDriver does not support jdbcCompliant()");
    }

    private String getRealUrl(String url) {
        if (url.startsWith("spy:")) {
            return url.substring("spy:".length());
        }
        return url;
    }
}