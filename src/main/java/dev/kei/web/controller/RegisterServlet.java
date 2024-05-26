package dev.kei.web.controller;

import java.io.IOException;

import dev.kei.web.entity.User;
import dev.kei.web.service.UserService;
import dev.kei.web.util.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setAttribute("message", "this is message in register");
		getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService userService = new UserService();

		String username = request.getParameter("username");

		String password = PasswordUtil.hashPassword(request.getParameter("password"));
		String email = request.getParameter("email");

		User user = new User(username, email, password);

		userService.save(user);
		response.sendRedirect("login.jsp");
	}
}
