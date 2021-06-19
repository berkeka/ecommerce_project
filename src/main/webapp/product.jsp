<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="navbar.jsp" %>
<body>
	<h1>${product.productName}</h1>
	<h2>${product.productPrice}</h2>
	
	<form>
		<input type="hidden" id="prod_id" name="prod_id" value="${product.id}">
		Product Count:  <input type="number" id="prod_count" name="prod_count" min="0" step="1" oninput="validity.valid||(value='');"><br>
		<input type="button" value="Add to Cart" onclick='addToCart()'>
	</form>
</body>
<script>

	function getValue(id){
		return(escape(document.getElementById(id).value));
	}
	
	function htmlInsert(id, htmlData){
		document.getElementById(id).innerHTML = htmlData;
	}
	
	function getRequestObject(){
		if(window.XMLHttpRequest){
			return(new XMLHttpRequest());
		} 
		else if (window.ActiveXObject){
			return (new ActiveXObject("Microsoft.XMLHTTP"));
		}
		else{
			return(null);
		}
	}
	
	function ajaxPost(address, data, responseHandler){
		var request = getRequestObject();
		
		request.onreadystatechange = function() {responseHandler(request);};
		request.open("POST", address, true);
		request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		request.send(data);
	}
	
	function addToCart(){
		var address = "Cart";
		var data = "action=add" + "&prod_id=" + getValue("prod_id") + "&prod_count=" + getValue("prod_count");
	
		ajaxPost(address, data, function (request){});
	}
</script>
</html>