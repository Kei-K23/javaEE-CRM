package dev.kei.web.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.kei.web.db.DB;
import dev.kei.web.entity.User;

public class UserRepository {

	public List<User> findAll() {
		try (Connection connection = DB.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM users");

		) {
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
			throw new RuntimeException("Something went wrong");
		}
	}
}
