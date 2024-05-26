package dev.kei.web.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private static Connection connection;

	private DB() {
		// private constructor to prevent instantiation
	}

	// singleton pattern
	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				// hide credentials
				String dbURL = "jdbc:mysql://localhost:3306/javaEE-crm";
				String dbUsername = "root";
				String dbPassword = "keik23012023";

				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

				// Create new connection
				connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			} catch (Exception e) {
				throw new SQLException("Failed to connect to the database: " + e.getMessage());
			}
		}
		return connection;
	}
}
