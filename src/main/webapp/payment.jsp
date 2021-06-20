<html>
<%@ include file="navbar.jsp"%>
<%
String error = (String) request.getAttribute("error");
%>
<c:if test="${error != null}">
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<%=error%>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
</c:if>
<div class="container-fluid">
	<div class="row d-flex justify-content-center">
		<div class="col-sm-12">
			<div class="card mx-auto">
				<p class="heading">PAYMENT DETAILS</p>
				<form class="card-details">
					<div class="form-group mb-0">
						<p class="text-warning mb-0">Card Number</p>
						<input type="text" name="card-num" size="17" id="cno"
							minlength="19" maxlength="19"> <img
							src="https://img.icons8.com/color/48/000000/visa.png"
							width="64px" height="60px" />
					</div>
					<div class="form-group">
						<p class="text-warning mb-0">Cardholder's Name</p>
						<input type="text" name="name" size="17">
					</div>
					<div class="form-group pt-2">
						<div class="row d-flex">
							<div class="col-sm-4">
								<p class="text-warning mb-0">Expiration</p>
								<input type="text" name="exp" placeholder="MMYYYY" size="7"
									id="exp">
							</div>
							<div class="col-sm-3">
								<p class="text-warning mb-0">Cvc</p>
								<input type="password" id="cvc" name="cvv" size="1"
									minlength="3" maxlength="3">
							</div>
							<div class="col-sm-2 pt-0">
								<input class="btn btn-primary" value="Checkout"
									style='width: 10em' onclick="checkCard()">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');

body {
	background: gray;
	font-family: 'Roboto', sans-serif
}

.card {
	border: none;
	max-width: 450px;
	border-radius: 15px;
	margin: 150px 0 150px;
	padding: 35px;
	padding-bottom: 20px !important
}

.heading {
	color: #C1C1C1;
	font-size: 14px;
	font-weight: 500
}

img {
	transform: translate(160px, -10px)
}

img:hover {
	cursor: pointer
}

.text-warning {
	font-size: 12px;
	font-weight: 500;
	color: #edb537 !important
}

#cno {
	transform: translateY(-10px)
}

input {
	border-bottom: 1.5px solid #E8E5D2 !important;
	font-weight: bold;
	border-radius: 0;
	border: 0
}

.form-group input:focus {
	border: 0;
	outline: 0
}

.col-sm-5 {
	padding-left: 90px
}

.btn:focus {
	box-shadow: none
}
</style>

<script type="text/javascript">
	function getValue(id) {
		return (escape(document.getElementById(id).value));
	}

	function htmlInsert(id, htmlData) {
		document.getElementById(id).innerHTML = htmlData;
	}

	function getRequestObject() {
		if (window.XMLHttpRequest) {
			return (new XMLHttpRequest());
		} else if (window.ActiveXObject) {
			return (new ActiveXObject("Microsoft.XMLHTTP"));
		} else {
			return (null);
		}
	}

	function ajaxPost(address, data, responseHandler) {
		var request = getRequestObject();

		request.onreadystatechange = function() {
			responseHandler(request);
		};
		request.open("POST", address, true);
		request.setRequestHeader("Content-Type", "application/json");
		request.send(data);
	}

	function ajaxPostForm(address, data, responseHandler) {
		var request = getRequestObject();

		request.onreadystatechange = function() {
			responseHandler(request);
		};
		request.open("POST", address, true);
		request.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		request.send(data);
	}

	function checkCard() {
		var address = "rest/debit/check";
		var data = '{"id":' + getValue("cno") + ',"date":' + getValue("exp")
				+ ',"cvc":' + getValue("cvc") + "}";

		ajaxPost(address, data, function(request) {
			if (request.readyState == 4) {
				switch (request.status) {
				case (400):
					alert("Fields cant be empty!");
					break;
				case (200):
					//ok
					var res = request.response;
					var json = JSON.parse(res);
					if (json.cardExists == true && json.transaction == true) {
						createOrder();
					} else {
						alert("Credit card is invalid!");
					}
				}
			}
		});
	}

	function createOrder() {
		var address = "Payment";
		var data = "id=" + getValue("cno") + "&date=" + getValue("exp")
				+ "&cvc" + getValue("cvc");

		ajaxPostForm(address, data, function(request) {
		});
	}
</script>
</html>