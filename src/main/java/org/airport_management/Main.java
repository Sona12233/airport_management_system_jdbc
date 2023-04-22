package org.airport_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "sql2023";

    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection(url, user, password);

        con.close();
    }
}