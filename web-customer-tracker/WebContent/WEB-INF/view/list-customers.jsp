<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>
    <div class="row">
        <div class="span8 offset2">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>               
                    <c:forEach items="${customers}" var="customer">
                        <tr>
                            <td>${ customer.firstName }</td>
                            <td>${ customer.lastName }</td>
                            <td>${ customer.email }</td>
                            <td><a href="#" title="Edit">
          					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
        					</a>&nbsp;
        					<a href="#" title="Edit">
         					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
        					</a>
        					</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="../customer/add-customer" role="button" class="btn btn-primary">Add Customer</a>
        </div>
    </div>  
    <script type="text/javascript"></script>
<jsp:include page="footer.jsp"/>