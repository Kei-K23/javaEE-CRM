package dev.kei.web.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import dev.kei.web.db.DB;
import dev.kei.web.entity.User;

public class UserRepository {

	private static final Logger logger = Logger.getLogger(UserRepository.class.getName());

	public List<User> findAll() {
		try (Connection connection = DB.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM users");

		) {
			logger.info("Retrieving users from the database...");
			List<User> users = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				User user = new User(username, email, password);
				user.setId(id);

				users.add(user);
			}
			return users;
		} catch (Exception e) {
			logger.severe("Error occurred while retrieving users: " + e.getMessage());
			throw new RuntimeException("Something went wrong", e);
		}
	}
}
