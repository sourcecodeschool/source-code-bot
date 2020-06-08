package ru.javacourse.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
    private static Connection getH2Connection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:");
    }
}
