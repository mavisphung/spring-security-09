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
<title>Access Denied</title>
<style type="text/css">
	.deny {
		color: red;
	}
</style>
</head>
<body>
	<h2 class="deny">ACCESS DENIED</h2>
	<hr>
	<p>
		You don't have permission to access
	</p>
	
	<hr>
	<a href="${pageContext.request.contextPath}/">Back to home page</a>
</body>
</html>