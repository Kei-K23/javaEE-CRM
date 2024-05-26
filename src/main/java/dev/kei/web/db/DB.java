package dev.kei.web.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private static Connection connection;

	// singleton pattern
	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				// hide credentials
				String dbURL = "jdbc:mysql://localhost:3306/javaEE-crm";
				String dbUsername = "root";
				String password = "keik23012023";

				connection = DriverManager.getConnection(dbURL, dbUsername, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
