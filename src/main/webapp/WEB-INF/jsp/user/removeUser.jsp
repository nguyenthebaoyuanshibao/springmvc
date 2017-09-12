<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Remove User</title>
</head>
<body>
    <spring:url value="/user/delete" var="deleteURL" />
    <form:form method ="post" modelAttribute="user" action="${deleteURL }" >
    <form:hidden path="userId" />
        <table border="1">
             <tr>
                 <td colspan="2">${msg }</td>
             </tr>
             
             <tr>
                 <td></td>
                 <td><button type="submit">Remove user</button></td>
             </tr>
        </table>
        <section>
            <div>
                <td>
                    <p>
			           <a href=" <spring:url value=  "/user/list"/> " class="btn btn-primary"> 
				        <span class="glyphicon-info-sign glyphicon" /></span> Admin Page
				      </a>
			       </p>
                   
                </td>
            </div>
        </section>
    </form:form>

</body>
</html>