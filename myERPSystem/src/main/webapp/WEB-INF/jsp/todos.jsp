<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>To Do List</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<h2>TO DO List</h2>
<form method="post">
<table class="centerTable">
  <tr>
    <th>ToDo</th> 
    <th>Target Date</th>
    <th>Status</th>
  </tr>
 <c:choose>
 <c:when test="${not empty todos}">
 <c:forEach var="todo" items="${todos}">
  <tr>
    <td><c:out value = "${todo.desc}"/></td> 
    <td><c:out value = "${todo.targetDate}"/></td>
    <td><c:out value = "${todo.status ? 'Done' : 'Not Done'}"/></td> 
  </tr>
 </c:forEach>
 </c:when>
 <c:otherwise>
	<tr><font color="red">No Data Found</font></tr>
 </c:otherwise>
 </c:choose>
 <tr>
    <td><input name="desc" type="text" required="required"/></td> 
    <td><input name="targetDate" type="date" required="required"/></td>
    <td><input name="status" type="checkbox">Done</input></td> 
  </tr>
</table>
<p align="center"><input name="addToDo" type="submit" value="Add ToDo">&nbsp <a href="/list-todos">Back</a></p>
</form>    
</body>
</html>