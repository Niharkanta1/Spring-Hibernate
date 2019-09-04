<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security Home</title>
</head>
<body>
<h3>Welcome to Spring Security Demo</h3>
<hr>
<p>
User: <security:authentication property="principal.username"/><br />
Roles: <security:authentication property="principal.authorities"/>
</p>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
</form:form>
</body>
</html>