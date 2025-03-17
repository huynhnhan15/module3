package com.codgym.quan_li_san_pham_db.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String URL ="jdbc:mysql://localhost:3306/phone_management";
    private static final String USER = "root";
    private static final String PASS = "codegym";

    public static Connection getConnectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}