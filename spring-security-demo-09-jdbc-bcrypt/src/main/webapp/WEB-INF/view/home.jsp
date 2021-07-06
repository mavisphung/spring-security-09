<!-- encode cho jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- spring form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- spring security -->
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>HuyPC Company Home Page</h2>
	<hr>
	Chào mừng đến với HuyPC.
	<br>
	<p>
		User:
		<security:authentication property="principal.username" />
	</p>
	<p>
		Roles:
		<security:authentication property="principal.authorities" />
	</p>

	<hr>

	<security:authorize access="hasRole('MANAGER')">
		<!-- thêm đường dẫn đến /leaders cho managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a> (Only for Manager users)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<!-- thêm đường dẫn đến /systems cho admin -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Admin
				Meeting</a> (Only for Admin users)
		</p>
	</security:authorize>

	<hr>
	<br>
	<!-- logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>