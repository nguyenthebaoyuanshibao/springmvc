<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
    <spring:url value="/user/register" var="registerURL" />
    <form:form action="${registerURL }" modelAttribute="userForm" method="post" align="center">
     
        <table align="center">
            <tr>
                <td>UserId: </td>
                <td><input type ="text" name="userId"></td>
            </tr>
            
            <tr>
                <td> Password: </td>
                <td><input type ="password" name="password"></td>
            </tr>
            
            <tr>
                <td>Confirm Password: </td>
                <td> <input type ="password" name="confirmPassword"> </td>
            </tr>
         
        </table>
            <button type="submit">Sign up</button>
    </form:form>    

</body>
</html>