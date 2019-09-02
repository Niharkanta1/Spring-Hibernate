<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Form</title>
</head>
<body>
<fieldset>
<legend>Student Form</legend>
	<form:form action="processForm" modelAttribute="student">
	<table>
	<tr><td>First Name: </td><td><form:input path="firstName"/></td></tr>
	<tr><td>Last Name: </td><td><form:input path="lastName"/></td></tr>
	<%-- 
	<form:select path="country">
		<form:option value="Australia"></form:option>
		<form:option value="Brazil"></form:option>
		<form:option value="India"></form:option>
		<form:option value="Pakistan"></form:option>
		<form:option value="United States"></form:option>
	</form:select>
	 --%>
	<tr><td>Country: </td><td><form:select path="country">
		<form:options items="${ countryOptions }"/> <!-- using properties file -->
	</form:select></td></tr>
	<tr>
		<td>Favorite Language: </td>
		<td>
		<%-- 
			<form:radiobutton path="favoriteLang" value="Java"></form:radiobutton>Java
			<form:radiobutton path="favoriteLang" value="PHP"></form:radiobutton>PHP 
			<form:radiobutton path="favoriteLang" value="Python"></form:radiobutton>Python 
			<form:radiobutton path="favoriteLang" value="Ruby"></form:radiobutton>Ruby 
			 --%>
			<form:radiobuttons path="favoriteLang" items="${ student.favoriteLanguageList }"/>
		</td>
	</tr>
	<tr>
		<td>Operating System: </td>
		<td>
			<form:checkboxes items="${ OSList }" path="operatingSystems"/>
		</td>
	</tr>
	<tr><td></td><td><input type="submit" name="submit" id="submit" value="Submit"/></td></tr>
	</table>
	</form:form>
</fieldset>
</body>
</html>