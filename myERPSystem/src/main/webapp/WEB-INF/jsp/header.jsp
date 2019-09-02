<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/home">Home</a></li>
        <li><a href="/about">About</a></li>
        <li><a href="/jobs">Jobs</a></li>
        <li><a href="/contact">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <% if (session.getAttribute("userId") == null) { %>
        <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      <% } else {%>
      	 <li><a href="/logoff"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
	  <% } %>
      </ul>
    </div>
  </div>
</nav>
 