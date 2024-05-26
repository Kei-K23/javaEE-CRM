package dev.kei.web.controller;

import java.io.IOException;
import java.util.List;

import dev.kei.web.entity.User;
import dev.kei.web.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();

		// Retrieve user data from UserService
		List<User> users = userService.findAll(); // Assuming you have a method getAllUsers() in your UserService

		// Set users as an attribute in the request object
//		request.setAttribute("users", users);
//
//		// Forward the request to the JSP for rendering
//		request.getRequestDispatcher("/users.jsp").forward(request, response);

		// Convert user data to JSON using Gson library

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
