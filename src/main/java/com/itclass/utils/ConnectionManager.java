package com.itclass.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private final String url;
    private final String login;
    private final String password;
    private final String driver;

    public static final ConnectionManager INSTANCE = new ConnectionManager();

    public ConnectionManager() {
        url = DbProperties.getProperty("db.url");
        login = DbProperties.getProperty("db.login");
        password = DbProperties.getProperty("db.password");
        driver = DbProperties.getProperty("db.driver");
    }

    public Connection getConnection() {

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return null;
    }
}
