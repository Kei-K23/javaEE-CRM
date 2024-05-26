package dev.kei.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import dev.kei.web.entity.User;
import dev.kei.web.repository.UserRepository;
import dev.kei.web.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserRepository.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			logger.info("here 1");
			String usernameString = (String) session.getAttribute("username");
			if (usernameString != null) {
				logger.info("here 2");
				UserService userService = new UserService();

				User user = userService.findByUsername(usernameString);
				if (user.getRole() == 1) {
					logger.info("here 3");
					// Retrieve user data from UserService
					List<User> users = userService.findAll();

					if (users.size() <= 0) {
						response.sendRedirect("login.jsp");
					}

					// Set users as an attribute in the request object
					request.setAttribute("users", users);

					// Forward the request to the JSP for rendering
					request.getRequestDispatcher("/users.jsp").forward(request, response);
				}

			}
		}
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();

		String type = request.getParameter("type");
		int id = Integer.parseInt(request.getParameter("id"));
		if (type.equals("delete")) {
			userService.delete(id);
		}

		request.getRequestDispatcher("/users.jsp").forward(request, response);
	}
}
