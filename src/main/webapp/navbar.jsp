<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}">E Commerce</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    
    <% String username = (String)session.getAttribute("username"); %>
   
    <c:choose>
	    <c:when test='${username == null}'>
	        <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    	<li><a href="${pageContext.request.contextPath}/Register"><span class="glyphicon glyphicon-user"></span>Register</a></li>
	    </c:when>
	    <c:otherwise>
	        <li><a href="${pageContext.request.contextPath}/Logout"><span class="glyphicon glyphicon-user"></span>Logout</a></li>
	    </c:otherwise>
	</c:choose>
    </ul>
  </div>
</nav>
</html>