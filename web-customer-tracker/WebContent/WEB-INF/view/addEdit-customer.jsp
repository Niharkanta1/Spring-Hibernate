<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>
    <div class="row justify-content-center">
        <div class="col-md-6">
			<c:choose>
			    <c:when test="${param.editFlag} == 1">
			        <h4> Edit Customer </h4> 
			        <br />
			    </c:when>    
			    <c:otherwise>
			        <h4> Add Customer </h4> 
			        <br />
			    </c:otherwise>
			</c:choose>       
        
        <form:form action="saveCustomer?editFlag=${param.editFlag}" method="POST" modelAttribute="customer">
        	<form:hidden path="id"/>
             <div class="form-group">
             	<label for="firstName">First Name</label>
             	<form:input type="text"  id="firstName" class="form-control" path="firstName"/>
             </div>
             <div class="form-group">
             	<label for="lastName">Last Name</label>
             	<form:input type="text"   id="lastName" class="form-control" path="lastName"/>
             </div>
             <div class="form-group">
             	<label for="email">Email</label>
             	<form:input type="text" id="email" class="form-control" path="email"/>
             </div>   
          	<input type="submit" value="Submit" class="btn btn-primary"/>
         </form:form>
        </div>
    </div>  
    <script type="text/javascript"></script>
<jsp:include page="footer.jsp"/>