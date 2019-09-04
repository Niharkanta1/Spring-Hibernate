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
<hr>
<security:authorize access="hasRole('MANAGER')">
	<a href="${pageContext.request.contextPath}/leader">Link for Managers only</a><br />
	<hr />
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
	<a href="${pageContext.request.contextPath}/system">Link for ADMIN Users only</a><br />
	<<hr />
</security:authorize>
<br />
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
</form:form>
</body>
</html>