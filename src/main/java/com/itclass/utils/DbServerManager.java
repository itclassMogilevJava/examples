package com.itclass.utils;

import org.h2.tools.Server;

import java.sql.SQLException;

public class DbServerManager {

    private Server server;

    private DbServerManager() {

        String tcpPort = DbProperties.getProperty("db.tcpPort");
        String[] args = new String[]{"-webPort", tcpPort, "-webAllowOthers"};
        try {
            server = Server.createWebServer(args);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static class DbServerHelper {
        private static final DbServerManager INSTANSE = new DbServerManager();
    }

    private Server getServer() {
        return server;
    }

    public static DbServerManager getInstance() {
        return DbServerManager.DbServerHelper.INSTANSE;
    }

    public static void start() {
        try {
            DbServerManager.getInstance().getServer().start();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void stop() {

        DbServerManager.getInstance().getServer().stop();
    }
}