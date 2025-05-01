package com.orangehrm.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    private static final Properties properties = new Properties();
    private static final String CONFIG_FILE = "src/test/resources/config.properties";

    static {
        try {
            properties.load(new FileInputStream(CONFIG_FILE));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + CONFIG_FILE, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }

    public static String getAdminUsername() {
        return getProperty("admin.username");
    }

    public static String getAdminPassword() {
        return getProperty("admin.password");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }
} 