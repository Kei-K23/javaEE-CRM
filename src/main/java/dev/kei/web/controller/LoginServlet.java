package dev.kei.web.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("jack") && password.equals("password")) {
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
			response.sendRedirect("account.jsp");
		} else {
			request.setAttribute("errorMsg", "Invalid username or password");
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
