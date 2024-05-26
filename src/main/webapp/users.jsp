<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
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
	<h1 class="text-center">Manage Users</h1>
	<table class="mt-4 table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Username</th>
				<th scope="col">Email</th>
				<th scope="col">Role</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>
						<c:choose>
							<c:when test="${user.role == 1}">
								Admin
							</c:when>
							<c:otherwise>
								User
							</c:otherwise>
						</c:choose>
					</td>
					<td>
					<form action="/web1/users" method="post">
						<input name="type" value="delete" type="hidden" />
						<input name="id" value="${user.id}" type="hidden" />
						<button type="submit">Delete</button>
					</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
