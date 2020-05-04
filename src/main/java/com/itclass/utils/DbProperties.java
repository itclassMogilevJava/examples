package com.itclass.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbProperties {

    public static final String PATH_TO_PROREPRTIES = "/db/db.properties";
    private static final DbProperties INSTANSE = new DbProperties();

    private final Properties properties;

    private DbProperties() {

        properties = new Properties();
        try (InputStream fis = DbProperties.class.getResourceAsStream(PATH_TO_PROREPRTIES)) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Database properties file is not exist." + e.getMessage());
        }
    }

    public static Properties getProperties() {
        return DbProperties.INSTANSE.properties;
    }

    public static String getProperty(String name) {
        return DbProperties.INSTANSE.properties.getProperty(name);
    }
}