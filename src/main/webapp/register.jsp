<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<%@ include file="navbar.jsp" %>
<body>
 <div class="container col-md-2 col-md-offset-5 col-sm-offset-1" style="overflow: auto">
  <% String error = (String)session.getAttribute("error"); %>
 <c:if test="${error != null}">
 	<div class="alert alert-danger alert-dismissible fade show" role="alert">
	  <%= error %>
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
 </c:if>
  <h1>Register Form</h1>
  <form action="<%=request.getContextPath()%>/Register" method="post">
   <div class="form-group mt-3">
    <label for="uname">User Name:</label> <input type="text"
     class="form-control" id="username" placeholder="User Name"
     name="username" required>
   </div>
   <div class="form-group mt-3">
    <label for="uname">Password:</label> <input type="password"
     class="form-control" id="password" placeholder="Password"
     name="password" required>
   </div>
   <div class="form-group mt-3">
    <label for="uname">First Name:</label> <input type="text"
     class="form-control" id="firstName" placeholder="First Name"
     name="firstName" required>
   </div>
   <div class="form-group mt-3">
    <label for="uname">Last Name:</label> <input type="text"
     class="form-control" id="lastName" placeholder="Last Name"
     name="lastName" required>
   </div>
   <button type="submit" class="btn btn-primary mt-3">Submit</button>
  </form>
 </div>
</body>
</html>