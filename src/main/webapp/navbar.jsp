<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</head>

<nav class="navbar navbar-expand-lg navbar-dark navbar-inverse bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">E Commerce</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggler" aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarToggler">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}">Home</a>
        </li>
      </ul>
      <div class="d-flex mb-lg-0">
	    <% String username = (String)session.getAttribute("username"); %>
	    <c:choose>
		    <c:when test='${username == null}'>
		        <a style="" href="${pageContext.request.contextPath}/login"><button class="btn btn-light ms-3">Login</button></a>
		    	<a href="${pageContext.request.contextPath}/Register"><button class="btn btn-light ms-3">Register</button></a>
		    </c:when>
		    <c:otherwise>
		        <a href="${pageContext.request.contextPath}/Logout"><button class="btn btn-light ms-3">Logout</button></a>
		    </c:otherwise>
		</c:choose>
    	</div>
    </div>
  </div>
</nav>
</html>