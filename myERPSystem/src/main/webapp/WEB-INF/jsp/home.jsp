<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file = "meta.jsp" %>
<title>Home Page</title>
<%@ include file = "header.jsp" %>
</head>
<body>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="#">Exams and Schedules</a></p>
      <p><a href="#">Attendance Tracking</a></p>
      <p><a href="#">My Information</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Welcome ${firstName}!</h1>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
  </div>
</div>
</body>
<%@ include file = "footer.jsp" %>
</html>