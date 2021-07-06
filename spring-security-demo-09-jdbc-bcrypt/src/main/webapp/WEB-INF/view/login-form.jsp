<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>
	<h3>My Custom Login Page</h3>
	<hr>
	<form:form action="${pageContext.request.contextPath}/authenticateUser" 
			   method="POST">
		<!-- Check error message -->
		<c:if test="${param.error != null}">
			<i class="error">Sorry! You entered invalid username or password.</i>
		</c:if>
		<!-- Check logout message -->
		<c:if test="${param.logout != null}">
			<i class="error">You have been logged out!</i>
		</c:if>
		<p>
			Username: <input type="text" name="username">
		</p>
		<p>
			Password: <input type="password" name="password">
		</p>
		<input type="submit" value="Login">
	</form:form>
</body>
</html>