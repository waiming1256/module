<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<body>
    <%@ include file="header.jsp"%>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-8 text center">

                <form:form action="save" method="post" modelAttribute="user">
                    <div class="form-group">
                        <label for="username">Your Full Name:</label>
                        <form:input path="name" class="form-control" required="true"/>
                    </div>
				
                    <div class="form-group">
                        <label for="username">Your Login User Name:</label>
                        <form:input path="userName" class="form-control" required="true"/>
                        
                    </div>
				
				
                    <div class="form-group">
                        <label for="password">Your Password:</label>
                        <form:password path="password" class="form-control" required="true"/>
                        
                    </div>
				
				    <input type="submit" value="Register" class="btn btn-primary"/>
					
			    </form:form>

			</div>
            
        </div>
    </div>


</body>

