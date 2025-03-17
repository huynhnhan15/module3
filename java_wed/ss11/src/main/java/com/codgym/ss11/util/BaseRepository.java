package com.codgym.ss11.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/quan_li_san_pham"; // ✅ Kiểm tra lại tên CSDL
    private static final String USER = "root";
    private static final String PASS = "codegym";

    public static Connection getConnectDB() {
        Connection connection = null;
        try {
            // ✅ Kiểm tra driver đã được load hay chưa
            Class.forName("com.mysql.cj.jdbc.Driver");

            // ✅ Kết nối CSDL
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Kết nối CSDL thành công!"); // In ra để debug
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Lỗi: Không tìm thấy Driver JDBC!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Lỗi: Kết nối CSDL thất bại! Kiểm tra lại thông tin kết nối.");
            e.printStackTrace();
        }
        return connection;
    }
}
