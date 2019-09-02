<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file = "meta.jsp" %>
<%@ include file = "header.jsp" %>
<title>Login Page</title>
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
      
	<div align="center">
	<font color="red">${errorMessage}</font>
    <form method="post">
    <h1>Login Screen</h1>
    <table class="table-responsive">
      <tr><td>UserName:</td><td><input type="text" name="userId"  class="email" /></td></tr>
      <tr><td>Password:</td><td><input type="password" name="password" class="password"/></td></tr> 
      <tr><td><input type="submit" value="Sign In" class="btn btn-info"/></td><td><a href="/signUp" class="btn btn-info" role="button">Sign Up</a></td></tr>
    </table></div>
    </form>
    <p align="center">Forgot your password? <u style="color:#f1c40f;">Click Here!</u></p>
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