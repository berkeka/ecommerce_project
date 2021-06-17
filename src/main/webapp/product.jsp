<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="navbar.jsp" %>
<body>
	<h1>${product.productName}</h1>
	<h2>${product.productPrice}</h2>
</body>
</html>