<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <c:forEach var="product" items="${listProduct}">
	<div class="card">
	  <div class="card-header">
	    Featured
	  </div>
	  <div class="card-body">
	    <h5 class="card-title">Special title treatment</h5>
	    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
	    <a href="#" class="btn btn-primary">Go somewhere</a>
	  </div>
	</div>
 </c:forEach>
</body>
</html>