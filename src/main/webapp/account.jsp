<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account</title>
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
<body>
	<h1>Welcome to Your Account</h1>
	<c:choose>
		<c:when test="${not empty sessionScope.username}">
			<p>Welcome, ${sessionScope.username}!</p>
			 <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Logout</a>
		</c:when>
		<c:otherwise>
			<p>
				You are not logged in. <a
					href="${pageContext.request.contextPath}/login.jsp">Login here</a>.
			</p>
		</c:otherwise>
	</c:choose>
</body>
</html>
