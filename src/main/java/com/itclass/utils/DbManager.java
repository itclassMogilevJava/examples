package com.itclass.utils;

import org.h2.tools.RunScript;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class DbManager {
    public static final String SQL_CREATE_PATH = "/sql/createTables.sql";
    public static final String SQL_INSERT_PATH = "/sql/insertData.sql";

    private DbManager(){}

    public static void initDb(ConnectionManager manager) {

        try (Connection con = manager.getConnection()) {
            executeScript(con, SQL_CREATE_PATH);
            executeScript(con, SQL_INSERT_PATH);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void executeScript(Connection con, String sqlPath) {

        try (InputStreamReader ipr = new InputStreamReader(
                DbManager.class.getResourceAsStream(sqlPath))) {
            RunScript.execute(con, ipr);
        } catch (IOException | SQLException e) {
            System.err.println(e);
        }
    }
}
