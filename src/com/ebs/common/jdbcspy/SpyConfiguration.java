package com.ebs.common.jdbcspy;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.lang.ArrayUtils;

/**
 * Spy配置
 *
 * @工程： 核心4.0
 * @模块： 核心-常用-jdbcspy
 * 
 * @作者： 刘明磊
 * @创建日期： 2015年11月7日
 * 
 * @修改记录（修改时间、作者、原因）：
 */
public class SpyConfiguration {
    private static PropertiesConfiguration cfg = null;
    private static final String EXCLUDECATEGORIES = "excludecategories";
    private static final String REAL_DRIVER = "realdriver";
    private static final String JDBCSPY_PROPERTIES = "jdbcspy.properties";
    private static final String RELOAD = "reload";
    private static final String STACKTRACE = "stacktrace";
    private static final String CRYPT_ENABLE = "crypt.enable";
    private static final String CRYPT_PASSWORD = "crypt.password";
    private static final String CRYPT_SUFFIX = "crypt.suffix";

    static {
        try {
            if (cfg == null) {
                cfg = new PropertiesConfiguration("jdbcspy.properties");
                if (cfg.getBoolean("reload", false))
                    cfg.setReloadingStrategy(new FileChangedReloadingStrategy());
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static boolean isCategoryEnabled(String category) {
        return !ArrayUtils.contains(cfg.getStringArray("excludecategories"), category);
    }

    public static String[] getRealDriverClassNames() {
        return cfg.getStringArray("realdriver");
    }

    public static boolean isStackTraceEnabled() {
        return cfg.getBoolean("stacktrace", false);
    }

    public static boolean isCryptEnable() {
        return cfg.getBoolean("crypt.enable", false);
    }

    public static String getCryptPassword() {
        return cfg.getString("crypt.password", "xinyuan123");
    }

    public static String getCryptSuffix() {
        return cfg.getString("crypt.suffix", "<!des,64>");
    }
}