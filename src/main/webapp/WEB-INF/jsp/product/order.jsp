<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Page</title>
</head>
<body>
   <h1> 
   
        <p> 
             Welcome to order page!
             <br/>
             <a href="<spring:url value="/products" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> back
					</a>
        </p>
   </h1>
</body>
</html>