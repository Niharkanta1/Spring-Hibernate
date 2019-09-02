<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Form</title>
<style>
	.error
	{
		color: red;
	}
</style>
</head>
<body>
<fieldset>
	<legend>Customer Registration Form</legend>
	<form:form action="processForm" modelAttribute="customer">
	<table>
	<tr>
		<td>First Name:</td>
		<td><form:input path="firstName" /></td>
		<td></td>
	</tr>
	<tr>
		<td>Last Name:</td>
		<td><form:input path="lastName" /></td>
		<td><form:errors path="lastName" cssClass="error"/></td>
	</tr>
	<tr>
		<td>Free Passes:</td>
		<td><form:input path="freePasses" /></td>
		<td><form:errors path="freePasses" cssClass="error"/></td>
	</tr>
	<tr>
		<td>Postal Code:</td>
		<td><form:input path="postalCode" /></td>
		<td><form:errors path="postalCode" cssClass="error"/></td>
	</tr>
	<tr>
		<td>Course Code:</td>
		<td><form:input path="courseCode" /></td>
		<td><form:errors path="courseCode" cssClass="error"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Submit"/></td>
		<td></td>
	</tr>
	</table>
	</form:form>
</fieldset>
</body>
</html>