<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>
    <div class="row">
        <div class="span8 offset2">
			<nav class="navbar navbar-light bg-light">
			  <form class="form-inline" action="searchCustomer">
			   <input class="form-control" name="searchName" value="${searchName}" type="search" placeholder="Search Customer Name" aria-label="Search">
			   <button class="btn btn-info" type="submit">Search</button>
			 </form>
			</nav>        	
        	<table class="table table-bordered table-striped">
        	<caption>Customer List</caption>
                    <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="customers.lenght == 0">
                    	<div class="alert alert-danger">
 						 <strong>Danger!</strong> No data found.
						</div>
                    </c:if>               
                    <c:forEach items="${customers}" var="customer">
                    	<c:url var="updateLink" value="../customer/showFormForUpdate">
                    		<c:param name="customerId" value="${customer.id}"></c:param>
                    		<c:param name="editFlag" value="true"></c:param>
                    	</c:url>
                    	<c:url var="deleteLink" value="../customer/deleteCustomer">
                    		<c:param name="customerId" value="${customer.id}"></c:param>
                    	</c:url>
                        <tr>
                            <td>${ customer.firstName }</td>
                            <td>${ customer.lastName }</td>
                            <td>${ customer.email }</td>
                            <td><a href="${ updateLink }" title="Edit">
          					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
        					</a>&nbsp;|&nbsp;
        					<a href="${ deleteLink }" title="Delete" onclick="confirmDelete();">
         					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
        					</a>
        					</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="../customer/add-customer?editFlag=0" role="button" class="btn btn-primary">Add Customer</a>
                <br />
                <br />
        </div>
    </div>  
    <script type="text/javascript">
    function confirmDelete(){
    	if(!confirm('Are you suer you want to delete this customer?'))
    		return false;
    	else
    		return true;
    }
    
    function confirmDelete(){
    	if(!confirm('Are you suer you want to delete this customer?'))
    		return false;
    	else
    		return true;
    }
    
    </script>
<jsp:include page="footer.jsp"/>