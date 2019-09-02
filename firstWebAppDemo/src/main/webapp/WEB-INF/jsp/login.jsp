<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<font color="red">${errorMessage}</font>
    <form method="post"><div class="box">
    <h1>Login Screen</h1>
    <table>
      <tr><td>UserName:</td><td><input type="text" name="userId"  class="email" /></td></tr>
      <tr><td>Password:</td><td><input type="password" name="password" class="password"/></td></tr> 
      <tr><td><input type="submit" value="Sign In" class="btn"/></td><td><a href="/signUp"><div id="btn2">Sign Up</div></a></td></tr>
    </table></div>
    </form>
    <p>Forgot your password? <u style="color:#f1c40f;">Click Here!</u></p>
</body>
</html>