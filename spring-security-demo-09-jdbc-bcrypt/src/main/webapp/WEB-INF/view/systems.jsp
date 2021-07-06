<!-- encode cho jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- spring form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home Page</title>
</head>
<body>
	<h2>ADMIN Home Page</h2>
	<hr>
	<p>
		See you Vietnam... for our annual Leadership retreat!
		<br>
		Shhhhhh... It's secret, only ADMIN know when it's burning low
	</p>
	
	<hr>
	<a href="${pageContext.request.contextPath}/">Back to home page</a>
</body>
</html>