<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Users List</title>
</head>
<body>
    <p>
			       <a href=" <spring:url value=  "/logout"/> " class="btn btn-primary"> 
				        <span class="glyphicon-info-sign glyphicon" /></span> Logout
				  </a>
    </p>
    <br/>
    <p>
			       <a href=" <spring:url value=  "/products"/> " class="btn btn-primary"> 
				        <span class="glyphicon-info-sign glyphicon" /></span> OurPages
				  </a>
   </p>
    <table border="1">
        <tr>
            <td>UserId</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${list }" var="user" >
            <tr>
                <td>${user.userId }</td>
                <td>
                    <spring:url value="/user/changePass" var="changePassURL" />
                    <a href="${changePassURL }/${user.userId}">ChangePass</a>
                </td>
                
                 <td>
                    <spring:url value="/user/removeUser" var="removeUserURL" />
                    <a href="${removeUserURL }/${user.userId}">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>