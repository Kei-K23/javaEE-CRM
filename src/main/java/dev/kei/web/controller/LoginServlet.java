package dev.kei.web.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setMaxInactiveInterval(60 * 60 * 24);
			response.sendRedirect("account.jsp");
		} else {
			request.setAttribute("errorMsg", "Invalid username or password");
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
