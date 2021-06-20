<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<%@ include file="navbar.jsp"%>
<body>
	<c:forEach var="order" items="${listOrder}">
		<div class="accordion accordion-flush mx-3" id="accordionFlushExample">
			<div class="accordion-item">
				<h2 class="accordion-header" id="flush-heading">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#flush-collapse${order.id}"
						aria-expanded="false" aria-controls="flush-collapse${order.id}">
						Order: ${order.id} --- User: ${order.user.username}</button>
				</h2>
				<div id="flush-collapse${order.id}" class="accordion-collapse collapse"
					aria-labelledby="flush-heading"
					data-bs-parent="#accordionFlushExample">
					<div class="accordion-body">
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>