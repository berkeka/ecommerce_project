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
	 <c:forEach var="product" items="${listProduct}" varStatus="itemloop">
	 	<c:if test="${itemloop.index % 3 == 0}">
			  <div class="row justify-content-md-center">
	 	</c:if>
	     <div class="col-md-auto">
	      <div class="card m-4" style="width: 18rem;">
			  <div class="card-body">
			    <h5 class="card-title">${product.productName}</h5>
			    <h6 class="card-subtitle mb-2 text-muted">${product.productPrice}</h6>
			    <a href="${pageContext.request.contextPath}/Product?prod_id=${product.id}" class="product-link">Product Page</a>
			  </div>
			</div>
    	  </div>
    	<c:if test="${itemloop.index % 3 == 2 || listProduct.size() == itemLoop.index}">
			</div>
	 	</c:if>
	 </c:forEach>
</div>
<div class="col d-flex justify-content-center fixed-bottom">
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