<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access Denied</title>
</head>
<body>
    <h1>Access Denied! </h1>
    <p>
			       <a href=" <spring:url value=  "/home"/> " class="btn btn-primary"> 
				        <span class="glyphicon-info-sign glyphicon" /></span> back
				  </a>
			 </p>
</body>
</html>