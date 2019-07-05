package org.moriadry.nacos.grpc.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigResult {

    private static final Logger log = LoggerFactory.getLogger(ConfigResult.class);
    public static final PropertiesConfiguration config = ConfigResult.ResultConfigHolder.initConfig();
    public static final String NACOS_URI;
    public static final int GRPC_PORT;

    public ConfigResult() {
    }

    public static String getMessageOverStatus(int status) {
        return config.getString(String.valueOf(status), "default");
    }

    static {
        GRPC_PORT = config.getInt("GRPC_PORT", -1);
        NACOS_URI= config.getString("NACOS_URI", "http://127.0.0.1:8848");
    }

    public static class ResultConfigHolder {
        public static PropertiesConfiguration config = null;

        public ResultConfigHolder() {
        }

        public static PropertiesConfiguration initConfig() {
            if (null == config) {
                try {
                    config = new PropertiesConfiguration();
                    config.setEncoding("UTF-8");
                    config.load("config.properties");
                    FileChangedReloadingStrategy change = new FileChangedReloadingStrategy();
                    change.setRefreshDelay(1800000L);
                    config.setReloadingStrategy(change);
                    return config;
                } catch (ConfigurationException var1) {
//                    throw new IllegalArgumentException("无法加载配置");
                    log.error("无法加载配置");
                    return null;
                }
            } else {
                return config;
            }
        }
    }

}
