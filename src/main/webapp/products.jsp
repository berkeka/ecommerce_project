<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<div class="m-4">
	 <c:forEach var="product" items="${listProduct}">
	<div class="card m-4" style="width: 18rem;">
	  <div class="card-body">
	    <h5 class="card-title">${product.productName}</h5>
	    <h6 class="card-subtitle mb-2 text-muted">${product.productPrice}</h6>
	    <a href="#" class="card-link">Card link</a>
	  </div>
	</div>
	 </c:forEach>
	 
	 <nav aria-label="Page navigation">
	  <ul class="pagination">
	    <c:forEach begin="1" end='<%= Integer.parseInt(request.getAttribute("pageCount").toString())%>' varStatus="loop">
	    	<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/?currentPage=${loop.index}">${loop.index}</a></li>
		</c:forEach>
	  </ul>
	</nav>
</div>
</body>
</html>