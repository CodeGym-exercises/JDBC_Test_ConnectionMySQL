package com.javatraining;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String CONN =
            "jdbc:mysql://localhost:3306/quanlysinhvien";
    Connection conn = null;

    public Connection connect() throws SQLException {

        try {
            conn = DriverManager.getConnection(CONN,USERNAME,PASSWORD);
            System.out.println("Connected! ");
        } catch (SQLException e) {
            System.err.println(e);
        }
        return conn;

    }
}
