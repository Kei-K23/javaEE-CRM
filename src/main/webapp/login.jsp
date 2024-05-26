<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body class="p-5">
	<h1 class="text-center">Login</h1>
	<c:choose>
		<c:when test="${not empty errorMsg}">
			<div class="alert alert-danger" role="alert">${errorMsg}</div>
		</c:when>
	</c:choose>
	<form action="/web1/login" method="post">
		<div class="mb-3">
			<label for="user" class="form-label">Username</label> <input
				type="text" name="username" min="3" required class="form-control"
				id="user" placeholder="e.g jack">
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password</label> <input
				type="password" name="password" min="6" required
				class="form-control" id="password" placeholder="Enter you password" />
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
	</form>
	<a href="/web1/register">New user? Register here</a>
</body>
</html>